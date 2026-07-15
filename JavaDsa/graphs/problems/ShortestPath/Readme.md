# Shortest Path — My Pattern Notes

Everything in this folder sits on 3 axes. Once I place a new problem on all
3, the technique picks itself:

Folder names = the 3 axes. Not an accident, just kept it literal on purpose
so I never have to guess where a new problem goes.

---

## Axis 1 — graph type decides algorithm

| Graph | Algo | Why |
|---|---|---|
| Unweighted | BFS | level number = distance, for free, no comparisons needed |
| Weighted, non-negative | Dijkstra | greedy pop-closest-first, safe only because weights ≥ 0 |
| Weighted, negative allowed | Bellman-Ford | relax every edge V-1 times, brute force but survives negatives, catches negative cycles |
| Weighted DAG | Topo sort + 1 relaxation pass | topo order already guarantees predecessors are done first — no heap needed |
| All-pairs, small/dense | Floyd-Warshall | DP over "which node am I allowed to bounce through" |

The algorithm is just *how I prove a node's distance is final before using
it to relax neighbours*. That's it, that's the whole idea repeated 5 ways.

## Axis 2 — all nodes vs one destination

Same loop either way. Only difference: source→destination lets me `return`
the moment destination gets popped/finalized. If my loop logic looks
*different* between these two folders for the same algorithm, I did
something wrong — should just be an early-exit check.

---

## Axis 3 — the 5 query types

### 1. ShortestDistance
Just `dist[]`. Base case, no extra state.

### 2. PrintOneShortestPath
Add `parent[]`, set once — the moment a node is first finalized. Works
because in BFS/Dijkstra the *first* finalization is always via a shortest
path. Walk `parent[]` back from destination, reverse it, done.

### 3. CountShortestPaths — where things actually get interesting

---

## 🔑 THE PART I KEEP HAVING TO RE-DERIVE: finalize vs continue vs reprocess

This is the actual crux of "find all shortest paths" and I don't want to
forget the reasoning again, so writing it out properly.

**The trap:** plain BFS does `if (!visited[nbr]) { visit + enqueue }` and
nothing else. Once `visited[nbr] = true`, that node is dead to every future
neighbour that tries to reach it. Fine for distance. Kills counting/gold/
path-reconstruction, because a *second* parent at the same shortest distance
just gets silently ignored.

**The fix isn't "don't use visited[]".** The fix is realizing `visited[]`
has ONE job only: stop a node from being **re-enqueued / re-distanced**.
It should never be the gate on whether I'm allowed to **merge data into**
that node. Two separate questions, one flag was doing both jobs — that's
the actual bug.

So the real shape is:

```java
if (!visited[nbr]) {
    // FIRST touch → this IS the shortest distance, lock it in
    visited[nbr] = true;
    dist[nbr] = dist[cur] + 1;
    ways[nbr] = ways[cur];          // or maxGold[nbr] = curGold+gold[nbr], or parents[nbr]=[cur]
    q.offer(nbr);
}
else if (dist[cur] + 1 == dist[nbr]) {
    // node already finalized distance-wise, but I'm ANOTHER
    // same-distance parent arriving slightly later → don't enqueue again,
    // just merge my contribution in
    ways[nbr] += ways[cur];          // count: add
    maxGold[nbr] = max(maxGold[nbr], curGold+gold[nbr]); // tie-break: take best
    parents[nbr].add(cur);           // all-paths: append predecessor
}
```

**When do I finalize?** Distance is final the instant a node is first
discovered — that never changes, that's BFS's whole guarantee.
**When do I keep processing a "visited" node?** Whenever
`dist[cur]+1 == dist[nbr]` — meaning I'm not late, I'm just a *different*
same-level parent. That check is literally what un-blocks the block.
**Why doesn't this need reprocessing / requeueing in plain BFS?**

This is the bit that took me a while to actually trust: BFS queue is FIFO,
and it's **level-contiguous** — every node at level k is enqueued (and
therefore will be popped) before any node at level k+1 gets popped. So when
node C (level k+1) gets discovered by parent A, C just sits in the queue.
Every OTHER level-k node — B, D, whoever — is guaranteed to get its turn to
be popped and checked against C *before* C itself ever gets popped and
starts processing its own children. By the time C is finally dequeued, its
`ways[]`/`maxGold[]`/`parents[]` already has every possible contribution
baked in. No reprocessing needed — the ordering does the work for me.

**So "no blocking happens in merge" isn't magic — it's because the `else if`
branch runs on every pop regardless of visited, and FIFO+level-contiguity
guarantees all contributions land before the node is read for propagation.**
That's the whole trick. visited[] blocks re-*enqueue*, never blocks
re-*read*.

**Where this guarantee breaks (and reprocessing becomes necessary):**
Dijkstra's min-heap does NOT guarantee level-contiguous pop order the way a
FIFO queue does for unweighted BFS. Two same-distance nodes can pop in
either order relative to their shared children, and there's no "level"
concept holding things together. So the merge-only trick isn't safe there —
this is exactly why the general fix is **Relaxation + Reprocess**: drop
`visited[]` entirely, and whenever a strictly better value shows up at an
equal (or better) distance, shove the node back in the queue/heap so its
downstream children get a second chance to be relaxed with the improved
value. It's slower (nodes can be processed multiple times) but it's
correct regardless of pop order — no ordering assumption baked in.

**Delayed Visited is the halfway house.** Set `visited[]` only after an
*entire level* finishes instead of the instant a node is discovered. This
manually recreates the FIFO-level-contiguity guarantee that plain BFS gets
for free — so it fixes same-level races. But it does NOT fix cross-level
issues (a better value showing up after that level has already sealed and
moved on), which is exactly the gap Relaxation+Reprocess exists to close.
Good to implement once just to *feel* why it's not a complete answer on its
own.

**Summary table, the way I actually think about it now:**

| Technique | visited[] does what | re-enqueue when? | safe because |
|---|---|---|---|
| Merge | blocks re-enqueue only | never | FIFO + level-contiguous pop order (unweighted BFS only) |
| Delayed Visited | blocks re-enqueue, delayed by 1 level | never | manually recreates level-contiguity |
| Relaxation+Reprocess | doesn't exist | any time a better value appears | no ordering assumption needed — works for Dijkstra too |
| Parent technique | same as Merge | never | same guarantee as Merge, plus repoint parent[] on tie-break win |

### 4. PrintAllShortestPaths — collecting instead of counting

Same forward pass as #3, except instead of `ways[nbr] += ways[cur]` I do
`parents[nbr].add(cur)` — a **list** of predecessors, not a single
`parent[]`. Has to be a list because a node can legitimately have multiple
optimal parents (that's the whole point of "all" shortest paths).

Forward pass alone isn't enough though — `parents[]` only tells me who
*could* come before each node, not the actual sequences. Need a second
pass: **DFS backtrack from destination through `parents[]`**, branching
every time a node has more than one predecessor, until I hit source. Every
root-to-leaf path found this way is a valid shortest path.

Two-phase, and has to be two-phase — I can't enumerate paths *while* still
discovering predecessors, because a node's predecessor list isn't complete
until the whole forward pass is done (same finalize-before-read issue as
above, just at list-granularity instead of value-granularity).

### 5. ShortestDistanceWithTieBreaker
Basically #3's merge logic, just optimizing a value instead of counting —
covered in depth above since it's the same mechanism (`MaxGoldAmongShortestDistance`
implements all 4 techniques from the table above side by side, good to
compare their outputs against each other as a sanity check).

---

## Weighted-graph notes

**Dijkstra** — heap instead of queue, "finalized" = popped not enqueued.
Always guard stale heap entries:
```java
if (poppedDist > dist[node]) continue;
```
Same staleness idea as Relaxation+Reprocess above — Dijkstra basically *is*
that general relaxation technique with a heap standing in for the plain
queue.

**DAG** (`ShortestPathForAllNodesDagWeighted`) — topo order already gives
the "predecessors done first" guarantee, so single linear pass, no heap at
all. Cheapest of the whole family. Default answer whenever "no cycles" is
stated or implied.

**BellmanFord** (empty folder, todo) — negative weights / negative cycle
detection. Relax every edge V-1 times; a Vth pass that still improves
something = negative cycle exists.

**FloydWarshel** (empty folder, todo) — all pairs, small/dense graphs,
negative weights ok (not negative cycles). `dist[i][j]` improves by
allowing `k` as an intermediate stop, `k` in outer loop.

**ShortestPathWithConstraints** (empty folder, todo) — state becomes
`(node, extra_dim)` not just `node`. E.g. "cheapest flight, at most K
stops." Still BFS/Dijkstra, just over a bigger state space.
`NoOfWaysToArriveAtDestinationInShortTime` is basically a cousin of this
idea already.

---

## Decision order I actually use

1. All edges equal weight? → BFS. Else → 2.
2. Negative weights possible? → Bellman-Ford (or Floyd-Warshall if
   all-pairs + small). Else → 3.
3. Guaranteed DAG? → Topo + 1 relaxation pass. Else → Dijkstra.
4. One destination or all nodes? → early-exit on dest-pop, or don't.
5. What do I need back?
   - number → ShortestDistance
   - a route → PrintOneShortestPath (single parent[])
   - how many optimal routes → CountShortestPaths (merge, `ways[] +=`)
   - every optimal route → PrintAllShortestPaths (predecessor lists + DFS backtrack)
   - best secondary value among optimal routes → TieBreaker
     (Merge if unweighted BFS, Relaxation+Reprocess if Dijkstra/heap-based)

---

---

## One-liner to remember all of this by

**visited[] only ever blocks re-enqueue, never blocks re-read — the moment
I let those two things be the same flag, counting/all-paths/tie-breaker
logic quietly breaks.**
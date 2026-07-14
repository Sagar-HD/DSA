package graphs.problems.ShortestPath.Unweighted.BFS.SourceToDestination.ShortestDistanceWithTieBreaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;

/**
 * MaxGoldAmongShortestDistance
 */
//focous only on 1 st and 4 th method 2 nd and 3rd are just possibilities , 1 and 2 solves all bfs with multiple shortest ways problems
public class MaxGoldAmongShortestDistance {
    static class Pair{

        int node;
        int gold;
        int distance;
        public Pair(int node, int gold,int distance) {
            this.node = node;
            this.gold = gold;
            this.distance=distance;
        }
        
    }

    static int getMaxGoldMergeTechnique( ArrayList<ArrayList<Integer>> adjList,int[] gold,int source,int destinantion){
        int[] shortestDistances=new int[adjList.size()];
        int[] maxGold=new int[adjList.size()];
        
        for(int i=0;i<adjList.size();i++){
            shortestDistances[i]=Integer.MAX_VALUE;
        }

        boolean[] visited=new boolean[adjList.size()];
            Queue<Pair> q =new LinkedList<>();
            shortestDistances[source]=0;
            maxGold[source]=gold[source];
            visited[source]=true;
            q.offer(new Pair(source, gold[source],0));
            while(!q.isEmpty()){
                Pair curPair=q.poll();
                int curNode=curPair.node;
                int curGold=maxGold[curNode];// not taking gold from q bcs it may be updated by optimal in previous level
                //if it want to take gold from queue 1 have 2 options 
                //1.if i take gold value from queue i should enque this same again when its found in else part with optimal result
                //2. or else without considering visted i should enque nodes only when we have optimal gold if(curGold+neighBourGold>maxGold[neighbour])-> enque
                int curDistance=curPair.distance;
                
                for(int neighbour: adjList.get(curNode) ){
                    if(!visited[neighbour]){
                        visited[neighbour]=true;
                        shortestDistances[neighbour]=curDistance+1;
                        maxGold[neighbour]=curGold+gold[neighbour];
                        q.offer(new Pair(neighbour, curGold+gold[neighbour],curDistance+1));

                    }
                    else if(curDistance+1==shortestDistances[neighbour]){
                        if(curGold+gold[neighbour]>maxGold[neighbour]){
                            maxGold[neighbour]=curGold+gold[neighbour];
                        }

                    }




                }



            }
            if(shortestDistances[destinantion]!=Integer.MAX_VALUE){
                return maxGold[destinantion];
            }



        



   return -1;
    }

    /**
     * RELAXATION + REPROCESS TECHNIQUE
     * -----------------------------------------------------------------
     * No visited[] array at all.
     * A node is allowed to be enqueued MULTIPLE times, exactly like
     * Bellman-Ford / Dijkstra relaxation, whenever we find either:
     *   1. A shorter distance (only happens once per node in an
     *      unweighted graph — first time we touch it), or
     *   2. An EQUAL shortest distance but a strictly better maxGold.
     * That second case is what forces "reprocessing" — the node goes
     * back into the queue so that ITS neighbours can be relaxed again
     * with the improved gold value. This is why the queue can contain
     * a node more than once, and why this is closer to Dijkstra-style
     * relaxation than plain BFS.
     */
    static int getMaxGoldRelaxationWithReprocessingTechnique(ArrayList<ArrayList<Integer>> adjList, int[] gold, int source, int destination) {
        int n = adjList.size();
        int[] shortestDistances = new int[n];
        int[] maxGold = new int[n];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        shortestDistances[source] = 0;
        maxGold[source] = gold[source];
        q.offer(new Pair(source, gold[source], 0));

        while (!q.isEmpty()) {
            Pair curPair = q.poll();
            int curNode = curPair.node;
            int curDistance = curPair.distance;

            // Stale entry check: this pair was enqueued before a later,
            // better relaxation of curNode happened. Since we don't have
            // visited[] to block re-adds, we guard here instead —
            // otherwise we'd redo relaxation work with outdated gold.
            if (curDistance > shortestDistances[curNode]) {
                continue;
            }
            int curGold = maxGold[curNode];

            for (int neighbour : adjList.get(curNode)) {
                int newDistance = curDistance + 1;

                if (newDistance < shortestDistances[neighbour]) {
                    // first time we ever find a path to neighbour, or a shorter one
                    shortestDistances[neighbour] = newDistance;
                    maxGold[neighbour] = curGold + gold[neighbour];
                    q.offer(new Pair(neighbour, maxGold[neighbour], newDistance));
                } else if (newDistance == shortestDistances[neighbour]) {
                    if (curGold + gold[neighbour] > maxGold[neighbour]) {
                        // equal-distance path but better gold -> update AND
                        // reprocess, since neighbour's own neighbours may
                        // now be relaxable with this improved gold value
                        maxGold[neighbour] = curGold + gold[neighbour];
                        q.offer(new Pair(neighbour, maxGold[neighbour], newDistance));
                    }
                }
            }
        }

        return shortestDistances[destination] != Integer.MAX_VALUE ? maxGold[destination] : -1;
    }

    /**
     * DELAYED VISITED TECHNIQUE
     * -----------------------------------------------------------------
     * Process the queue strictly level-by-level (classic level-order BFS).
     * A node discovered during level k is NOT marked visited until the
     * whole of level k has finished processing. This lets every same-level
     * parent that also points to that node contribute to its maxGold
     * before it's sealed off.
     *
     * Important teaching point: this alone is NOT equivalent to full
     * relaxation. It only fixes the ordering problem WITHIN a single
     * level. It still enqueues each node exactly once, so if a better
     * gold value becomes available only after the node's own level has
     * already been processed and moved past, that improvement is missed.
     * getMaxGoldRelaxationWithReprocessingTechnique fixes that gap by
     * allowing re-enqueue at any point, not just within the same level.
     */
    static int getMaxGoldDelayedVisitedTechnique(ArrayList<ArrayList<Integer>> adjList, int[] gold, int source, int destination) {
        int n = adjList.size();
        int[] shortestDistances = new int[n];
        int[] maxGold = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        shortestDistances[source] = 0;
        maxGold[source] = gold[source];
        visited[source] = true;
        q.offer(source);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            ArrayList<Integer> discoveredThisLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                int curNode = q.poll();
                int curGold = maxGold[curNode];
                int curDistance = shortestDistances[curNode];

                for (int neighbour : adjList.get(curNode)) {
                    if (!visited[neighbour]) {
                        if (shortestDistances[neighbour] == Integer.MAX_VALUE) {
                            // first discovery of neighbour this level
                            shortestDistances[neighbour] = curDistance + 1;
                            maxGold[neighbour] = curGold + gold[neighbour];
                            discoveredThisLevel.add(neighbour);
                        } else if (shortestDistances[neighbour] == curDistance + 1) {
                            // another same-level parent found before sealing -
                            // this merge only works because visited[] hasn't
                            // been set yet for this level's nodes
                            maxGold[neighbour] = Math.max(maxGold[neighbour], curGold + gold[neighbour]);
                        }
                    }
                }
            }

            // seal the whole level now that every same-level parent has
            // had a chance to merge gold into these nodes
            for (int node : discoveredThisLevel) {
                visited[node] = true;
                q.offer(node);
            }
        }

        return shortestDistances[destination] != Integer.MAX_VALUE ? maxGold[destination] : -1;
    }

    /**
     * PARENT TECHNIQUE
     * -----------------------------------------------------------------
     * Same merge logic as getMaxGoldMergeTechnique, but additionally
     * tracks parent[] so we can reconstruct and print the actual path
     * that achieves the maximum gold, not just the numeric answer.
     * Whenever we find an equal-distance neighbour with strictly better
     * gold, we don't just update maxGold — we also repoint parent[neighbour]
     * to curNode, since curNode is now the better route to neighbour.
     */
    static void printShortestPathWithMaximumGold(ArrayList<ArrayList<Integer>> adjList, int[] gold, int source, int destination) {
        int n = adjList.size();
        int[] shortestDistances = new int[n];
        int[] maxGold = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        shortestDistances[source] = 0;
        maxGold[source] = gold[source];
        visited[source] = true;
        q.offer(source);

        while (!q.isEmpty()) {
            int curNode = q.poll();
            int curGold = maxGold[curNode];
            int curDistance = shortestDistances[curNode];

            for (int neighbour : adjList.get(curNode)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    shortestDistances[neighbour] = curDistance + 1;
                    maxGold[neighbour] = curGold + gold[neighbour];
                    parent[neighbour] = curNode;
                    q.offer(neighbour);
                } else if (curDistance + 1 == shortestDistances[neighbour]) {
                    if (curGold + gold[neighbour] > maxGold[neighbour]) {
                        maxGold[neighbour] = curGold + gold[neighbour];
                        parent[neighbour] = curNode; // better route found, repoint parent
                    }
                }
            }
        }

        if (shortestDistances[destination] == Integer.MAX_VALUE) {
            System.out.println("No path exists");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int cur = destination;
        while (cur != -1) {
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) sb.append(" -> ");
        }
        System.out.println(sb.toString());
        System.out.println("Maximum Gold = " + maxGold[destination]);
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 2, 4 },
                { 3, 5 },
                { 4, 5 },
                { 5, 6 }
        };
        int[] gold = {
                5,
                10,
                100,
                20,
                40,
                10,
                5
        };
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildUndirectedGraph(n, edges);
        

        int source = 0;
        int destination = 6;
        System.out.println(getMaxGoldMergeTechnique(adjList, gold, source, destination));
        System.out.println(getMaxGoldDelayedVisitedTechnique(adjList, gold, source, destination));
        System.out.println(getMaxGoldRelaxationWithReprocessingTechnique(adjList, gold, source, destination));
        printShortestPathWithMaximumGold(adjList, gold, source, destination);

    }

}

/*
 * =====================================================================
 * PATTERN NOTES — MaxGoldAmongShortestDistance
 * =====================================================================
 *
 * The core problem this file solves: find the shortest distance from
 * source to destination in an UNWEIGHTED graph, and AMONG ALL PATHS
 * that achieve that shortest distance, return the one with maximum
 * gold. This is a "shortest path + tiebreaker optimization" pattern —
 * plain BFS is not enough because plain BFS finalizes a node's value
 * the moment it's first visited, but the OPTIMAL gold for that node
 * might come from a sibling path discovered slightly later.
 *
 * Why 3 different techniques exist for the same problem:
 * They differ in WHEN a node's value is allowed to be considered
 * "final", which is really the whole crux of this pattern.
 *
 * 1. getMaxGoldMergeTechnique
 *    - visited[] set immediately on first discovery (standard BFS).
 *    - But even after visited[]=true, if a same-distance neighbour
 *      arrives later in the queue, we still merge gold into it
 *      (the else-if branch). Visited only blocks re-enqueueing, not
 *      merging. This works BECAUSE plain BFS on an unweighted graph
 *      guarantees all same-distance nodes are processed contiguously
 *      enough that the merge condition (curDistance+1==shortestDistances)
 *      still catches them.
 *
 * 2. getMaxGoldRelaxationWithReprocessingTechnique
 *    - No visited[] at all — closer to Dijkstra/Bellman-Ford relaxation.
 *    - A node can be enqueued many times; every time a strictly better
 *      gold is found at an equal shortest distance, the node goes back
 *      into the queue so its neighbours get a chance to relax again.
 *    - Needs a staleness guard (curDistance > shortestDistances[curNode])
 *      to skip outdated queue entries cheaply.
 *    - Most robust of the three, but does more redundant work since
 *      the same node can be processed several times.
 *
 * 3. getMaxGoldDelayedVisitedTechnique
 *    - Classic level-order BFS. visited[] is set only after an ENTIRE
 *      level finishes, not the instant a node is discovered.
 *    - This lets multiple parents from the same level merge into a
 *      child before that child is sealed.
 *    - Deliberately included to show delayed-visited ALONE isn't a
 *      complete fix — it only solves the ordering problem inside one
 *      level, not across levels. Technique 2 is the general-purpose fix.
 *
 * 4. printShortestPathWithMaximumGold (Parent Technique)
 *    - Same shape as the merge technique, but also tracks parent[] and
 *      repoints it whenever a better equal-distance route is found.
 *    - Best for interviews: gives both the numeric answer AND a
 *      reconstructible path, which is usually what "print the path"
 *      follow-up questions are asking for.
 *
 * Expected output for the sample graph (source=0, destination=6):
 *   Path: 0 -> 2 -> 4 -> 5 -> 6
 *   Maximum Gold = 160  (5 + 10 + 20 + 40 ... wait, check against your
 *   actual gold[] values before trusting this number blindly — verify
 *   by running printShortestPathWithMaximumGold(adjList, gold, 0, 6)).
 *
 * All four should return/print the same maxGold value for destination
 * on any input graph — that agreement is a good self-check that your
 * implementations are consistent with each other.
 * =====================================================================
 */


/*







## Single shortest path
- BFS: first time a node is visited, it's already optimal (level order
  guarantees this). One `parent[]` write per node, done.
- Dijkstra: same idea, but "finalized" = popped from heap, not enqueued.
  First pop is guaranteed optimal for **positive** weights.

## Multiple shortest paths / count / tie-break — the part I kept messing up

**The fix that mattered:** `visited[]` has exactly one job — block
re-enqueue. It should never be the thing that decides whether I'm allowed
to merge new info into a node. Those are two different questions.
if (!visited[nbr]) {
// first touch = optimal distance, lock it in
visited[nbr] = true
dist[nbr] = dist[cur] + 1
ways[nbr] = ways[cur]                       // or gold/parents, depending on what I need
enqueue(nbr)
}
else if (dist[cur] + 1 == dist[nbr]) {
// already visited, but I'm a DIFFERENT same-distance parent arriving
// later — don't re-enqueue, just merge my contribution in
ways[nbr] += ways[cur]
// or: maxGold[nbr] = max(maxGold[nbr], curGold + gold[nbr])
// or: parents[nbr].add(cur)
}

**Why blocking doesn't actually block anything here:** in plain BFS the
queue is FIFO and level-contiguous — every node at level k gets popped
before any node at level k+1. So if node C is discovered by parent A and
enqueued, every other level-k parent of C (B, D, ...) is guaranteed to get
popped and hit the `else if` branch *before* C itself is ever popped and
starts propagating to its own children. By the time C is read, its
`ways[]`/`maxGold[]`/`parents[]` already has every contribution baked in.
**No reprocessing needed in plain BFS — ordering does the work for free.**

**Correction to my earlier notes:** I thought "mark visited only after the
level finishes" (Delayed Visited) was *the* technique required to get all
shortest paths. It's not required — it's a manual, heavier way to
re-create a guarantee plain Merge already gets for free from FIFO order.
Merge alone is sufficient for BFS. Good to know Delayed Visited exists as a
way to *see* the guarantee explicitly, but it's not a second necessary
technique.

**Where this breaks — and why Dijkstra genuinely needs reprocessing:**
Dijkstra's heap has no "level" concept and no FIFO guarantee. Two
same-distance nodes can pop in either order relative to their shared
children, so the "all parents pop before I do" guarantee is gone. That's
why Merge isn't safe there, and why the real fix for Dijkstra is:
if (!visited[nbr] OR dist[cur]+weight < dist[nbr] OR
(dist[cur]+weight == dist[nbr] AND better secondary value)) {
update dist/ways/gold/parents
push nbr back onto heap        // re-enqueue on improvement
}

No `visited[]` gate at all — just: does this arrival improve something?
If yes, push again. Terminates because both distance and secondary value
are bounded — only finitely many improvements are possible before the heap
drains on its own.


## All shortest paths (the actual "collect every path" version)
Two-phase, has to be two-phase:
1. Forward pass (same Merge logic as above), except instead of a single
   `parent[nbr]`, keep `parents[nbr] = list` — append every valid
   same-distance predecessor.
2. DFS backtrack from destination through `parents[]`, branching wherever
   a node has more than one predecessor, until reaching source. Every
   root-to-leaf trace is a valid shortest path.

Can't be done in one pass because a node's predecessor list isn't complete
until the whole forward pass finishes — same "don't read before it's
final" problem as everything else here, just at list-granularity.

## One-liner to not forget again
**`visited[]` blocks re-enqueue, never blocks re-read. In BFS that's all I
ever need — FIFO ordering guarantees every merge lands in time. In
Dijkstra, ordering isn't guaranteed, so I drop `visited[]` entirely and
reprocess on improvement instead.**

*/
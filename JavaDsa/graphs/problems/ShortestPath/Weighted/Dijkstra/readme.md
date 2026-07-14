# Dijkstra – Intuition & Thought Process

## Why doesn't BFS work for weighted graphs?

BFS works because every edge has the same cost (1).

```
A -- B -- C
```

Every neighbour discovered from the current level is equally good.

So BFS simply explores **level by level**.

```
Minimum edges = Minimum cost
```

As soon as edge weights become different,

```
A --10--> B
 \
  \
   1
    \
     C --1--> B
```

the first path reaching `B` may not be the cheapest.

So BFS can no longer assume

> **First arrival = Shortest path.**

---

# Why not use a normal Queue?

A natural idea is

```java
if (!visited[node]) {
    visited[node] = true;
    dist[node] = newDistance;
    q.offer(node);
}
else {
    if (newDistance < dist[node]) {
        dist[node] = newDistance;
    }
}
```

Updating only `dist[node]` is not enough.

Example

```
       10
A -------------> B -------------> D
 \
  \
   1
    \
     C -------------> B
```

Initially

```
dist[B] = 10
dist[D] = 11
```

Later

```
dist[B] = 2
```

Now `B` is cheaper.

But `D` still thinks

```
11
```

So whenever a node becomes cheaper,

its neighbours must also be processed again.

```java
if(newDistance < dist[node]){
    dist[node]=newDistance;
    q.offer(node);
}
```

This works,

but the same nodes may enter the queue many times.

---

# Why does a Priority Queue help?

A normal Queue processes

```
Arrival Order
```

A Priority Queue processes

```
Smallest Current Distance First
```

Example

```
      10
A ----------> B
 \
  \
   1
    \
     C
      \
       1
        \
         B
```

Normal Queue

```
Queue

B(10)
C(1)
```

`B(10)` is processed first.

Its neighbours are explored using a bad distance.

Later,

```
B = 2
```

is discovered,

so B and all its neighbours must be processed again.

---

Priority Queue

```
PQ

C(1)
B(10)
```

Now

```
B = 2
```

Priority Queue becomes

```
B(2)
B(10)
```

`B(2)` is processed first.

Later,

```
B(10)
```

is simply ignored because

```java
currentDistance > dist[node]
```

This avoids propagating bad distances.

---

# Dijkstra explores the Cheapest Frontier

Dijkstra does **NOT**

- explore level by level (BFS)
- explore one branch deeply (DFS)

It always expands the **currently cheapest frontier**.

Example

```
                (Dead End)

S
├──1──L1
│      │
│      1
│      L2
│      │
│     ...
│      │
│      1
│      L7
│
└──7──R1──1──Destination
```

Initially

```
PQ

L1(1)
R1(7)
```

Dijkstra keeps expanding

```
L1(1)

↓

L2(2)

↓

L3(3)

↓

...

↓

L7(7)
```

even though the destination is on the right.

Why?

Because it never asks

> "Which branch reaches the destination?"

It only asks

> **"Which discovered node currently has the smallest distance?"**

Only after the left branch finishes does it continue

```
R1(7)

↓

Destination(8)
```

The destination receives **no special treatment**.

---

# Is Dijkstra just BFS with a Priority Queue?

The implementation looks similar.

Both

- remove one node
- relax neighbours
- update distances

The difference is the ordering.

### BFS

```
Earliest discovered node
```

### Dijkstra

```
Smallest current distance
```

---

# When is a node finalized?

### BFS

```
Discover

↓

Shortest distance fixed
```

because

> First arrival is shortest.

---

### Dijkstra

```
Discover

↓

Distance may improve

↓

Priority Queue removes node

↓

Distance becomes final
```

because

> First **valid removal** from the Priority Queue is shortest.

---

# Why no infinite loop without visited[]?

A node enters the Priority Queue only if

```java
newDistance < dist[node]
```

Distances only decrease.

With non-negative edges,

they cannot decrease forever.

Example

```
20

↓

15

↓

8

↓

5

↓

2
```

Eventually no better distance exists.

Old Priority Queue entries become stale.

```
B(10)

B(5)

B(2)
```

When

```
B(2)
```

is processed,

later

```
B(5)

B(10)
```

are skipped.

```java
if(currentDistance > dist[node])
    continue;
```

Some implementations instead use

```java
visited[]
```

after removing a node from the Priority Queue.

Both approaches simply ignore stale entries.

---

# Why doesn't Dijkstra work with negative edges?

Dijkstra assumes

> **The first valid removal from the Priority Queue is final.**

Example

```
A ----2----> B
 \
  \
   5
    \
     C ----(-10)----> B
```

Priority Queue removes

```
B(2)
```

first.

Later

```
A → C → B = -5
```

is discovered.

The node was finalized too early.

Negative edges can produce a cheaper path **after** a node has already been finalized.

That breaks Dijkstra's greedy property.

---

# When should I use Dijkstra?

✅ Weighted graph

✅ Non-negative edge weights

✅ Single-source shortest path

---

# When should I NOT use Dijkstra?

❌ Negative edges

→ Bellman-Ford

❌ Negative cycle

→ No finite shortest path exists.

❌ All-pairs shortest path

→ Floyd-Warshall

---

# Shortest Path Decision Tree

```
Shortest Path

↓

All edge weights = 1 ?

YES
    ↓
    BFS

NO
    ↓
    Any negative edge?

        YES
            ↓
            Bellman-Ford

        NO
            ↓
            Dijkstra

↓

Need shortest path between every pair?

YES
    ↓
    Floyd-Warshall
```

---

# Complexity

| Algorithm | Complexity |
|-----------|------------|
| BFS | O(V + E) |
| Dijkstra | O((V + E) log V) |
| Bellman-Ford | O(VE) |
| Floyd-Warshall | O(V³) |

---

# Mental Model

### BFS

- Explores **level by level**
- Queue
- First discovery is shortest

---

### Dijkstra

- Explores the **cheapest frontier**
- Priority Queue
- First valid removal is shortest

---

### Bellman-Ford

- Relaxes every edge repeatedly
- Never finalizes a node early

---

# One-Line Summary

- **BFS** → Every edge has equal cost.
- **Dijkstra** → Always expand the cheapest reachable node.
- **Bellman-Ford** → Keep relaxing until nothing improves.
- **Floyd-Warshall** → Shortest paths between every pair of vertices.
# Kosaraju's Algorithm - Intuition from First Principles

## Problem

Given a **directed graph**, find all **Strongly Connected Components (SCCs).**

---

# Step 1: What is an SCC?

An SCC is a **maximal group of vertices** where every vertex can reach every other vertex.

In simple words,

> Every node can go to every other node.

Example:

```text
1 → 2
↑   ↓
4 ← 3
```

All four nodes can reach each other.

So,

```text
{1,2,3,4}
```

is one SCC.

---

# Step 2: What is special about SCCs?

Inside an SCC,

- Everyone can reach everyone.

Between different SCCs,

there may be paths,

but **there can never be cycles.**

Example

```text
SCC1 → SCC2
```

Possible.

But

```text
SCC1 ↔ SCC2
```

Impossible.

Why?

If SCC1 can reach SCC2

and SCC2 can reach SCC1,

then every node of SCC1 can reach every node of SCC2 and vice versa.

They should actually become one larger SCC.

Hence,

> **Different SCCs never form cycles.**

If we compress every SCC into one node,

we get

```text
SCC1 → SCC2 → SCC3
```

which is always a DAG.

---

# Step 3: The Main Difficulty

Suppose

```text
A ↔ B

↓

C ↔ D
```

If we simply run DFS from A,

it visits

```text
A
↓

B
↓

C
↓

D
```

DFS crosses into another SCC.

So one DFS alone cannot separate SCCs.

We need some way to stop DFS from leaking into another SCC.

---

# Step 4: Observe DFS Finishing Time

Consider

```text
1 → 2 → 3
```

DFS:

```text
visit 1
visit 2
visit 3
```

Now 3 has nowhere to go.

So

```text
finish 3
finish 2
finish 1
```

Notice

Node 1 finishes last.

Why?

Because DFS cannot finish a node until **every reachable node** has finished.

This is called the **finishing time**.

---

# Step 5: Finishing Time of SCCs

Suppose

```text
SCC1 → SCC2
```

Start DFS from SCC1.

DFS first explores SCC2.

Only after SCC2 is completely explored,

can DFS return and finish SCC1.

Therefore,

```text
Finish(SCC2)

Finish(SCC1)
```

Hence

> Source SCCs always receive larger finishing times than the SCCs they point to.

This is the most important observation in Kosaraju.

---

# Step 6: Store Vertices by Finishing Time

During DFS,

every vertex is pushed after it finishes.

Example stack:

```text
Top

A
B

C
D

Bottom
```

Notice

Vertices of the source SCC naturally appear above the destination SCC.

DFS is **not trying to group SCCs.**

It simply records vertex finishing times.

The ordering of vertices automatically orders the SCCs.

---

# Step 7: Why Reverse the Graph?

Original graph

```text
SCC1 → SCC2
```

If we DFS from SCC1,

DFS enters SCC2.

Bad.

Reverse every edge.

Now

```text
SCC1 ← SCC2
```

Start DFS from SCC1 again.

Can it enter SCC2?

No.

The outgoing edge disappeared.

DFS becomes trapped inside SCC1.

Exactly what we wanted.

This is why reversing the graph is necessary.

---

# Step 8: Second DFS

Process vertices in **decreasing finishing time** (stack order).

Take the first unvisited vertex.

Run DFS on the reversed graph.

Since DFS cannot leave that SCC,

this DFS discovers exactly one SCC.

Mark all visited.

Continue.

Already visited vertices are skipped.

Eventually every SCC is found.

---

# Kosaraju Algorithm

### 1. Run DFS on the original graph.

Store every vertex after DFS finishes.

(Vertices with larger finishing times stay on top.)

---

### 2. Reverse every edge.

---

### 3. Pop vertices one by one.

If not visited,

run DFS on the reversed graph.

That DFS gives one SCC.

Repeat until stack becomes empty.

---

# Why Kosaraju Works

The algorithm exploits two facts.

### Fact 1

Source SCCs always finish later than destination SCCs.

This gives the correct processing order.

---

### Fact 2

After reversing the graph,

source SCCs become sinks.

So DFS cannot escape into another SCC.

Therefore,

every DFS discovers exactly one SCC.

---

# Complexity

- First DFS : O(V + E)
- Reverse Graph : O(V + E)
- Second DFS : O(V + E)

Overall

```text
O(V + E)
```

Space

```text
O(V + E)
```

---

# Intuition in One Line

Kosaraju first figures out **which SCC should be processed first** using DFS finishing times, then reverses the graph so that DFS gets **trapped inside one SCC at a time**, allowing each SCC to be extracted naturally.
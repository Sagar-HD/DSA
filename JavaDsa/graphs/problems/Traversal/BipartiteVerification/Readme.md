# Bipartite Graphs - Complete Intuition Guide

## What is a Bipartite Graph?

A graph is **bipartite** if its vertices can be divided into **two groups** such that every edge connects vertices from different groups.

```text
Group 1 <----edge----> Group 2
```

No edge should connect:

```text
Group1 -> Group1
Group2 -> Group2
```

---

# Real Meaning

The coloring/grouping is usually a way of satisfying constraints.

Most common interpretation:

```text
Edge(u,v) means:

u and v must belong to different groups
```

Examples:

* Enemies
* Rival teams
* Scheduling conflicts
* "Cannot be together" constraints

The bipartite question becomes:

> Can all these constraints be satisfied using only 2 groups?

---

# Why Do We Color Nodes?

```text
Color 0 = Group 1
Color 1 = Group 2
```

For every edge:

```text
u ---- v
```

If:

```text
u = Color 0
```

Then:

```text
v = Color 1
```

If:

```text
u = Color 1
```

Then:

```text
v = Color 0
```

Coloring is simply assigning groups.

---

# Odd Cycle Intuition

Every edge forces a color flip.

Example:

```text
A -- B -- C -- D
```

If:

```text
A = Group1
```

Then:

```text
B = Group2
C = Group1
D = Group2
```

Every edge flips the group.

---

# Even Cycle Works

```text
A -- B
|    |
D -- C
```

Start:

```text
A = Group1
```

Then:

```text
B = Group2
C = Group1
D = Group2
```

Check last edge:

```text
D -- A
```

```text
Group2 != Group1
```

No contradiction.

The graph is bipartite.

---

# Odd Cycle Fails

```text
A
|\
| \
|  \
B---C
```

Constraints:

```text
A != B
B != C
C != A
```

Start:

```text
A = Group1
```

Then:

```text
B = Group2
C = Group1
```

Now edge:

```text
C -- A
```

requires:

```text
C != A
```

But:

```text
C = Group1
A = Group1
```

Contradiction.

Therefore:

> Any odd cycle makes a graph non-bipartite.

---

# Most Important Theorem

```text
Graph is Bipartite
        iff
Graph contains NO odd cycle
```

---

# Why Start Node Does Not Matter

Example:

```text
A -- B -- C
```

Start:

```text
A = Group1
```

Result:

```text
A = G1
B = G2
C = G1
```

Now start:

```text
A = Group2
```

Result:

```text
A = G2
B = G1
C = G2
```

Only the group names changed.

The structure is identical.

Therefore:

> Choosing a different source node or different initial color cannot change the final answer.

---

# For a Connected Component

There are only **2 possible valid colorings**.

Coloring 1:

```text
Red Blue Red Blue ...
```

Coloring 2:

```text
Blue Red Blue Red ...
```

Coloring 2 is simply Coloring 1 with colors swapped.

No other possibilities exist.

---

# Disconnected Graph

A graph may contain multiple connected components.

Example:

```text
A -- B

C -- D
```

Component 1:

```text
{A,B}
```

Component 2:

```text
{C,D}
```

Run BFS/DFS from every unvisited node.

Each component can independently swap colors.

If there are `K` connected components:

```text
Number of valid colorings = 2^K
```

(assuming graph is bipartite)

---

# Bipartite Verification Algorithm

For every unvisited node:

```text
Assign color 0

Run BFS/DFS

For every neighbor:

    If neighbor is uncolored:
        Assign opposite color

    Else if neighbor has same color:
        Return False
```

If no contradiction is found:

```text
Return True
```

---

# Time Complexity

```text
BFS : O(V + E)

DFS : O(V + E)
```

---

# Two Different Uses of Bipartite Graphs

## 1. Bipartite Verification

Graph already exists.

Edge means:

```text
must be different
```

Question:

```text
Can nodes be divided into 2 groups?
```

Algorithms:

* DFS Coloring
* BFS Coloring

---

## 2. Bipartite Matching

Groups already exist.

Examples:

```text
Drivers  <-> Riders
Workers  <-> Jobs
Students <-> Courses
Users    <-> Movies
```

Edge means:

```text
can be matched
```

Question:

```text
Which edges should be selected?
```

Algorithms:

* Maximum Matching
* Hopcroft-Karp
* Hungarian Algorithm
* Network Flow

Odd cycle discussion is NOT relevant here.

---

# Common Confusion

## Bipartite Groups ≠ Connected Components

### Bipartite Groups

Logical partitions/colors.

```text
Group1 | Group2
```

### Connected Components

Reachability regions.

```text
Can I reach one node from another?
```

Example:

```text
Drivers:
D1 D2

Riders:
R1 R2
```

Groups:

```text
Drivers | Riders
```

This says nothing about whether the graph has:

```text
1 component
2 components
100 components
```

---

# Real-World Interpretations

### Enemies

```text
Edge = hate relationship
```

Question:

```text
Can enemies be separated into 2 teams?
```

### Course Scheduling

```text
Edge = scheduling conflict
```

Question:

```text
Can all courses fit into 2 time slots?
```

### Rival Countries

```text
Edge = rivalry
```

Question:

```text
Can countries be divided into 2 alliances?
```

---

# One-Line Summary

A bipartite graph is a graph whose **"must-be-different" constraints** can be satisfied using exactly **two groups**.

# Disjoint Set (DSU / Union-Find)

## What is a Disjoint Set?

A **Disjoint Set Union (DSU)**, also known as **Union-Find**, is a data structure used to maintain a collection of **disjoint (non-overlapping) groups**.

It supports two fundamental operations:

* **Find(x)** – Returns the representative (ultimate parent) of the group containing `x`.
* **Union(x, y)** – Merges the groups containing `x` and `y`.

With **Path Compression** and **Union by Rank/Size**, both operations are nearly constant time.

> **Time Complexity:** `O(α(n))` (Inverse Ackermann Function)

For all practical input sizes, this is effectively **O(1)**.

---

# Core Idea

Instead of storing every connection, DSU stores only a **parent** for every element.

Example:

```text
A → B
B → C
C → C
```

The representative (ultimate parent) is:

```text
C
```

Therefore,

```text
find(A) = C
find(B) = C
find(C) = C
```

If two elements have the same ultimate parent, they belong to the same connected component.

---

# Operations

## Find

Returns the representative (ultimate parent) of an element's group.

```cpp
find(x)
```

Uses **Path Compression** so future lookups become faster.

---

## Union

Merges two groups.

```cpp
union(x, y)
```

Usually implemented using:

* Union by Rank
* Union by Size

to keep the tree shallow.

---

# Path Compression

Before:

```text
1 → 2 → 3 → 4 → 5
```

After one `find(1)`:

```text
1 → 5
2 → 5
3 → 5
4 → 5
5 → 5
```

The structure becomes flatter, making future operations almost constant time.

---

# Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Find      | O(α(n))    |
| Union     | O(α(n))    |

---

# Common Use Cases

* Kruskal's Minimum Spanning Tree
* Dynamic connectivity
* Connected components
* Friend/community grouping
* Network clustering
* Image segmentation
* Island counting problems
* Offline connectivity queries

---

# Graph vs Disjoint Set

Although both deal with connected objects, they solve **different problems**.

## Graph

A graph stores the **entire relationship**.

Example:

```text
A ---- B ---- C
|
D
```

A graph knows:

* Every edge
* Every neighbor
* Every path
* Every connection

Because it stores the complete structure, it can answer questions like:

* Is there a path from A to C?
* What is the shortest path?
* Which nodes are adjacent to A?
* What are all reachable nodes?
* Detect cycles
* Traverse using BFS/DFS
* Find distances
* Find weighted shortest paths (Dijkstra)
* Find topological order
* Find bridges and articulation points

Graphs preserve the complete topology.

---

## Disjoint Set

DSU intentionally **does not store the graph**.

It stores only enough information to know:

> Which connected component does this element belong to?

It cannot answer:

* What is the path from A to C?
* How many edges are between A and C?
* Who are A's neighbors?
* What is the shortest path?
* What are all outgoing edges?

Because those edges are never stored.

Instead, DSU stores only parent relationships.

Example:

```text
A → B
B → C
C → C
```

Everything eventually points to the representative.

The actual graph structure is discarded.

---

# Why Use DSU Instead of a Graph?

Suppose we repeatedly perform operations like:

```text
Connect A and B
Connect C and D
Connect B and C
```

Then repeatedly ask:

```text
Are A and D connected?
```

Using a graph:

* Store every edge.
* Perform DFS/BFS to check connectivity.

Complexity:

```text
O(V + E)
```

for each connectivity query.

With DSU:

```text
find(A)
find(D)
```

If their representatives are equal:

```text
Connected
```

Complexity:

```text
O(α(n))
```

This is why DSU is widely used for **dynamic connectivity** problems.

---

# HashMap vs Disjoint Set

These structures also overlap slightly in use cases.

A HashMap can group objects.

Example:

```text
Engineering → [A, B, C]
HR → [D, E]
```

or

```text
A → Engineering
B → Engineering
D → HR
```

This works well when groups are mostly static.

However, suppose Engineering and HR merge.

Every employee in one department now needs their mapping updated.

Merge cost:

```text
O(size of group)
```

---

DSU approaches the problem differently.

Instead of updating every member immediately, it updates only the representative.

Example:

```text
Engineering Root → Engineering
HR Root → HR
```

Merge:

```text
parent(HR Root) = Engineering Root
```

Every other member stays untouched.

Later, when an element is accessed, **Path Compression** lazily updates its parent to point closer to the representative.

This lazy update strategy is why DSU remains extremely efficient even after many merges.

---

# A Useful Mental Model

You can think of DSU as a **special-purpose group manager**.

It is **not implemented like a HashMap**, but its use case feels similar:

* Both answer questions about groups.
* Both can determine whether two elements belong together.

The difference is **how they manage changing groups**.

A naive HashMap-based grouping updates every affected member whenever groups merge.

DSU avoids that work.

It stores only the representative (ultimate parent) and discovers group membership through that representative.

Rather than eagerly updating everyone during a merge, DSU performs updates lazily through **Path Compression**.

This makes it one of the most efficient data structures for maintaining dynamically merging connected components.

---

# Choosing the Right Data Structure

| Need                                  | Best Choice |
| ------------------------------------- | ----------- |
| Store relationships                   | Graph       |
| Traverse relationships                | Graph       |
| Shortest path                         | Graph       |
| Distances                             | Graph       |
| Neighbors                             | Graph       |
| Connected components only             | DSU         |
| Merge connected groups repeatedly     | DSU         |
| Static grouping by known key          | HashMap     |
| Dynamic grouping with frequent merges | DSU         |

## Rule of Thumb

* **HashMap** → "I already know the group."
* **Graph** → "I care about the relationships."
* **Disjoint Set** → "I only care whether two elements belong to the same connected component, and those components keep merging."

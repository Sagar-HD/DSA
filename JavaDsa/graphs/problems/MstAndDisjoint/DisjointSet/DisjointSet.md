# Disjoint Set Union (DSU / Union-Find)

## Why Do We Need a Disjoint Set?

Many graph problems are **dynamic**. Instead of building a graph once and traversing it, new connections are added continuously, and after each addition we may need to answer questions like:

* Are node `u` and node `v` in the same connected component?
* Which connected component does this node belong to?
* How many connected components exist currently?
* If I connect these two nodes, are they already connected?

A naive solution would run DFS/BFS after every new connection. As the graph grows, repeatedly traversing the graph becomes expensive.

A Disjoint Set solves this problem by maintaining connected components **incrementally**. Whenever a new connection is added, only the affected connected components are merged. This makes answering connectivity queries extremely efficient.

---

# Core Idea

A Disjoint Set maintains a collection of **disjoint (non-overlapping) connected components**.

Each connected component has a **single representative**, also called the **ultimate parent**.

Every node belonging to the same connected component eventually points to the same representative.

Example

```text
Initially

1   2   3   4

parent = [1,2,3,4]
```

Every node is its own connected component.

After

```text
union(1,2)
union(2,3)
```

the structure may become

```text
1
|
2
|
3

4
```

Now

```java
find(1) = 3
find(2) = 3
find(3) = 3
find(4) = 4
```

The representative uniquely identifies the connected component.

---

# Core Operations

A DSU fundamentally consists of only **two operations**.

## 1. Find

Returns the representative (ultimate parent) of a node.

```java
find(node)
```

Two nodes belong to the same connected component if

```java
find(u) == find(v)
```

---

## 2. Union

Merges two connected components into one.

Suppose we have

```text
1       4
|       |
2       5
```

Calling

```java
union(2,5)
```

can produce either

```text
1
|
2
|
5
|
4
```

or

```text
4
|
5
|
2
|
1
```

Both are correct.

The only requirement is that both connected components now share the same representative.

---

# Correctness

For correctness, a union operation only needs to ensure:

* If both nodes already belong to the same connected component, do nothing.
* Otherwise, make one representative point to the other.

For example,

```java
parent[root1] = root2;
```

is completely valid.

It does not matter which representative becomes the parent.

The connected components remain exactly the same.

---

# Why Optimizations Are Needed

Although connecting any representative to any other representative is correct, it can create very tall trees.

Example

```text
union(1,2)
union(2,3)
union(3,4)
union(4,5)
```

Result

```text
1
|
2
|
3
|
4
|
5
```

Now

```java
find(1)
```

must travel through every node before reaching the representative.

The deeper the tree becomes, the slower every `find()` operation gets.

The following optimizations exist only to keep these trees shallow.

---

# Union by Size

Each connected component stores the number of nodes it currently contains.

```java
size[root]
```

When merging two connected components,

* attach the smaller component
* under the larger component

Example

Instead of

```text
Small Tree
    |
Large Tree
```

we prefer

```text
Large Tree
|
Small Tree
```

The height increases much less, keeping future operations fast.

---

# Union by Rank

Instead of storing the component size, store an estimate of the tree height.

```java
rank[root]
```

When merging,

* attach the tree with smaller rank
* under the tree with larger rank

If both ranks are equal,

* choose either one as the parent
* increase its rank by one

Union by Rank and Union by Size solve the same problem using different information.

Only one of them is required.

---

# Path Compression

Suppose the tree is

```text
1
|
2
|
3
|
4
|
5
```

Calling

```java
find(1)
```

already visits every node on the path.

Instead of leaving the structure unchanged, every visited node is directly connected to the representative.

After one `find()`

```text
    5
 / /|\ \
1 2 3 4
```

Future `find()` operations become almost instantaneous.

Implementation

```java
return parent[node] = find(parent[node]);
```

Instead of simply returning the representative, it also updates every node on the path.

---

# Why Union by Size/Rank and Path Compression Work Together

Union by Size (or Rank)

* Prevents tall trees from being created.

Path Compression

* Flattens trees whenever a `find()` operation is performed.

One prevents bad trees from forming.

The other repairs any trees that do become deep.

Together they make DSU operations extremely efficient.

---

# Time Complexity

| Operation                                    | Complexity |
| -------------------------------------------- | ---------- |
| Find (without optimizations)                 | O(N)       |
| Union (without optimizations)                | O(N)       |
| Find + Union by Size/Rank + Path Compression | O(α(N))    |

`α(N)` is the **Inverse Ackermann Function**, which grows so slowly that for any practical input size it is less than 5.

In practice, DSU operations are considered **almost O(1)**.

---

# Summary

A Disjoint Set maintains connected components efficiently using two core operations:

* **Find** → Returns the representative of a connected component.
* **Union** → Merges two connected components.

Everything else is an optimization:

* **Union by Size** keeps smaller components under larger ones.
* **Union by Rank** keeps shorter trees under taller ones.
* **Path Compression** flattens trees whenever `find()` is called.

These optimizations never change the connected components. They only make future operations significantly faster.

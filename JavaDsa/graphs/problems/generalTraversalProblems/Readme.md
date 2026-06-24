# General Traversal

These problems do not fundamentally care about DFS or BFS.

The goal is:

Visit
Explore
Group

Traversal order is secondary.

---

# Mental Model

Question:

"What belongs together?"

Not:

"Which is closest?"

Not:

"When is it reached?"

---

# Common Problems

## Number of Islands

DFS ✔
BFS ✔

---

## Max Area of Island

DFS ✔
BFS ✔

---

## Connected Components

DFS ✔
BFS ✔

---

## Flood Fill

DFS ✔
BFS ✔

---

## Count Provinces

DFS ✔
BFS ✔

---

# Why Both Work

Problem asks:

Find all reachable nodes.

Not:

Shortest path.

Not:

Minimum time.

Not:

Distance.

Traversal order irrelevant.

---

# Recognition Pattern

Keywords:

connected
group
region
component
reachable

Either DFS or BFS.

---

# Decision

Choose DFS when:

- Simpler
- Recursive structure exists

Choose BFS when:

- Already using queue
- Large recursion depth risk

---

# State Thinking

Always identify:

State

Examples:

Grid:
(row,col)

Graph:
(node)

Tree:
(node)

Then define transitions.

Traversal comes afterwards.

---

# Ultimate Compression

If question only asks:

"What is connected?"

DFS and BFS are interchangeable.

The problem cares about exploration.

Not ordering.
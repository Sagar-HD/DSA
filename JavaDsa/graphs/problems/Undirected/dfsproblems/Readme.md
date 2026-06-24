# DFS (Depth First Search)

## Core Idea

Explore a possibility completely before trying alternatives.

Question:

"What happens if I continue this path?"

---

# Mental Model

Human exploring cave.

Go deeper.

Hit dead end.

Return.

Try another path.

---

# Stack Stores

Unfinished journeys.

Recursion frames.

Future return points.

---

# DFS Families

## 1. Recursive DFS

Most natural.

Trees.

Backtracking.

Components.

---

## 2. Iterative DFS

Explicit stack.

Used when recursion depth large.

---

## 3. Component DFS

Examples:

- Number of Islands
- Provinces
- Connected Components

Consume entire region.

---

## 4. Backtracking DFS

Examples:

- Sudoku
- N Queens
- Word Search
- Permutations

DFS + Undo

---

## 5. Path DFS

Need current path.

Examples:

- Cycle Detection
- Path Sum
- Graph Coloring

State carried through recursion.

---

## 6. Tree DFS

Examples:

Height

Diameter

LCA

Balanced Tree

Subtree sums

Natural because trees are recursive.

---

## 7. Memoized DFS

DFS + Cache

↓

Top Down DP

Examples:

- Fibonacci
- Coin Change
- Climbing Stairs

Bridge to DP.

---

# Recognition Patterns

Keywords:

explore
all possibilities
backtrack
subtree
recursive
components
cycles

Usually DFS.

---

# Common Mistakes

## Missing visited

Infinite cycles.

---

## Recursive overflow

Large graph.

Use iterative stack.

---

## Forgetting backtrack step

State corruption.

---

# DFS → DP

Without memoization:

Repeated work.

With memoization:

Each state solved once.

DFS transforms into DP.

---

# Ultimate Compression

DFS = Possibility Exploration

Stack = Unfinished Decisions
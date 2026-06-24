# BFS (Breadth First Search)

## Core Idea

BFS expands a wavefront.

Question:

"What gets reached after k steps?"

BFS naturally solves:

- Distance
- Time
- Levels
- Nearest
- Shortest path (unweighted)

---

# Mental Model

DFS:
Explore one possibility.

BFS:
Expand all equally close possibilities.

Think:

Water ripple
Fire spread
Infection spread
Sound propagation

---

# Wavefront View

Distance 0

S

Distance 1

A B C

Distance 2

D E F G

Queue preserves these layers.

---

# Queue Stores

Future events.

Not paths.

Not recursion.

Future states waiting to expand.

---

# BFS Families

## 1. Single Source BFS

One starting node.

Examples:

- Binary Matrix Shortest Path
- Open Lock
- Word Ladder
- Nearest Exit

Pattern:

queue = [source]

---

## 2. Multi Source BFS

Many sources start simultaneously.

Examples:

- Rotting Oranges
- 01 Matrix
- Walls and Gates
- As Far From Land As Possible

Pattern:

queue = all sources

Wave expands from all sources together.

Question usually sounds like:

"Nearest source"

or

"Spread from many places"

---

## 3. Level Order BFS

Tree specific.

Examples:

- Binary Tree Level Order
- Zigzag Traversal
- Right Side View

Question:

Show nodes level by level.

---

## 4. State Space BFS

Node != actual node

Node = state

Examples:

Open Lock

Node = lock combination

Word Ladder

Node = word

Questions become hidden graphs.

---

## 5. BFS With State

State carries extra information.

Examples:

(position, keys)

(position, fuel)

(position, obstacles_left)

(position, direction)

Important Graph Leap.

---

## 6. Bidirectional BFS

Search from both ends.

Examples:

Word Ladder

When:

start → goal

and search space huge.

---

# Recognition Patterns

Keywords:

minimum
shortest
nearest
first reach
minimum moves
minimum operations
levels
minutes
seconds
spread

Usually BFS.

---

# Common Mistakes

## Forgetting visited

Causes cycles.

---

## Marking visited late

Mark while pushing.

Not while popping.

---

## Using BFS on weighted graph

Wrong.

Need Dijkstra.

---

# BFS → Dijkstra

BFS assumes:

edge cost = 1

If edge costs vary:

use priority queue

↓

Dijkstra

BFS is Dijkstra's simpler cousin.

---

# Ultimate Compression

BFS = Wavefront Propagation

Queue = Event Scheduler

Distance = Arrival Time

---

# 🌐 GRAPHS — COMPLETE PATTERN RECOGNITION README

---

# 🧠 1. FIRST PRINCIPLE

```text
Graph = nodes + connections (can have cycles)
Tree = special graph (no cycles)
```

---

# 🎯 2. HOW TO IDENTIFY GRAPH FROM QUESTION

## 🔍 Signals:

### ✅ Signal 1: Relationships / connections

* cities, roads
* users, friends
* courses, prerequisites
* flights, routes

👉 Graph

---

### ✅ Signal 2: Grid problems

* matrix (0/1)
* islands
* flood fill
* shortest path in matrix

👉 Hidden graph (cells = nodes)

---

### ✅ Signal 3: “Convert / transform”

* word ladder
* minimum steps
* operations

👉 Graph + BFS

---

### ✅ Signal 4: Dependencies

* course schedule
* build order
* alien dictionary

👉 Directed graph + topo sort

---

### ✅ Signal 5: Components

* number of islands
* provinces
* groups

👉 DFS / BFS / DSU

---

# ❌ WHEN NOT GRAPH

* array sliding window
* prefix sum
* binary search

---

# 🧠 3. MASTER CLASSIFICATION (VERY IMPORTANT)

---

## 🌊 1. TRAVERSAL PROBLEMS

👉 Just visit nodes

### Use:

* DFS
* BFS

### Examples:

* islands
* flood fill
* provinces

---

## 🔁 2. CYCLE DETECTION

---

### Undirected

👉 parent tracking

```text
if visited and not parent → cycle
```

---

### Directed

👉 recursion stack OR topo

```text
visited + pathVisited
```

OR

```text
topo size != n → cycle
```

---

## 🧠 3. TOPOLOGICAL SORT (DAG ONLY)

👉 ordering

### Recognition:

* dependency
* prerequisites
* ordering tasks

---

### Methods:

* DFS (stack)
* BFS (Kahn’s)

---

# 🔥 4. SHORTEST PATH (BIGGEST PATTERN)

---

## 🧩 Decision Tree (LOCK THIS)

```text
Is graph weighted?

NO → BFS

YES →
    negative weight?
        YES → Bellman Ford
        NO →
            DAG?
                YES → topo + relax
                NO → Dijkstra
```

---

## 🔹 Unweighted

👉 BFS = shortest path

---

## 🔹 Weighted

| Case     | Algorithm    |
| -------- | ------------ |
| normal   | Dijkstra     |
| negative | Bellman Ford |
| DAG      | topo         |

---

## 🔹 Grid problems

👉 BFS / Dijkstra (if weights)

---

# ⚡ 5. MULTI-SOURCE BFS (IMPORTANT)

### Recognition:

* multiple starting points
* nearest distance

Examples:

* rotten oranges
* nearest 1

---

# 🔗 6. DISJOINT SET (DSU)

---

## 🧠 When to use:

* grouping
* merging
* connectivity
* dynamic connections

---

## 🔥 Signals:

* “connect components”
* “merge accounts”
* “number of groups”

---

## Pattern:

```text
find(u)
find(v)
if different → union
```

---

# 🌲 7. MST (MINIMUM SPANNING TREE)

---

## 🧠 Recognition:

* connect all nodes
* minimum cost
* no cycles

---

## Algorithms:

| Algo    | Idea             |
| ------- | ---------------- |
| Kruskal | sort edges + DSU |
| Prim    | grow tree        |

---

# 🧠 8. SCC (STRONGLY CONNECTED)

---

## Recognition:

* directed graph
* mutual reachability

👉 Kosaraju / Tarjan

---

# 🧠 9. BIPARTITE GRAPH

---

## Recognition:

* divide into 2 groups
* no same group edges

👉 coloring

---

# 🧠 10. CORE TEMPLATES

---

## 🔹 DFS

```java
void dfs(node){
    mark visited

    for(neighbour){
        if(not visited){
            dfs(neighbour)
        }
    }
}
```

---

## 🔹 BFS

```java
Queue q
q.add(start)

while(!q.empty()){
    node = q.poll()

    for(neighbour){
        if(not visited){
            mark visited
            q.add(neighbour)
        }
    }
}
```

---

# 🧠 11. HOW TO DERIVE FROM QUESTION (REAL SKILL)

---

## 🎯 Step 1: Is it graph?

* connections? → yes
* grid? → yes

---

## 🎯 Step 2: What is asked?

| Type                 | Approach     |
| -------------------- | ------------ |
| visit all            | DFS/BFS      |
| shortest             | BFS/Dijkstra |
| detect cycle         | DFS/BFS      |
| order                | topo         |
| groups               | DFS/DSU      |
| connect all min cost | MST          |

---

## 🎯 Step 3: Weighted?

👉 decides algorithm

---

## 🎯 Step 4: Directed?

👉 changes logic (cycle/topo)

---

# 🧠 12. YOUR FOLDER → PERFECT MAPPING

---

### Traversal → DFS/BFS

### CycleDetection → parent / recursion stack

### TopologicalSort → DAG

### ShortestPath → BFS / Dijkstra / Bellman

### MstAndDisjoint → Kruskal / DSU

### SCC → Kosaraju

### Bipartite → coloring

👉 You covered FULL graph syllabus

---

# 🔥 13. FINAL TRIGGERS (LOCK THIS)

```text
“connections / relationships” → graph

“shortest path” →
    unweighted → BFS
    weighted → Dijkstra

“dependency / order” → topo

“groups / components” → DFS / DSU

“connect all min cost” → MST

“cycle?” →
    undirected → parent
    directed → recursion stack / topo
```

---

# 🧠 14. FINAL MENTAL IMAGE

```text
Graph = real world

Traversal = explore
BFS = shortest
DFS = deep search
DSU = grouping
Dijkstra = weighted shortest
Topo = ordering
```

---

# 🚀 NEXT MOVE



---

# 🌳 TREES — COMPLETE PATTERN RECOGNITION README

---

# 🧠 1. FIRST PRINCIPLE

```text
Tree = recursion made visible

Every tree problem = DFS or BFS
```

---

# 🎯 2. HOW TO IDENTIFY TREE FROM QUESTION (VERY IMPORTANT)

## 🔍 Signals in problem statement:

### ✅ Signal 1: Hierarchy / Parent-child

* organization structure
* folders / directories
* family tree
* dependency

👉 Think TREE

---

### ✅ Signal 2: “Connected nodes, no cycles”

* edges given
* nodes connected
* no loops

👉 Tree or graph (check constraints)

---

### ✅ Signal 3: Binary conditions

* left / right
* smaller / greater

👉 Binary Tree / BST

---

### ✅ Signal 4: “Root to leaf”

* path
* sum
* depth

👉 DFS Tree problem

---

### ✅ Signal 5: “Level by level”

* nearest
* minimum steps
* shortest distance

👉 BFS

---

# ❌ WHEN NOT TREE

* array sliding window
* prefix sum
* binary search on array

👉 Don’t force tree

---

# 🧠 3. CORE MENTAL MODEL

```text
Tree traversal = visiting nodes

Two ways:
1. DFS → go deep
2. BFS → go level by level
```

---

# 🔥 4. MASTER SPLIT

---

## 🌊 DFS (RECURSION BASED)

```text
Go deep → left → right
```

---

## 🌐 BFS (QUEUE BASED)

```text
Level order → layer by layer
```

---

# 🧩 5. DFS PATTERN BREAKDOWN (VERY IMPORTANT)

Your folder structure is PERFECT. This is the real classification 👇

---

## 🟢 1. Primitive Return from Child

👉 Child gives simple value (int, boolean)

Examples:

* max depth
* validate BST
* sum

### Pattern:

```java
int left = solve(root.left);
int right = solve(root.right);

return combine(left, right);
```

---

## 🔵 2. Node Return from Child

👉 Child returns node

Examples:

* LCA
* construct tree

### Pattern:

```java
TreeNode left = solve(left)
TreeNode right = solve(right)

return node based on condition
```

---

## 🟡 3. Passing Info Downwards (Top → Bottom)

👉 You carry state

Examples:

* path sum
* root to leaf

### Pattern:

```java
solve(node, currentSum)
```

---

## 🔴 4. Global Update While Traversing

👉 Answer not returned, updated globally

Examples:

* diameter
* max path sum

### Pattern:

```java
int left = solve()
int right = solve()

update global

return something
```

---

## 🟣 5. Custom State from Children

👉 multiple values returned

Example:

* complex DP on trees

---

# 🌐 6. BFS PATTERN

---

## 🧠 When to use BFS:

* level order
* shortest path
* nearest node
* width of tree

---

## Template:

```java
Queue<TreeNode> q = new LinkedList<>();
q.add(root);

while(!q.isEmpty()){
    int size = q.size();

    for(int i=0;i<size;i++){
        TreeNode node = q.poll();

        // process node

        if(node.left != null) q.add(node.left);
        if(node.right != null) q.add(node.right);
    }
}
```

---

## 🔥 Variants you already covered:

* zigzag
* right view
* vertical order
* max width

👉 All are just BFS + twist

---

# 🧠 7. MOST IMPORTANT — HOW TO DERIVE APPROACH

---

## 🎯 Step 1: What is asked?

| Question Type      | Approach |
| ------------------ | -------- |
| path / sum         | DFS      |
| height / depth     | DFS      |
| all paths          | DFS      |
| shortest / nearest | BFS      |
| level output       | BFS      |

---

## 🎯 Step 2: Do I need info from children?

👉 YES → bottom-up (DFS return)

---

## 🎯 Step 3: Do I carry info?

👉 YES → top-down

---

## 🎯 Step 4: Is answer global?

👉 YES → use global variable

---

# 🧩 8. COMMON PROBLEM MAPPING

---

| Problem        | Pattern          |
| -------------- | ---------------- |
| Max Depth      | primitive return |
| Validate BST   | primitive return |
| LCA            | node return      |
| Path Sum       | top-down         |
| Diameter       | global update    |
| Max Path Sum   | global update    |
| Serialize      | traversal        |
| Construct Tree | node return      |

---

# 🧠 9. BST SPECIAL PATTERN

---

## Key property:

```text
left < root < right
```

---

## Recognition:

* sorted order
* kth smallest
* search in log n

---

## Pattern:

```java
if(val < root.val) go left
else go right
```

---

# ⚡ 10. TREE = RECURSION TREE (IMPORTANT REALIZATION)

```text
Tree problems are just recursion on nodes

Every node = function call
```

---

# 🔥 11. FINAL TRIGGERS (REMEMBER THIS)

```text
“Root → left → right” → DFS

“Level by level” → BFS

“Need child info” → return values

“Need full path tracking” → pass parameters

“Need global best” → global variable
```

---

# 🚀 FINAL MENTAL IMAGE

```text
          1
        /   \
       2     3
     /  \   / \
    4    5 6   7
```

👉 DFS = go 1→2→4
👉 BFS = go 1→2→3

---

# 🧠 LAST LINE (LOCK THIS)

```text
Tree problems are just:
→ recursion + pattern of data flow (up / down / global)
```

---

# 🚀 NEXT MOVE

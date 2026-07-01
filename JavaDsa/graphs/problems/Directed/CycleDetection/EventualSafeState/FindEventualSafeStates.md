# Eventual Safe States

> **Core Idea:**  
> A node is **eventually safe** if **every possible path** starting from it **must** end at a terminal node (a node with no outgoing edges).  
> If **any path** can enter a cycle, the node is **unsafe**.

---

# What is a Safe Node?

A node is **safe** if it **can never reach a cycle**.

Notice the wording carefully.

❌ **Wrong**

> A safe node is a node that is not part of a cycle.

✅ **Correct**

> A safe node is a node from which **no path can ever reach a cycle**.

---

## Example 1 — Not in a Cycle, but Unsafe

```
0 → 1 → 2
    ↑   ↓
    └───┘
```

Node `0` is **not part of the cycle**.

However,

```
0 → 1 → 2 → 1 → 2 → ...
```

Starting from `0`, we eventually enter the cycle.

Therefore,

```
0 ❌ Unsafe
1 ❌ Unsafe
2 ❌ Unsafe
```

Being **outside** a cycle does **not** make a node safe.

---

## Example 2 — Not in a Cycle, and Safe

```
0 → 1 → 2 → 3

4 → 2
```

`3` is a terminal node.

Every possible path is

```
0 → 1 → 2 → 3
4 → 2 → 3
```

No path can ever reach a cycle.

Therefore,

```
0 ✅ Safe
1 ✅ Safe
2 ✅ Safe
3 ✅ Safe
4 ✅ Safe
```

Being **outside** a cycle is **not enough** to be safe.

A node is safe only if **every path starting from it eventually terminates**, i.e., **it cannot reach any cycle**.

---

# Relationship with Cycle Detection

Cycle Detection asks

> **Does a cycle exist?**

Eventual Safe States asks

> **Can I reach a cycle?**

These are completely different questions.

A node doesn't have to be inside a cycle to be unsafe.

It only needs **one path** that reaches a cycle.

---

# Mental Model

Imagine every node is standing at a road intersection.

Ask yourself:

> **"If I start driving from here forever, will I always eventually stop?"**

If **every road** eventually ends,

✅ Safe.

If **even one road** lets you drive forever,

❌ Unsafe.

---

# DFS Intuition

DFS naturally explores paths.

Exactly what we need.

Starting from every node, we simply ask

```
Can this DFS eventually reach a cycle?
```

If yes

```
Unsafe
```

Else

```
Safe
```

---

# Why DFS Looks Almost Identical to Cycle Detection

Cycle Detection already tells us

```
Did my DFS enter a cycle?
```

Eventual Safe States simply extends that idea.

Instead of asking

```
Is there a cycle?
```

we ask

```
Can THIS node reach a cycle?
```

Same recursion.

Same recursion stack.

Same visited arrays.

The only difference is the return value.

Instead of returning

```
Cycle exists?
```

we return

```
Is this node safe?
```

---

# DFS State Thinking

Suppose

```
0 → 1 → 2
    ↑   ↓
    └───┘
```

DFS starts from `0`

```
0

↓

1

↓

2

↓

1
```

Node `1` is already in the current recursion path.

Cycle found.

Now recursion returns

```
2 Unsafe

↓

1 Unsafe

↓

0 Unsafe
```

Unsafe information naturally propagates backwards.

---

# BFS Intuition

The BFS solution thinks in the opposite direction.

Instead of asking

> **Can I reach a cycle?**

It asks

> **Can I prove this node is safe?**

This completely changes the approach.

Instead of detecting danger,

we keep proving safety.

---

# Who Is Definitely Safe?

Terminal nodes.

```
0 → 1 → 2
          ↓
       Terminal
```

A terminal node has

```
Outdegree = 0
```

It has nowhere else to go.

So it is **guaranteed safe**.

These nodes become our starting points.

---

# The Big Problem

Suppose

```
0 → 1 → 2 → 3
```

We discover

```
3 is safe
```

Now who becomes safe?

```
2
```

Then

```
1
```

Then

```
0
```

Safety spreads **backwards**.

But...

From node `3`

there is no edge going back to `2`.

The original graph only stores

```
2 → 3
```

We need to know

```
Who points to me?
```

The graph cannot answer that efficiently.

---

# Why Reverse the Graph?

Original

```
0 → 1 → 2 → 3
```

Reverse

```
0 ← 1 ← 2 ← 3
```

Now

starting from safe node `3`

we immediately reach

```
2
```

Then

```
1
```

Then

```
0
```

Safety naturally propagates backwards.

---

# Why Outdegree Instead of Indegree?

Topological Sort starts with

```
Indegree = 0
```

because those nodes have

```
No prerequisites.
```

Eventual Safe States starts with

```
Outdegree = 0
```

because those nodes have

```
No future.
```

They cannot enter a cycle.

Hence they are already safe.

---

# BFS Mental Model

Imagine every outgoing edge is a possible future.

Initially,

```
outdegree[node]
=
number of possible future paths
```

Whenever one neighbour is proven safe,

that future path is no longer dangerous.

So we decrease

```
outdegree--
```

Eventually

```
outdegree == 0
```

Meaning

Every possible future from this node has already been proven safe.

Therefore,

```
Current node becomes safe.
```

---

# Why Reverse Dependency Works

Suppose

```
A → B
```

If

```
B
```

becomes safe,

then

```
A
```

moves one step closer to becoming safe.

So

```
B
```

must notify

```
A
```

That is exactly what the reversed graph stores.

Instead of

```
A → B
```

we build

```
B → A
```

Now safety naturally flows backward.

---

# What Happens to Cycles?

Example

```
0 → 1 → 2
    ↑   ↓
    └───┘
```

Outdegrees

```
0 = 1
1 = 1
2 = 1
```

There is no terminal node.

The queue starts empty.

Nothing gets processed.

Nobody can ever be proven safe.

Therefore

```
0 ❌
1 ❌
2 ❌
```

remain unsafe.

---

# Why Nodes Left at the End Are Unsafe

A node enters the queue **only when**

```
All of its outgoing neighbours
have already been proven safe.
```

If a node never enters the queue,

it means

```
There is still at least one outgoing path
whose safety could never be proven.
```

That unresolved path eventually reaches a cycle.

Hence

```
Leftover nodes = Unsafe nodes
```

---

# Connection with Topological Sort

Kahn's Topological Sort removes

```
Indegree = 0
```

because those nodes have no dependencies.

Eventual Safe States removes

```
Outdegree = 0
```

because those nodes have no future.

Topological Sort propagates

```
Dependency removal
```

Eventual Safe States propagates

```
Safety
```

The algorithm is almost identical.

Only the interpretation changes.

---

# DFS vs BFS

## DFS

Think **forward**.

```
Start from me.

↓

Can I reach a cycle?

↓

Yes → Unsafe

No → Safe
```

Uses

- DFS
- Visited array
- Recursion stack (pathVisited)

Detects danger.

---

## BFS

Think **backward**.

```
Start from terminal nodes.

↓

They are safe.

↓

Their parents become safe.

↓

Repeat.
```

Uses

- Reverse graph
- Queue
- Outdegree

Proves safety.

---

# Complete Mental Model

### DFS

```
Explore forward.

↓

Can this path ever enter a cycle?

↓

If yes

Unsafe.

↓

Otherwise

Safe.
```

---

### BFS

```
Start from terminal nodes.

↓

Terminal nodes are already safe.

↓

Anyone whose every outgoing neighbour
has become safe

↓

also becomes safe.

↓

Repeat until no more nodes can be proven safe.

↓

Whatever is left
can still reach a cycle.

↓

Unsafe.
```

---

# Key Takeaways

- A node is **not safe** simply because it is outside a cycle.
- A node is **safe only if it cannot reach any cycle.**
- DFS solves the problem by **searching forward for cycles.**
- BFS solves the problem by **proving safety backward from terminal nodes.**
- The BFS solution is essentially **Kahn's Algorithm** applied on the **reversed graph**, using **outdegree instead of indegree**.
- Nodes that remain after BFS are precisely the nodes that **could never be proven safe**, because they still have a path leading to a cycle.

---

# One-Line Summary

> **DFS detects danger by exploring forward.**  
> **BFS proves safety by propagating backward.**  
> **A node is safe if it cannot reach any cycle—not merely because it is outside one.**
# 🐢🐇 Fast & Slow Pointer Pattern Recognition — Part 4

---

# 🎯 Core Mental Model

Unlike normal Two Pointers, Fast & Slow does **not** compare two different elements.

Instead, both pointers move through the **same sequence** but at **different speeds**.

```text
Slow → 1 step

Fast → 2 steps
```

The difference in speed reveals hidden properties of the sequence.

---

# 🧠 Pattern Recognition Checklist

When reading a problem ask:

- [ ] Do I need the middle of a sequence?
- [ ] Do I need to detect a cycle?
- [ ] Does every state have exactly one "next" state?
- [ ] Can I define `next(x)`?

If YES

↓

Think

```text
Fast & Slow Pointer
```

---

# ⭐ The Biggest Mental Model

Forget Linked Lists.

Think

```text
Current State

↓

Next State

↓

Next State

↓

Next State
```

If every state has **exactly one next state**, you've secretly built a linked list.

Examples

```java
next(node) = node.next
```

```java
next(number) = sumOfSquares(number)
```

```java
next(index) = nums[index]
```

Different problems.

Same abstraction.

---

# 🧩 Pattern 1 — Find Middle

## Recognition

Keywords

- Middle
- Half
- Split List
- Midpoint

↓

Use different speeds.

---

## Idea

```text
Slow → 1 step

Fast → 2 steps
```

When Fast reaches the end,

Slow has travelled only half the distance.

↓

Slow is at the middle.

---

## Variations

### Second Middle (LeetCode 876)

```java
slow = head;
fast = head;
```

---

### First Middle

```java
slow = head;
fast = head.next;
```

Only the starting position changes.

Speed never changes.

---

# 🧩 Pattern 2 — Detect Cycle

## Recognition

Keywords

- Cycle
- Loop
- Circular
- Infinite Traversal

---

## Idea

If no cycle exists

```text
Fast

↓

NULL

↓

No Cycle
```

If cycle exists

```text
Fast

↓

Never reaches NULL

↓

Keeps looping

↓

Eventually catches Slow

↓

Cycle Exists
```

---

## Why they meet

Fast gains

```text
2 - 1 = 1 node
```

on Slow every iteration.

Inside a cycle, there are only finite possible gaps.

Eventually

```text
Gap = 0

↓

Meeting
```

---

# 🧩 Pattern 3 — Find Cycle Start

(Linked List Cycle II)

---

## Final Algorithm

```
Detect Meeting Point

↓

Reset one pointer to Head

↓

Keep other at Meeting Point

↓

Move both 1 step

↓

Where they meet

=

Cycle Start
```

---

## Distances

```
Head
 │
 │ a
 ▼
Cycle Start
 │
 │ b
 ▼
Meeting
 │
 │ c
 ▼
Cycle Start
```

Cycle Length

```
b + c
```

---

## Important Relation

When they meet

```
Fast Distance

=

2 × Slow Distance
```

Extra distance travelled by Fast

```
a+b
```

can only come from

```
Complete Cycles
```

Therefore

```
a+b = n × CycleLength
```

This creates the relation that makes resetting one pointer to Head work.

> **Interview Tip:** You are **not** expected to derive the complete algebraic proof in most interviews. Understanding the intuition and explaining the algorithm is usually enough.

---

# 🧩 Pattern 4 — Hidden Linked List (Happy Number)

## Recognition

Current Number

↓

Next Number

↓

Next Number

↓

...

Every number has exactly one next number.

Hidden Linked List.

---

## next()

```java
next(number)

=

sumOfSquares(number)
```

---

## Slow

```java
slow = next(slow);
```

---

## Fast

```java
fast = next(next(fast));
```

---

## Stop Conditions

Happy

```
Fast reaches 1

↓

Return true
```

Not Happy

```
Fast == Slow

↓

Cycle

↓

Return false
```

---

## Problems

- LeetCode 202 — Happy Number

---

# 🧩 Pattern 5 — Hidden Linked List (Find Duplicate Number)

This is one of the most important Fast & Slow problems.

---

## Recognition

Given

```
Index : 0 1 2 3 4

Value : 1 3 4 2 2
```

Don't think

```
Array
```

Think

```
Index

↓

Next Index
```

---

## Build Hidden Linked List

```
0 → 1

1 → 3

3 → 2

2 → 4

4 → 2
```

Graph

```
0 → 1 → 3 → 2 → 4
          ↑     │
          └─────┘
```

The array itself becomes a linked list.

---

## Why Cycle Exists

Duplicate value

```
nums[3] = 2

nums[4] = 2
```

Both indices point to

```
2
```

Once two paths merge,

they can never split again.

Eventually a cycle is formed.

---

## next()

```java
next(index)

=

nums[index]
```

---

## Floyd

```java
slow = nums[slow];

fast = nums[nums[fast]];
```

---

## Stop Conditions

### Phase 1

```
slow == fast

↓

Meeting Point
```

---

### Phase 2

Reset

```java
slow = 0;
```

Keep Fast at meeting point.

Move both

```java
slow = nums[slow];

fast = nums[fast];
```

Stop when

```
slow == fast
```

Answer

```
Duplicate Number
```

---

## Why reset to 0?

In this hidden linked list

```
0

↓

Head
```

Resetting to `0` is exactly the same as resetting to `head` in a real linked list.

---

# 🌳 Decision Tree

```
Fast & Slow

│
├── Need Middle?
│       │
│       └── Different Speeds
│
├── Need Cycle Detection?
│       │
│       └── Floyd
│
├── Need Cycle Start?
│       │
│       └── Reset One Pointer to Head
│
└── Can every state define next(state)?
        │
        ├── Linked List
        ├── Happy Number
        ├── Duplicate Number
        └── Any Deterministic State Machine
```

---

# 🎯 Recognition Summary

| Problem Type | Think |
|--------------|-------|
| Middle of List | Different Speeds |
| Cycle Detection | Floyd |
| Find Cycle Start | Reset to Head |
| Every state has one next state | Hidden Linked List |
| `next(state)` exists | Fast & Slow |

---

# ⭐ Golden Rule

> ❌ Don't ask:
>
> **"Is this a linked list?"**
>
> ✅ Ask:
>
> **"Can I define a `next(state)` function?"**
>
> If every state has exactly one next state,
>
> you've secretly built a linked list,
>
> and Fast & Slow Pointer becomes a candidate solution.
# 🎯 Two Pointer Pattern Recognition — Part 3 (Same Direction)

# ➡️ Same Direction (`→ →`)

## Partition

---

# 🧠 Core Mental Model

Unlike **Build**, where we keep only one useful category,

and **Merge**, where we combine sorted streams,

**Partition** divides the input into multiple **regions**.

```
Unknown Elements

↓

Classify

↓

Expand Correct Regions
```

The goal is **not sorting**.

The goal is placing every element into its correct partition.

---

# 🔍 Pattern Trigger Checklist

When reading a problem, ask:

- Separate into Even / Odd?
- Separate into Negative / Positive?
- Separate around a Pivot?
- Divide into multiple groups?
- Rearrange elements in-place?

↓

Think

```
Partition
```

---

# ⚙️ Core Invariant

Instead of building one prefix,

we maintain multiple finalized regions.

Example (3 groups)

```
[0 Region][1 Region][Unknown][2 Region]
```

Unknown elements are gradually classified until no unknown region remains.

---

# 🌳 Partition Family

```
Partition

│
├── Unstable Partition
│      Order doesn't matter
│      Use Swapping
│
└── Stable Partition
       Order matters
       Build Groups
```

The first recognition question should always be:

```
Do I need to preserve
relative order?
```

---

# 🧩 1. Unstable Partition (Swap)

## Mental Model

```
Scan Unknown

↓

Classify Element

↓

Expand Correct Region
```

Since order is NOT important,

we freely swap misplaced elements.

---

## 🛠️ Representative Problems

### 1️⃣ Sort Array By Parity (LeetCode 905)

Goal

```
Even | Odd
```

Technique

```
Find misplaced even

↓

Find misplaced odd

↓

Swap

↓

Expand both regions
```

---

### 2️⃣ Sort Colors (LeetCode 75) ⭐

Goal

```
0 | 1 | 2
```

---

### Region Invariant

```
0 ... left-1

↓

All 0

----------------------

left ... mid-1

↓

All 1

----------------------

mid ... right

↓

Unknown

----------------------

right+1 ... end

↓

All 2
```

---

### Pointer Roles

```
Left

↓

End of 0 Region

-------------------

Mid

↓

Scanner

-------------------

Right

↓

End of Unknown Region
```

---

### Classification Rules

#### Mid sees 0

```
Swap with Left

↓

Expand 0 Region

↓

left++

↓

mid++
```

---

#### Mid sees 1

```
Already belongs
to middle region

↓

mid++
```

---

#### Mid sees 2

```
Swap with Right

↓

Expand 2 Region

↓

right--

↓

DON'T move mid
```

---

### ⭐ Why don't we move Mid after swapping with Right?

Because

```
Element coming from Right

↓

Comes from UNKNOWN region

↓

Still unclassified

↓

Must inspect again
```

---

### Why is swapping with Left different?

```
Left always points to

↓

First 1

or

Current Mid
```

After swapping

```
1 comes to Mid

↓

Already classified

↓

Safe to move Mid
```

---

# 🧩 2. Stable Partition (Build)

## Mental Model

Order matters.

Swapping destroys relative order.

Instead,

```
Read

↓

Classify

↓

Append to Correct Group
```

---

## 🛠️ Representative Problem

### Pivot Array (LeetCode 2161)

Goal

```
< Pivot

== Pivot

> Pivot
```

---

### Process

Scan once

```
Less

↓

Append

----------------

Equal

↓

Append

----------------

Greater

↓

Append
```

Finally

```
Less

+

Equal

+

Greater
```

---

### Why can't we swap?

Example

```
Original

9 12 5 10 14 3

Stable Order

9 5 3
```

Swapping may produce

```
9 3 5
```

Relative order changes.

Hence

```
Swap ❌

Build ✅
```

---

# 🎭 Common Disguises

```
Even | Odd

Negative | Positive

Red | White | Blue

< Pivot | >= Pivot

< Pivot | == Pivot | > Pivot
```

All are partition problems.

Only the stability requirement changes.

---

# 🌳 Pattern Recognition Tree

```
Need to separate
elements into groups?

↓

YES

↓

Must preserve order?

↓

YES

↓

Stable Partition

(Read + Build)

----------------------

NO

↓

Swap Partition

(Classify + Swap)
```

---

# ⭐ Golden Rule

Don't think

```
Swap Elements
```

Think

```
Which region

does this element

belong to?
```

Every scanned element expands one of the finalized regions.

---

# 🧠 Mental Map

```
Same Direction (→ →)

Part 3

Partition

│
├── Goal
│      Separate into Regions
│
├── Unstable Partition
│      ├── Swap
│      ├── Expand Regions
│      ├── Parity (905)
│      └── Sort Colors (75)
│
└── Stable Partition
       ├── Build Groups
       ├── Preserve Order
       └── Pivot Array (2161)
```

---

# 📌 One Sentence Summary

> **Partition is not about searching or building. It is about classifying every element into its correct region. If order doesn't matter, swap. If order matters, build.**
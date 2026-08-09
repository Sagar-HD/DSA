# 🎯 Two Pointer Pattern Recognition — Part 1 (Same Direction)

# ➡️ Same Direction (`→ →`)

## Build / In-Place Modification

---

# 🧠 Core Mental Model

Unlike **Opposite Direction**, we are **not searching** or **eliminating** candidates.

We are scanning the input once and **building the final answer inside the same array.**

```
Read Pointer

↓

Is this element / group useful?

↓

YES

↓

Write Pointer

↓

Expand Correct Prefix
```

---

# 👁️ Read / ✍️ Write Separation

### 👁️ Read Pointer

- Scans every element (or group).
- Decides what information is useful.

### ✍️ Write Pointer

- Builds the final answer.
- Never points inside the already completed answer.

---

# 🔍 Pattern Trigger Checklist

When you see:

- Remove elements
- Keep specific elements
- Shift values
- Modify array in-place
- Preserve relative order
- Return first **k** elements
- O(1) Extra Space

↓

Think

```
Same Direction

↓

Read

↓

Useful?

↓

Write
```

---

# ⚙️ Core Invariant

```
[ Already Correct Prefix ][ Unprocessed Data ]
                         ^
                      Write
                              ^
                             Read
```

Everything before **write** is already the correct answer.

---

# 🛠️ Generic Template

```java
write = 0;

for(read = 0; read < n; read++){

    if(useful(nums[read])){

        nums[write] = nums[read];
        write++;

    }

}
```

---

# 🧩 Representative Problems

## 1️⃣ Remove Duplicates from Sorted Array

### Useful Element

```
Unique Element
```

### Invariant

```
Prefix

↓

Contains only unique elements.
```

---

## 2️⃣ Remove Element

### Useful Element

```
Element != val
```

### Invariant

```
Prefix

↓

Contains all required elements.
```

---

## 3️⃣ Move Zeroes

### Useful Element

```
Non-zero Element
```

### Process

```
Pass 1

↓

Move all non-zeroes

↓

Pass 2

↓

Fill remaining with zeroes
```

### Invariant

```
Prefix

↓

Contains all non-zero elements
in original order.
```

---

## 4️⃣ String Compression ⭐

### New Mental Model

Don't process **elements**.

Process **groups**.

```
aaabbcccc

↓

[aaa]

[bb]

[cccc]
```

### Read Pointer

```
Scan one complete group

↓

Count group length
```

### Write Pointer

```
Write character

↓

If count > 1

Write digits
```

### Invariant

```
Everything before write

↓

Already compressed correctly.
```

---

## 5️⃣ Duplicate Zeros ⭐ (Advanced)

### Observation

```
Every element shifts by

↓

Number of zeroes before it.
```

---

### ❌ Why Left → Right Fails

```
Original

1 0 2 3

↓

Naive Write

1 0 0 ?

↓

Unread elements destroyed ❌
```

---

### ✅ Solution

### Pass 1

```
Read Only

↓

Calculate final shift

↓

Don't modify array
```

### Pass 2

```
Build Correct Suffix

↓

Right → Left
```

Rules

```
Non-zero

↓

Write Once

----------------

Zero

↓

Write Twice
```

---

# 🎭 Common Disguises

## Merge Sorted Array (LeetCode 88)

Looks like

```
Merge Problem
```

Actually teaches

```
Writing Forward

↓

Overwrites unread data

↓

Write from Back
```

---

## General Rule

Whenever

```
Destination

>

Source
```

AND

```
Writing Left → Right

↓

Destroys unread data
```

Think

```
Build from Back
```

---

# 🌳 Pattern Recognition

```
Need to modify
same array?

↓

Need O(1) space?

↓

Need stable order?

↓

Read

↓

Useful Element / Group?

↓

Write

↓

Expand Correct Prefix
```

---

# 🚨 Advanced Recognition

Ask yourself

```
Will writing forward

destroy unread elements?
```

If

```
NO

↓

Build Prefix

(Left → Right)
```

If

```
YES

↓

First determine
final positions

↓

Build Suffix

(Right → Left)
```

---

# ⭐ Golden Rule

Don't think

```
Move Pointer
```

Think

```
Read

↓

What information
is useful?

↓

Write

↓

Where should
the answer grow?
```

---

# 🧠 Mental Map

```
Same Direction (→ →)

Part 1

Build / In-place Modify

│
├── Read Pointer
│     └── Find useful element / group
│
├── Write Pointer
│     └── Build correct answer
│
├── Build Prefix
│     ├── Remove Duplicates
│     ├── Remove Element
│     ├── Move Zeroes
│     └── String Compression (Groups)
│
└── Build Suffix (Advanced)
      ├── Duplicate Zeros
      └── Merge Sorted Array (Overwrite Avoidance)
```

---

# 📌 One Sentence Summary

> **Same Direction Part 1 is not about moving two pointers. It is about separating "reading" from "writing" so the answer is built correctly inside the same data structure.**
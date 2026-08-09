# 🎯 Two Pointer Pattern Recognition — Part 2 (Same Direction)

# ➡️ Same Direction (`→ →`)

## Merge Two Sorted Streams

---

# 🧠 Core Mental Model

Unlike **Part 1 (Build)**, we are **not filtering** elements.

We already have **two (or more) sorted inputs**.

Our job is to repeatedly decide

```
Who should be consumed next?
```

---

# 🌊 Think of Arrays as Streams

Don't think

```
Array A

Array B
```

Think

```
Stream A  →

Stream B  →

↓

Compare Current Elements

↓

Consume One

↓

Advance Corresponding Pointer
```

Every pointer represents the **current front** of its stream.

---

# 🔍 Pattern Trigger Checklist

When you see

- Two Sorted Arrays
- Merge
- Union
- Intersection
- Common Elements
- Compare Two Sorted Sequences
- Merge K Sorted Lists (Advanced)

↓

Think

```
Two Sorted Streams

↓

Compare

↓

Consume

↓

Advance
```

---

# ⚙️ Core Invariant

```
Stream A

↓

Current Element

-----------------------

Stream B

↓

Current Element

-----------------------

Everything already consumed

↓

Correct Answer
```

Every comparison permanently consumes at least one element.

No consumed element is ever visited again.

---

# 🛠️ Generic Template

```java
while(i < n && j < m){

    if(A[i] < B[j]){

        // Consume A
        i++;

    }

    else if(A[i] > B[j]){

        // Consume B
        j++;

    }

    else{

        // Consume Both
        i++;
        j++;

    }

}
```

---

# 🧩 Representative Problems

## 1️⃣ Merge Two Sorted Arrays

### Objective

Merge both arrays into one sorted array.

### Thinking

```
Smaller Element

↓

Must appear first

↓

Consume Smaller
```

### Invariant

```
Output

↓

Already sorted.
```

When one stream finishes,

copy the remaining elements of the other stream.

---

## 2️⃣ Merge Sorted Array (LeetCode 88)

### Observation

Destination array is also a source.

Writing from front destroys unread data.

### Solution

```
Compare Largest Elements

↓

Fill Destination

Right → Left
```

This is an application of the **Overwrite Rule** learned in Part 1.

---

## 3️⃣ Intersection of Two Sorted Arrays

### Objective

Keep only common elements.

### Thinking

```
A < B

↓

A cannot match later

↓

Consume A

------------------

A > B

↓

Consume B

------------------

Equal

↓

Output

↓

Consume Both
```

### Invariant

```
Output

↓

Contains only common elements.
```

---

## 4️⃣ Union of Two Sorted Arrays

### Objective

Return every unique element.

### Thinking

```
Smaller

↓

Output

↓

Consume Smaller

-------------------

Equal

↓

Output Once

↓

Consume Both
```

### Invariant

```
Output

↓

Contains every unique element
in sorted order.
```

---

## 5️⃣ Common Elements in Three Sorted Arrays

### Observation

Three sorted streams.

```
A

B

C
```

### Thinking

If

```
All Equal

↓

Output

↓

Move All
```

Otherwise

```
Move Smallest
```

because the smallest value must catch up with the others.

---

## 6️⃣ Compare Version Numbers ⭐

### Observation

Don't compare characters.

Compare **version components**.

```
1.2.10

↓

1

2

10
```

### Thinking

```
Current Component Equal?

↓

YES

↓

Next Component

--------------------

Different?

↓

Return Immediately
```

---

# 🎭 Common Disguises

Looks different...

Actually the same pattern.

```
Merge Arrays

↓

Merge Streams

↓

Merge Linked Lists

↓

Compare Version Numbers

↓

Three Sorted Arrays
```

Only the action after comparison changes.

---

# 🌳 Pattern Recognition

```
Multiple Sorted Inputs?

↓

Need Combined Result?

↓

Need Common Elements?

↓

Need Comparison?

↓

Compare Current Elements

↓

Consume Correct Stream

↓

Advance

↓

Repeat
```

---

# ⭐ The Consume Rule

Never think

```
Move Pointer
```

Think

```
Consume Element

↓

It can never participate again.
```

Every comparison permanently removes at least one candidate.

---

# 🧠 Mental Map

```
Same Direction (→ →)

Part 2

Merge Sorted Streams

│
├── Merge
│     └── Consume Smaller
│
├── Merge In-place
│     └── Build from Back
│
├── Intersection
│     └── Consume Smaller
│         Consume Both if Equal
│
├── Union
│     └── Output Smaller
│         Output Once if Equal
│
├── Three Arrays
│     └── Move Smallest
│         Move All if Equal
│
└── Version Compare
      └── Compare Components
         Consume Both
```

---

# 📌 One Sentence Summary

> **Same Direction Part 2 is not about writing an answer. It is about consuming the correct element from two (or more) already sorted streams while maintaining a correct output.**
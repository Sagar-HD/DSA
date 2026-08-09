
---

# 🧠 BINARY SEARCH – COMPLETE MENTAL MODEL

---

# 🚀 CORE TRUTH

```text
Binary Search is NOT about searching in array

Binary Search = Searching in a MONOTONIC SPACE
```

---

# 🔥 ULTIMATE VISUAL

```text
F F F F F T T T T
        ↑
     ANSWER
```

👉 Your job:

```text
Find the FIRST TRUE or LAST FALSE
```

---

# 🧠 WHAT IS “MONOTONIC”?

```text
Once condition becomes TRUE,
it stays TRUE (or vice versa)
```

---

# ⚡ TYPES OF BINARY SEARCH (MENTAL MAP)

---

## 🟢 1. DIRECT SEARCH (BASIC)

```text
Sorted array → find element
```

### Pattern:

```text
if(arr[mid] == target) → return
if(arr[mid] < target) → go right
else → go left
```

---

## 🟡 2. BOUNDARY SEARCH

```text
Find FIRST / LAST occurrence
```

---

### 🔥 Visual

```text
1 2 2 2 3 4

Find FIRST 2:
    ↑
```

---

### Pattern:

```text
if(arr[mid] == target){
    ans = mid;
    move LEFT (for first)
    move RIGHT (for last)
}
```

---

## 🔵 3. MODIFIED STRUCTURE

```text
Not fully sorted
BUT pattern exists
```

---

### Cases:

---

### 🔥 Peak Element

```text
1 3 5 4 2
    ↑
```

```text
if(mid < mid+1) → go RIGHT
else → go LEFT
```

👉 Following slope

---

### 🔥 Nearly Sorted

```text
mid, mid-1, mid+1 check
```

---

### 🔥 Infinite Array

```text
Expand window:
1 → 2 → 4 → 8 → 16
Then apply BS
```

---

## 🟣 4. ROTATED ARRAY

---

### 🔥 Visual

```text
4 5 6 7 0 1 2
```

---

### Key Insight

```text
One half is ALWAYS sorted
```

---

### Pattern

```text
if(left part sorted){
    check if target in left
    else go right
}
else{
    check right
}
```

---

## 🟤 5. MATRIX SEARCH

---

### Case 1:

```text
Fully sorted → treat as 1D
```

---

### Case 2:

```text
Row + Column sorted
→ start top-right
```

---

## 🔴 6. BINARY SEARCH ON ANSWER (MOST POWERFUL)

---

# 🧠 CORE IDEA

```text
We search in ANSWER SPACE
NOT array
```

---

## 🔥 STEP-BY-STEP DERIVATION

---

### 🧩 Problem:

```text
Minimize maximum pages
```

---

### 🔥 Step 1: Identify RANGE

```text
low = max(arr)
high = sum(arr)
```

---

### 🔥 Step 2: Convert to YES/NO

```text
Can we allocate with max = X ?
```

---

### 🔥 Step 3: Build monotonic

```text
F F F F T T T
```

---

### 🔥 Step 4: Apply BS

```text
if(isValid(mid)){
    ans = mid;
    go LEFT
}
else{
    go RIGHT
}
```

---

# 💣 HOW TO DERIVE BINARY SEARCH FROM PROBLEM

---

## 🧠 MASTER THINKING FLOW

---

## STEP 1: ASK

```text
Can I eliminate HALF of possibilities?
```

👉 YES → Binary Search

---

## STEP 2: CHECK

```text
Is there order / structure?
```

* Sorted
* Rotated
* Increasing/decreasing
* Answer range

---

## STEP 3: FIND MONOTONICITY

```text
If X works → bigger X also works?
```

OR

```text
If X fails → smaller X also fails?
```

👉 That’s binary search

---

## STEP 4: BUILD CONDITION

```text
boolean isValid(x)
```

---

## STEP 5: DECIDE SEARCH TYPE

| Goal       | Move           |
| ---------- | -------------- |
| First True | high = mid - 1 |
| Last True  | low = mid + 1  |

---

# 🔥 HOW TO TRANSFORM PROBLEM

---

## 🔁 TRANSFORMATION 1: VALUE → ANSWER SPACE

```text
Find minimum pages
```

→

```text
Search in range [max, sum]
```

---

## 🔁 TRANSFORMATION 2: PROBLEM → BOOLEAN

```text
Allocate books
```

→

```text
isPossible(maxPages)
```

---

## 🔁 TRANSFORMATION 3: ARRAY → CONDITION SPACE

```text
Instead of searching array,
we search VALIDITY
```

---

# 💣 HOW TO DEFINE START & END (CRITICAL)

---

## 🔴 FOR NORMAL BS

```text
start = 0
end = n-1
```

---

## 🔴 FOR ANSWER BS

---

### Rule:

```text
LOW = minimum possible answer
HIGH = maximum possible answer
```

---

### Examples:

---

#### 📘 Book Allocation

```text
low = max(arr)
high = sum(arr)
```

---

#### 📦 Capacity Problems

```text
low = max weight
high = total weight
```

---

#### ⏱ Time Problems

```text
low = 1
high = max time
```

---

# 🎭 COMMON DISGUISES

---

## 🔥 “Minimum possible value”

```text
→ Binary Search on Answer
```

---

## 🔥 “Maximum feasible value”

```text
→ Binary Search on Answer
```

---

## 🔥 “First / last occurrence”

```text
→ Boundary BS
```

---

## 🔥 “Peak / mountain”

```text
→ Slope BS
```

---

## 🔥 “Rotated / shifted”

```text
→ Modified BS
```

---

# ⚡ COMMON MISTAKES

---

## ❌ Thinking only sorted array

```text
Binary search is NOT limited to arrays
```

---

## ❌ Not identifying monotonic

```text
No monotonic → NO BS
```

---

## ❌ Wrong low/high

```text
Range defines correctness
```

---

# 🧠 FINAL MENTAL MODEL

```text
Binary Search = Decision Engine

"I am searching the point
where condition changes"
```

---

# 🚀 FINAL ONE-LINER

```text
If you can convert problem into
TRUE/FALSE monotonic condition
→ You can apply Binary Search
```

---

# 🔥 WHAT YOU SHOULD DO NEXT

---


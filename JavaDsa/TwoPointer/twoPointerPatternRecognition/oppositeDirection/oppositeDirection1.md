# 🎯 Two Pointer Pattern Recognition — Part 1

## ↔️ Opposite Direction (`←  →`)

### Sorted Array + Pair / Triplet / K-Sum + Sum / Target / Closest / Count

---

## 🧠 Core Mental Model

The biggest advantage of sorting is **predictability**. Without sorting, moving an index pointer has no guaranteed effect on the resulting sum or expression.

> 💡 **The Sorting Advantage**
> * **`left++`** $\rightarrow$ Always **increases** the value / sum 📈
> * **`right--`** $\rightarrow$ Always **decreases** the value / sum 📉
> 
> 

Sorting transforms an arbitrary array into a **monotonic search space**, allowing us to eliminate vast chunks of invalid combinations in a single move!

---

## 🔍 Pattern Trigger Checklist

When reading a LeetCode or DSA question, run through this quick checklist:

* [ ] **Target Group:** Looking for a **Pair**, **Triplet**, **Quadruplet**, or **K numbers**?
* [ ] **Objective:** Calculating a **Sum**, **Target**, **Difference**, **Closest**, or **Count**?
* [ ] **Constraints:** Is sorting allowed? (Does original index ordering *not* matter?)

> 🚀 **If YES to all:** **Sort the array** and use **Opposite Direction Two Pointers!**

---

## ⚙️ Core Invariant

```
  [ left ]  ───→  Increasing Sum  ───→
                          │
  ←───  Decreasing Sum  ───  [ right ]

```

Pointer movement is always **mathematically justified** because the array is globally sorted:

* `left++` $\implies$ Expression increases
* `right--` $\implies$ Expression decreases

---

## 🧩 Pattern 1: Pair Problems (The Foundation)

### 1️⃣ Pair Sum (`a + b = target`)

* **Movement Rules:**
* `sum < target` $\rightarrow$ Need a larger sum $\rightarrow$ **`left++`**
* `sum > target` $\rightarrow$ Need a smaller sum $\rightarrow$ **`right--`**



---

### 2️⃣ Count Pair < Target (`a + b < target`)

* **Observation:** If `nums[left] + nums[right] < target`, then **every** element between `left` and `right` paired with `nums[left]` will also be `< target`.
* **Action:**
```python
ans += (right - left)
left++

```



---

### 3️⃣ Count Pair > Target (`a + b > target`)

* **Observation:** If `nums[left] + nums[right] > target`, then **every** element between `left` and `right` paired with `nums[right]` will also be `> target`.
* **Action:**
```python
ans += (right - left)
right--

```



---

### 4️⃣ Pair Closest (`a + b ≈ target`)

* **Mental Model:** Maintain `bestDifference` and `bestPair` / `bestSum`.
* **Action:** At every step, check if the current sum beats `bestDifference`. Pointer movement rules remain identical to standard **Pair Sum**.

---

### 5️⃣ Pair Difference (`b - a = diff`)

* **Mental Model:** Since $b - a = \text{diff}$, sorting makes differences predictable.
* **Action:**
* `Difference too small` $\rightarrow$ Increase `right`
* `Difference too large` $\rightarrow$ Increase `left`



---

## 🔺 Pattern 2: Triplet Problems (Fix & Reduce)

> 💡 **Core Reduction Rule**
> Never think "Three Sum". Think: **Fix one variable $\rightarrow$ reduce to Pair Problem.**

$$\text{Equation: } a + b + c = \text{target} \implies b + c = \text{target} - a$$

| Problem | Reduction Technique | Key Formula / Logic |
| --- | --- | --- |
| **3Sum** | Fix $a$, solve 2Sum | $b + c = \text{target} - a$ |
| **3Sum Closest** | Fix $a$, solve Pair Closest | Track global `bestDiff` across all fixed $a$ |
| **3Sum Smaller** | Fix $a$, solve Pair Count | Count pairs where $b + c < \text{target} - a$ |
| **Valid Triangle Number** | Fix largest side $c$, solve Pair Count | Condition $a + b > c \rightarrow$ Count pairs where $a + b > c$ |

---

## 📦 Pattern 3: Quadruplet & K-Sum Problems

### The Cascade Effect

$$K\text{-Sum} \xrightarrow{\text{Fix 1}} (K-1)\text{-Sum} \xrightarrow{\text{Fix 1}} \dots \xrightarrow{\text{Fix 1}} 2\text{-Sum}$$

```
4Sum  ──(Fix 1)──>  3Sum  ──(Fix 1)──>  2Sum  ──(Two Pointers)──>  Done!

```

### Time Complexity Hierarchy

| Problem | Reductions | Time Complexity |
| --- | --- | --- |
| **2Sum** | Direct Two Pointers | **$O(N)$** |
| **3Sum** | 1 outer loop + 2Sum | **$O(N^2)$** |
| **4Sum** | 2 outer loops + 2Sum | **$O(N^3)$** |
| **K-Sum** | $(K-2)$ outer loops + 2Sum | **$O(N^{K-1})$** |

---

## 🎭 How Problems Disguise This Pattern (And How to Spot Them)

Interviewers love wrapping simple **Opposite Direction Two Pointer** problems in real-world scenarios or tricky math notation. Use this **Decoding Kit** to strip away the disguise!

---

### 🕵️ Disguise 1: Real-World / Geometry Wrappers

* **The Mask:** *"Find three sticks that can form a valid triangle"* or *"Find wooden beams to build a frame."*
* **The Hidden Equation:** Triangle Inequality Theorem $\rightarrow a + b > c$ (where $c$ is the longest side).
* **The Unmasking:**
1. Sort the array so $a \le b \le c$.
2. Fix the largest side $c$.
3. Use two pointers to count how many pairs $(a, b)$ satisfy $a + b > c$.



---

### 🕵️ Disguise 2: Hidden Algebraic Transformations

* **The Mask:** *"Find if three numbers in an array form a Pythagorean triplet ($a^2 + b^2 = c^2$)."*
* **The Hidden Equation:** It looks quadratic, but it's just 3Sum in disguise!
* **The Unmasking:**
1. Square every number in the array: $\text{nums}[i] = \text{nums}[i]^2$.
2. Sort the array.
3. Now it’s just $a + b = c$ (Standard 3Sum / 2Sum)!



---

### 🕵️ Disguise 3: Minimization / "Closest" Language

* **The Mask:** *"Find three items whose total price is as close as possible to your budget without going over."*
* **The Hidden Equation:** $\vert{}(a + b + c) - \text{budget}\vert{} \to \text{minimize}$.
* **The Unmasking:**
* Whenever you see **"closest"**, **"minimum difference"**, or **"closest sum"**:
* Pointer movement rules **do not change**!
* You still move `left++` when sum is too small and `right--` when sum is too large—you just maintain a running variable tracking `min_diff`.



---

### 🕵️ Disguise 4: "Count" Instead of "Find Indices"

* **The Mask:** *"Count how many pairs have a sum less than target."*
* **The Hidden Equation:** $a + b < \text{target}$.
* **The Trap:** Candidates think they can't sort because sorting changes original indices.
* **The Unmasking:**
* **Rule:** If the question asks for **combinations, pairs, counts, or values** (and NOT specific original indices), **sorting is 100% allowed**!
* Sorting preserves the multiset of elements, which is all you need to count valid pairs.



---

### 🕵️ Disguise 5: Multi-Variable Split Expressions

* **The Mask:** *"Maximize $\text{nums}[i] + \text{nums}[j] + i - j$ where $i < j$."*
* **The Hidden Equation:** Rearrange terms to group variables!
* **The Unmasking:**

$$\text{Expression} = (\text{nums}[i] + i) + (\text{nums}[j] - j)$$


* Transform the array into terms, then apply two-pointer or max-tracking logic.



---

### ⚡ Quick Decoder Table

| Story / Wording in Problem | Unmasked Pattern | First Action |
| --- | --- | --- |
| *"3 sticks form a triangle"* | Count Pairs $a + b > c$ | Sort $\to$ Fix $c$ |
| *"Pythagorean Triplets"* | $a^2 + b^2 = c^2$ | Square array $\to$ Sort $\to$ 3Sum |
| *"Budget constraint / closest price"* | 3Sum Closest | Sort $\to$ Fix 1 $\to$ Track `min_diff` |
| *"Pairs with difference equal to K"* | Pair Difference ($b - a = k$) | Sort $\to$ 2 Pointers |
| *"Select K items with sum = Target"* | General K-Sum | Sort $\to$ Recursively reduce to 2Sum |

---

## 🌳 Decision Tree

```
                   Is it a Pair / Triplet / K-Sum problem?
                                     │
                                    YES
                                     │
                             Is Sorting allowed?
                                     │
                                    YES
                                     │
            Does it involve Sum, Target, Difference, Closest, or Count?
                                     │
                                    YES
                                     │
                       Can fixing (K-2) elements reduce 
                           the problem to 2-Sum?
                                     │
                                    YES
                                     │
              ┌──────────────────────┴──────────────────────┐
              ▼                                             ▼
       1. Sort Array                                 2. Run Two Pointers
   (Predictable Movement)                         (Opposite Direction ← →)

```

---

## 🚫 When NOT to Use This Pattern

Opposite-direction two pointers fail if sorting **does not create a single monotonic search space**.

⚠️ **Common Red Flags:**

* **Original indices must be returned:** Unless you store `(value, original_index)` tuples, sorting breaks index mapping.
* **Multiple independent arrays:** E.g., *4Sum II* (where numbers come from 4 separate arrays). Use **HashMaps** or **Meet-in-the-Middle** instead.

---

## 📜 The Golden Rules

1. **Sorting creates predictability.** Unsorted arrays lead to lost directional guarantees.
2. **Never memorize Triplet/Quadruplet code.** Always reduce them back down to **Pair (2Sum)** problems.
3. **Always write down the equation first:**
* $a + b = \text{target}$
* $a + b < \text{target}$
* $a + b > c$


4. **Think in reductions, not nested loops.** Frame your solution as `Fix One → Solve Subproblem`.

---

## 🏁 Final Mental Model Summary

$$\text{Sorted Array} \implies \text{Predictable Movement} \implies \text{Opposite Pointers } (\leftarrow \rightarrow) \implies \text{Solve 2Sum} \impliedby \text{Reduce } K\text{-Sum}$$
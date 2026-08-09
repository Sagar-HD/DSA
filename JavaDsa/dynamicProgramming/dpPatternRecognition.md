
---

# 🧠 DYNAMIC PROGRAMMING — MASTER README

---

# 🧠 1. FIRST PRINCIPLE

```text
DP = Recursion + Memoization

DP = Overlapping subproblems + Optimal substructure
```

---

# 🎯 2. HOW TO IDENTIFY DP

## 🔍 Signals:

```text
• count ways
• max / min
• multiple choices → best answer
• subset / partition
• string comparison
```

---

# ❌ NOT DP

```text
• sliding window
• binary search
• simple traversal
```

---

# 🧠 3. CORE WORKFLOW (ALWAYS FOLLOW)

```text
1. Write recursion
2. Identify states
3. Check repetition
4. Add memoization
5. Convert to tabulation
```

---

# 🔥 4. MOST IMPORTANT — TRANSFORMATION THINKING

```text
DP problems are NOT direct

You must convert them into known patterns
```

---

# 🧩 5. MASTER TRANSFORMATION → SUBSET SUM

---

## 🎯 Base Problem

```text
Find subset with sum = target
```

---

## 🔴 Equal Partition

```text
Total sum = S

Find subset = S/2
```

---

## 🟠 Min Subset Difference

```text
s1 = subset sum

Difference = |S - 2*s1|

Find s1 close to S/2
```

---

## 🟡 Count Subsets with Difference

```text
s1 - s2 = diff
s1 + s2 = S

→ s1 = (S + diff)/2
```

---

## 🟢 Target Sum (+ / -)

```text
s1 - s2 = target
s1 + s2 = S

→ s1 = (S + target)/2
```

---

## 🔵 Last Stone Weight

```text
Same as min subset difference
```

---

# ⚡ UNIVERSAL FORMULA

```text
If problem has:
    • two groups
    • + / -
    • difference

→ Try:

s1 = (S + target)/2
```

---

# 🧠 6. KNAPSACK PATTERN

---

## Recognition:

```text
pick / not pick
capacity / weight
subset / partition
```

---

## Template:

```java
dp[i][sum] =
    take OR not take
```

---

## Count Version:

```java
dp[i][sum] =
    take + not take
```

---

# 🟠 7. UNBOUNDED KNAPSACK

---

## Recognition:

```text
infinite supply
coins
rod cutting
```

---

## Key Change:

```text
take → stay at same index
```

---

# 🔵 8. LCS PATTERN

---

## Recognition:

```text
2 strings
subsequence
matching
```

---

## Template:

```java
if(match)
    1 + dp[i-1][j-1]
else
    max(dp[i-1][j], dp[i][j-1])
```

---

## Transformations:

```text
• min insert/delete → LCS
• palindrome → reverse + LCS
• repeating subsequence → LCS variation
```

---

# 🟢 9. 1D DP

---

## Recognition:

```text
linear decisions
previous states only
```

---

## Example:

```java
dp[i] = max(take, skip)
```

---

# 🚨 10. IMPORTANT PATTERNS (NOT COVERED BUT REQUIRED)

---

## 🔴 LIS

```text
increasing sequence
order matters
```

---

## 🟣 Grid DP

```text
matrix
paths
min/max path
```

---

## 🟡 Partition DP

```text
split problem
try all partitions
```

---

## 🔵 Tree DP

```text
tree + decisions
```

---

## 🟤 Bitmask DP

```text
subsets (small n)
```

---

# 🧠 11. STATE DESIGN

---

```text
dp[i]        → 1D
dp[i][j]     → 2D
dp[i][j][k]  → 3D
```

---

# 🧠 12. DERIVING DP FROM QUESTION

---

## 🎯 Steps:

```text
1. Can I try all possibilities? → recursion
2. Are states repeating? → DP
3. What defines state? → index / sum / string
4. What are choices? → take / not take / split
5. Write recurrence
```

---

# 🔥 13. COMPLETE PATTERN MAP

---

| Pattern   | Recognition      |
| --------- | ---------------- |
| Knapsack  | pick/not pick    |
| Unbounded | infinite choices |
| LCS       | 2 strings        |
| LIS       | increasing       |
| Grid      | matrix           |
| Partition | splitting        |
| Tree DP   | node decisions   |

---

# 🧠 14. FINAL TRIGGERS

```text
“subset / partition / difference” → subset sum

“+ / - signs” → subset sum transform

“2 strings” → LCS

“max/min with choices” → DP

“infinite supply” → unbounded

“matrix path” → grid DP

“split problem” → partition DP
```

---

# 🧠 15. FINAL MENTAL MODEL

```text
DP = try all possibilities
   + avoid recomputation

Most DP =

→ hidden subset sum
→ hidden LCS
```

---

# 🔥 FINAL LOCK

```text
If you can transform → subset sum
You solve HALF of DP

If you can write recursion
You can build DP
```

---

# 🚀 DONE

You now have:

* pattern recognition ✅
* transformation mastery ✅
* derivation clarity ✅

---

# NEXT


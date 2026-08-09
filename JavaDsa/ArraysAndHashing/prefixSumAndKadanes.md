Got it — you want something you can **revise and *see* the logic flow**, not just templates.

Here’s a **clean, visual, copiable README** 👇

---

# 📘 PREFIX SUM + KADANE — MENTAL MODEL README

---

# 🧠 0. BIG PICTURE

```text
We are solving SUBARRAY problems

There are 3 ways to think:

1. Control window        → Sliding Window
2. Remember past         → Prefix Sum
3. Drop bad past         → Kadane
```

---

# 🧠 1. PREFIX SUM (REMEMBER PAST)

---

## 🔥 CORE IDEA

```text
Instead of trying all subarrays,
we store information about the past.
```

---

## 🧠 VISUAL

Array:

```text
[ a  b  c  d  e ]
```

Prefix:

```text
[ a  a+b  a+b+c  a+b+c+d  a+b+c+d+e ]
```

---

## 🔥 GOLDEN EQUATION

```text
sum(i → j) = prefix[j] - prefix[i-1]
```

---

## 🧠 MEANING

```text
To find subarray sum:
We don't recompute → we subtract
```

---

# ⚡ HOW HASHMAP COMES

We rewrite:

```text
prefix[j] - prefix[i-1] = k
```

👉

```text
prefix[i-1] = prefix[j] - k
```

---

## 🧠 INTERPRETATION

```text
At index j:
We ask → "Have I seen (sum - k) before?"
```

👉 If YES → subarray exists

---

# 🟢 TYPE 1: COUNT SUBARRAYS

---

## 🧠 VISUAL FLOW

```text
index:     0   1   2   3
nums:      1   2   3   2
prefix:    1   3   6   8
```

At index 3:

```text
sum = 8
want k = 5

need: 8 - 5 = 3
```

👉 If 3 seen before → valid subarray

---

## 🔥 WHY map.put(0,1)

```text
Handles subarray starting from index 0
```

Example:

```text
[2,3] → sum = 5
```

We need:

```text
5 - 5 = 0
```

👉 So we must have:

```text
0 already in map
```

---

## 🧠 SUMMARY

```text
COUNT → store frequency
```

---

# 🔵 TYPE 2: LONGEST SUBARRAY

---

## 🧠 CHANGE

```text
We don’t care how many,
we care how far
```

---

## 🔥 KEY IDEA

```text
Earlier index = longer length
```

---

## 🧠 VISUAL

```text
index:   0   1   2   3   4
prefix:  1   3   1   5   1
```

For sum = 1:

```text
first seen at index 0
again at 4 → length = 4 - 0 = 4 (max)
```

---

## 🧠 SUMMARY

```text
LENGTH → store first occurrence only
```

---

# 🟡 TYPE 3: MODULO (DIVISIBLE BY K)

---

## 🧠 CORE IDEA

```text
If two prefix sums have same remainder,
their difference is divisible by k
```

---

## 🧠 VISUAL

```text
k = 5

prefix sums:
2 → rem 2
7 → rem 2

7 - 2 = 5 → divisible
```

---

## ⚠️ NEGATIVE FIX

```java
if(rem < 0) rem += k;
```

---

## 🧠 WHY

```text
-1 % 5 = -1 (wrong bucket)
but should be 4

Normalize → same group
```

---

## 🧠 SUMMARY

```text
MODULO → store remainder frequency
```

---

# 🔴 TYPE 4: TRANSFORMATION

---

## 🧠 WHEN?

```text
When problem says:
equal / balance / same count
```

---

## 🔥 TRICK

```text
0 → -1
1 → +1
```

---

## 🧠 WHY

```text
equal 0s and 1s ⇒ sum = 0
```

---

## 🧠 SUMMARY

```text
BALANCE → convert to sum = 0
```

---

# 🧠 FINAL PREFIX MAP

```text
COUNT     → frequency map
LENGTH    → first index map
MODULO    → remainder map
BALANCE   → transform to +1/-1
```

---

# ⚠️ WHEN PREFIX SUM FAILS

```text
When window needs dynamic control
(e.g. distinct elements, <= k, etc.)
```

👉 Use Sliding Window

---

---

# 🧠 2. KADANE (DROP BAD PAST)

---

## 🔥 CORE IDEA

```text
At every index:
Extend OR Restart
```

---

## 🧠 VISUAL

```text
nums = [-2, 3, -1, 5]

step:
-2 → bad → drop
3 → start
3 + (-1) = 2
2 + 5 = 7 (best)
```

---

## 🔥 DECISION

```text
If previous sum < 0 → drop it
```

---

## 🧠 FORMULA

```text
current = max(num, current + num)
```

---

## 🧠 MEANING

```text
Take only useful past
```

---

# 🔵 VARIANT: MIN SUBARRAY

---

## 🧠 REVERSE LOGIC

```text
Drop positive prefix
```

---

## FORMULA

```text
currentMin = min(num, currentMin + num)
```

---

# 🔴 VARIANT: CIRCULAR ARRAY

---

## 🧠 IDEA

```text
Case 1: normal max subarray
Case 2: wrap around
```

---

## 🔥 TRICK

```text
wrap = totalSum - minSubarray
```

---

## 🧠 VISUAL

```text
[5, -3, 5]

total = 7
min subarray = -3

answer = 7 - (-3) = 10
```

---

## ⚠️ EDGE CASE

```text
all negative → return normal Kadane
```

---

# 🟣 VARIANT: PRODUCT

---

## 🧠 PROBLEM

```text
negative flips sign
```

---

## 🔥 FIX

```text
track BOTH max and min
```

---

# 🧠 FINAL KADANE MAP

```text
MAX SUM     → drop negatives
MIN SUM     → drop positives
PRODUCT     → track min + max
CIRCULAR    → remove worst part
```

---

# 🧠 FINAL COMPARISON

```text
Sliding Window → control window
Prefix Sum     → remember past
Kadane         → drop bad past
```

---

# 🚀 FINAL LINE (REMEMBER THIS)

```text
Prefix Sum → “Have I seen this before?”
Kadane     → “Is my past useful?”
```

---

🔥 Revise this 2–3 times →
you won’t “solve” problems anymore…
you’ll **recognize patterns instantly**

---

If you want next level:

👉 I can give **pattern recognition drills (mixed problems)**
👉 Or move to **Monotonic Stack (next big weapon)**

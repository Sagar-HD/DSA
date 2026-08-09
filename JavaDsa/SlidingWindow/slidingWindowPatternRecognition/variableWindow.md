
---

# 📘 Sliding Window — Variable Window (Master Notes)

---

## 🚀 Core Idea

```
Maintain a window [left → right]

Expand (right++) → explore  
Shrink (left++) → fix invalid window  
```

---

## ⚡ Universal Template

```java
int left = 0;

for (int right = 0; right < n; right++) {

    // include current element
    add(nums[right]);

    // shrink until valid
    while (window is invalid) {
        remove(nums[left]);
        left++;
    }

    // update answer (depends on problem)
}
```

---

## 🧠 Mental Model

```
Expand → explore possibilities  
Shrink → restore validity  
Answer → depends on question type  
```

---

# 🔥 TYPES OF VARIABLE WINDOW

---

## 🟢 1. Longest Valid Window

### Pattern

```
Find longest subarray/substring satisfying condition
```

### Update

```java
maxLen = Math.max(maxLen, right - left + 1);
```

### Key Idea

```
Always maintain VALID window
```

---

## 🔵 2. Count Valid Subarrays (≤ K)

### Pattern

```
Count number of valid subarrays
```

### Update

```java
ans += (right - left + 1);
```

### Why?

```
All subarrays ending at right are valid:
[left..right], [left+1..right], ..., [right..right]
```

---

## 🔴 3. Exactly K (Important Trick)

### Pattern

```
Exact condition (e.g., exactly K distinct)
```

### Formula

```
exactly(K) = atMost(K) - atMost(K-1)
```

### Key Idea

```
Sliding window handles ≤ easily, not = directly
```

---

## 🟡 4. Minimum Window

### Pattern

```
Find smallest valid window
```

### Template Change

```java
while (window is valid) {
    updateAnswer();
    remove(nums[left]);
    left++;
}
```

### Key Idea

```
Expand → make valid  
Shrink → optimize (minimize)
```

---

## 🟣 5. Replacement / Modification

### Pattern

```
At most K changes allowed
```

### Condition

```
window size - maxFreq ≤ K
```

### Key Trick

```
Track maxFreq lazily (do NOT recompute)
```

---

## ⚫ 6. Monotonic Deque (Special Case)

### Pattern

```
Max / Min in every window
```

### Idea

```
Maintain decreasing (for max)
Maintain increasing (for min)
```

---

# 🧠 Decision Tree

```
Is it contiguous?
    YES →

    Fixed size?
        YES → Fixed Window

    Variable size?
        YES →

        Longest / max length?
            → Type 1

        Count subarrays?
            → Type 2

        Exactly K?
            → Type 3

        Minimum window?
            → Type 4

        Replacement allowed?
            → Type 5

        Max / Min in window?
            → Type 6 (Deque)
```

---

# 🔥 Golden Rules

```
1. Always expand with right pointer  
2. Shrink only when invalid  
3. Answer update depends on problem  
4. Works only when condition is MONOTONIC  
```

---

# ⚠️ When NOT to Use Sliding Window

```
- Non-contiguous problems  
- Exact condition (without trick)  
- Requires sorting / global rearrangement  
```

---

# 🧠 Final Intuition

```
We don’t check all subarrays  
We maintain a VALID RANGE  
And count / optimize within it
```

---

# 🚀 Summary

```
Sliding Window = Control the range smartly

Fixed → size k  
Variable → expand & shrink  
Count → ans += (right-left+1)  
Exact → atMost(K) - atMost(K-1)  
Replace → window - maxFreq ≤ K  
Max/Min → Deque  
```

---

# 📘 DSA Pattern 3: Fixed Sliding Window

---

# 🎯 Core Idea

Instead of recalculating every window from scratch, reuse the previous window.

```
Previous Window
      ↓
Remove Outgoing Element
      ↓
Add Incoming Element
      ↓
Current Window
```

Time Complexity

- Brute Force → **O(n × k)**
- Fixed Sliding Window → **O(n)**

---

# 🧠 First Principles

Brute Force

```
Every window
    ↓
Traverse K elements
    ↓
O(n × k)
```

Observation

Adjacent windows share almost all elements.

```
2 1 5
  1 5 1
```

Only two things change.

```
Remove Outgoing Element

+

Add Incoming Element
```

Hence we reuse previous computation.

---

# 🎯 Pattern Recognition

Ask these questions in order.

```
Is it a Contiguous
Subarray / Substring ?

        ↓

       YES

        ↓

Does every answer require
exactly K elements?

        ↓

       YES

        ↓

Fixed Sliding Window
```

---

# 🔍 Recognition Keywords

Usually (not always)

- Subarray
- Substring
- Length K
- Size K
- Exactly K
- Consecutive K
- Radius K

Don't rely on keywords.

Instead ask

> **Does every valid answer contain exactly K elements?**

---

# 📌 Window Invariant

```
Window Size = K
```

Whenever

```java
(end - start + 1) == k
```

Current window is valid.

---

# ⚙️ Generic Algorithm

```
Expand Right

↓

Window Size == K ?

↓

YES

↓

Process Current Window

↓

Remove Left Element

↓

Move Left

↓

Continue
```

---

# 💻 Generic Template

```java
while(right < n){

    include(nums[right]);

    if(right - left + 1 == k){

        processAnswer();

        exclude(nums[left]);
        left++;
    }

    right++;
}
```

---

# ⭐ Fixed Sliding Window Formula

```
New Window

=

Old Window

-

Outgoing Element

+

Incoming Element
```

Everything comes from this observation.

---

# 🧠 Window State

Sliding Window is NOT

```
Running Sum
```

Sliding Window is

```
Maintain whatever information
the window needs.
```

Examples

### Maximum Sum

```
Window State

↓

Window Sum
```

---

### Maximum Vowels

```
Window State

↓

Vowel Count
```

---

### Minimum Recolors

```
Window State

↓

White Count
```

---

### Distinct Elements

```
Window State

↓

Window Sum

+

Frequency Map
```

---

### Grumpy Bookstore

```
Window State

↓

Extra Customers
```

---

# 🔄 Process Every Problem

Before coding ask

```
Objective

↓

What is fixed?

↓

What can I control?

↓

Can I decompose the answer?

↓

Can I transform the problem?

↓

What should my window remember?

↓

Pattern?

↓

Algorithm?

↓

Code
```

---

# 🧩 Problem Transformation Patterns Learned

## 1. Fixed + Variable

### Example

Grumpy Bookstore Owner

```
Answer

=

Already Satisfied

+

Extra Satisfaction
```

---

## 2. Opposite Problem

### Example

Maximum Points from Cards

```
Take K Cards

↓

Leave N-K Cards

↓

Remaining becomes contiguous

↓

Find Minimum Window

↓

Answer

=

Total Sum

-

Minimum Window
```

---

## 3. Data Transformation

Example

```
customers

↓

extraCustomers
```

Transform the data first.

Then solve the transformed problem.

---

## 4. Complement Thinking

Instead of

```
Find Wanted
```

think

```
Find Unwanted

↓

Subtract from Total
```

---

# ❌ Common Mistakes

### 1. Processing after Sliding

Wrong

```
Slide

↓

Process
```

Correct

```
Process

↓

Slide
```

---

### 2. Forgetting Outgoing Element

```java
sum -= nums[left];
```

---

### 3. Integer Overflow

Running sum may require

```java
long sum = 0;
```

---

### 4. Integer Division

Wrong

```java
sum / k;
```

Correct

```java
(double) sum / k;
```

---

### 5. Forgetting Window Invariant

Only process when

```java
windowSize == k
```

---

# ⏱ Complexity

Each element

```
Enters Window Once

Leaves Window Once
```

Therefore

```
Time  : O(n)

Space : O(1)
```

or

```
O(Window State)
```

if HashMap / Set is used.

---

# ✅ Problems Covered

| LeetCode | Problem | Learning |
|----------|---------|----------|
| 643 | Maximum Average Subarray I | Basic Fixed Window |
| 1456 | Maximum Number of Vowels | Window State = Vowel Count |
| 1343 | Number of Subarrays of Size K and Average ≥ Threshold | Counting |
| 1052 | Grumpy Bookstore Owner | Base + Extra Transformation |
| 2090 | K Radius Subarray Averages | Radius → Window Size |
| 2379 | Minimum Recolors to Get K Consecutive Black Blocks | Operations = White Count |
| 2461 | Maximum Sum of Distinct Subarrays | Window State = Sum + Frequency Map |
| 1423 | Maximum Points You Can Obtain from Cards | Opposite Problem + Complement Thinking |

---

# 🎯 Final Recognition Checklist

Whenever you read a problem ask

```
✓ Is it contiguous?

↓

✓ Does every answer contain exactly K elements?

↓

✓ What should my window remember?

↓

✓ How does the state change when an element enters?

↓

✓ How does the state change when an element leaves?

↓

✓ Can I transform the problem into a fixed-size window?
```

If all answers point towards a fixed-size window,

**Fixed Sliding Window** is the correct pattern.

---

# 🏆 Biggest Lesson

Don't solve the English story directly.

Always convert

```
Story

↓

Observation

↓

Transformation (if needed)

↓

Invariant

↓

Pattern

↓

Algorithm

↓

Code
```

The strongest problem solvers don't know more algorithms.

They **model problems better**.
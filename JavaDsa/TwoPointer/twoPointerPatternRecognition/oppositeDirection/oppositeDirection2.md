# 🎯 Two Pointer Pattern Recognition — Part 2

## ↔️ Opposite Direction (`←  →`)

### Reverse / Palindrome / Compare Both Ends

---

## 🧠 Core Mental Model

Unlike Part 1 (which focused on **searching** sorted spaces), Part 2 is about **processing** symmetry and sequence operations.

> 💡 **The Core Shift: Process, Don't Search**
> There is:
> * ❌ **No Target Sum**
> * ❌ **No Optimization Goal**
> * ❌ **No Search Space Elimination**
> 
> 
> Both pointers start at opposite ends (`left = 0`, `right = n - 1`) and move **inward** simultaneously to compare, swap, or validate elements at each step.

---

## 🔍 Pattern Trigger Checklist

When reading a problem, ask yourself:

* [ ] **Symmetry:** Need to check if a string/sequence reads the same forwards and backwards (**Palindromes**)?
* [ ] **Reversal:** Need to **reverse** a string or array (entirely or selectively)?
* [ ] **End-to-End Comparison:** Need to process corresponding elements from both ends moving inward?

> 🚀 **If YES:** Use **Opposite Direction Inward Processing (`left++`, `right--`)**!

---

## ⚙️ Mentality Shift: Search vs. Process

| Feature | Part 1: Search Pattern | Part 2: Process Pattern |
| --- | --- | --- |
| **Primary Goal** | Find a pair/triplet meeting a target condition | Validate, transform, or reverse in-place |
| **Array State** | Requires a **Sorted** array | Works on raw strings, arrays, or lists |
| **Pointer Moves** | Conditional (`left++` **OR** `right--`) | Deterministic / Inward (`left++` **AND** `right--`) |
| **Core Action** | Sum evaluation & search elimination | Compare, Swap, or Skip Invalid elements |

---

## 🛠️ Generic Code Template

```python
left, right = 0, len(s) - 1

while left < right:
    # 1. Skip non-relevant elements (if applicable)
    while left < right and not is_valid(s[left]):
        left += 1
    while left < right and not is_valid(s[right]):
        right -= 1
        
    # 2. Process current pair (Compare / Swap / Branch)
    if s[left] != s[right]:
        # Handle mismatch or transformation
        pass
        
    # 3. Move both pointers inward
    left += 1
    right -= 1

```

---

## 🧩 Problems & Mental Models

### 1️⃣ Valid Palindrome

* **Mental Model:** Compare corresponding elements from the outside in.
* **Logic:**

$$\text{Equal?} \implies \text{Move both inward } (\texttt{left++}, \texttt{right--}) \quad \mid \quad \text{Mismatch?} \implies \text{Return False}$$



---

### 2️⃣ Valid Palindrome II (One Allowed Mistake)

* **Mental Model:** **Valid Palindrome + 1 Life 💖**
* **Logic:** At the first mismatch (`s[left] != s[right]`), you get **one branch point**:
* **Option A:** Skip left character $\rightarrow$ Check if `s[left+1 ... right]` is a palindrome.
* **Option B:** Skip right character $\rightarrow$ Check if `s[left ... right-1]` is a palindrome.
* **Result:** `Option A` $\lor$ `Option B`



---

### 3️⃣ Reverse String

* **Mental Model:** In-place element swapping.
* **Logic:** Swap `s[left]` and `s[right]`, then move both pointers inward.

> 📌 *Note for Java/Python:* Strings are immutable, so convert to a character array or list first.

---

### 4️⃣ Reverse Only Letters / Reverse Vowels

* **Mental Model:** Filtered Inward Swap.
* **Logic:**
1. Advance `left` until it points to a valid target (letter/vowel).
2. Retreat `right` until it points to a valid target.
3. **Swap** the valid targets, then move both pointers inward.



---

### 5️⃣ One Edit Distance

* **Question:** Can `s1` be converted to `s2` with **exact 1 edit** (Replace, Insert, Delete)?
* **Length Check:** If $\vert{}len(s1) - len(s2)\vert{} > 1$, return `False` immediately.
* **Pointer Decision Matrix:**

| Length Difference | Edit Type Needed | Pointer Movement on First Mismatch |
| --- | --- | --- |
| **$\Delta = 0$** | **Replace** | Advance **both** pointers, remaining characters must match |
| **$\Delta = 1$** | **Insert / Delete** | Advance **only the longer string pointer**, remaining characters must match |

---

## 🎭 How Problems Disguise This Pattern (And How to Spot Them)

Interviewers wrap these problems in clean-up tasks or array manipulation wrappers. Use this **Decoding Kit** to spot them!

---

### 🕵️ Disguise 1: Sentence / Cleaned Text Validation

* **The Mask:** *"Check if a phrase is a palindrome after removing punctuation and converting to lowercase."*
* **The Unmasking:** Don't construct a whole new string! Use two pointers with inner `while` loops to skip non-alphanumeric characters on the fly to save space ($O(1)$ auxiliary memory).

---

### 🕵️ Disguise 2: Array Rotation via Block Reversals

* **The Mask:** *"Rotate array `nums` to the right by `k` steps in $O(1)$ extra space."*
* **The Hidden Mechanism:** Three selective reversals!
1. Reverse the entire array (`0` to `n - 1`).
2. Reverse the first `k` elements (`0` to `k - 1`).
3. Reverse the remaining `n - k` elements (`k` to `n - 1`).



---

### 🕵️ Disguise 3: "Can you make it a Palindrome by deleting K elements?"

* **The Mask:** *"Is the string a $K$-palindrome?"*
* **The Unmasking:**
* If $K = 1$, it's **Valid Palindrome II** (Branching two-pointer).
* If $K > 1$, branching two pointers split too many times ($O(2^K)$) $\rightarrow$ transition to Dynamic Programming (Longest Palindromic Subsequence / LCS).



---

## 🌳 Decision Tree

```
               Need to process symmetric elements, 
                 reverse, or compare both ends?
                               │
                              YES
                               │
                 Do non-target elements exist? 
                 (punctuation, non-vowels, etc.)
                               │
               ┌───────────────┴───────────────┐
               ▼                               ▼
              YES                              NO
               │                               │
        Skip Invalid Elements             Start both ends
   (inner `while` until valid)             (left = 0, right = n-1)
               │                               │
               └───────────────┬───────────────┘
                               │
                      What operation?
                               │
    ┌──────────────────┼──────────────────┐
    ▼                  ▼                  ▼
 [Compare]          [Swap]           [Branch Once]
Compare s[left]    Swap s[left]      On 1st mismatch,
  & s[right]        & s[right]       try skip Left OR Right
    │                  │                  │
    └──────────────────┼──────────────────┘
                       │
              Move Pointers Inward
               (left++, right--)

```

---

## 📜 The Golden Rules

1. **Part 2 is PROCESS, not SEARCH.** You aren't hunting for a magic sum—you are iterating through symmetric positions.
2. **Fixed Inward Movement.** Unless skipping invalid characters or branching, pointer movement is almost always `left++` and `right--`.
3. **Skip-First Pattern.** Always clean/skip invalid elements before performing the core logic (`swap` or `compare`).
4. **Branching occurs at the FIRST failure.** For "at most 1 modification" problems, the decision branches immediately upon the first mismatch.

---

## 🏁 Final Mental Model Summary

$$\text{Opposite Ends } (\leftarrow \rightarrow) \implies \text{Skip Invalid} \implies \text{Execute Operation } (\text{Compare} \mid \text{Swap} \mid \text{Branch}) \implies \text{Move Inward } (\texttt{left++}, \texttt{right--})$$
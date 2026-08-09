
---

# 🧠 STACK PATTERN – MASTER README

---

# ⚔️ 1. CORE IDEA OF STACK

```text
LIFO → Last In First Out
```

But in DSA:

```text
Stack = CONTROL + FILTERING + NEAREST RELATIONSHIP
```

---

# 🔥 REAL USE (IMPORTANT)

Stack is used when:

```text
You need to find something NEAREST (left/right)
with a CONDITION (greater/smaller)
```

---

# 🧠 CORE TEMPLATE (MONOTONIC STACK)

```text
For every element:

1. Find answer using stack
2. Remove useless elements (cleanup)
3. Push current element
```

---

# ⚡ GOLDEN LINE

```text
"Answer → Clean → Push"
```

---

# 🧠 WHAT IS “USELESS”?

```text
Anything that cannot help:
- current element
- future elements
```

---

# ⚔️ 2. MONOTONIC STACK TYPES

---

## 🔴 Decreasing Stack

```text
Top is smallest
Used for → Next Greater
```

```java
while(stack.peek() <= current){
    stack.pop();
}
```

---

## 🔵 Increasing Stack

```text
Top is largest
Used for → Next Smaller
```

```java
while(stack.peek() >= current){
    stack.pop();
}
```

---

# 🧠 PATTERN TABLE

| Problem          | Direction    | Stack Type | Pop Condition |
| ---------------- | ------------ | ---------- | ------------- |
| Next Greater     | Right → Left | Decreasing | <=            |
| Next Smaller     | Right → Left | Increasing | >=            |
| Previous Greater | Left → Right | Decreasing | <=            |
| Previous Smaller | Left → Right | Increasing | >=            |

---

# 🧠 DIRECTION RULE

```text
If question asks RIGHT → iterate right → left  
If question asks LEFT → iterate left → right
```

---

# ⚡ CORE INTUITION

```text
Stack stores "possible nearest answers"
```

---

# 💣 DEEP TRUTH

```text
We don’t store best elements
We store POSSIBLE nearest elements
```

---

# ⚔️ 3. HISTOGRAM (MOST IMPORTANT)

---

## 🧠 PROBLEM

```text
Largest Rectangle in Histogram
```

---

## 💡 CORE SHIFT

```text
Each bar = smallest height in its rectangle
```

---

## 🧠 WHAT WE NEED

```text
Previous Smaller (left)
Next Smaller (right)
```

---

## ⚡ FORMULA

```text
width = right - left - 1
area = height * width
```

---

## 🔥 MONOTONIC IDEA

```text
When smaller element comes → finalize bigger bars
```

---

## 💣 REAL INTUITION

```text
"I die when I see a smaller element"
```

---

## ⚡ SINGLE PASS MAGIC

```text
Use increasing stack of indices

When current < stack top:
    pop and calculate area
```

---

## 🧠 WHY EXTRA 0 AT END?

```text
To flush remaining stack
```

---

# ⚔️ 4. STOCK SPAN

---

## 🧠 PROBLEM

```text
Count consecutive days where price <= today
```

---

## 💡 CORE IDEA

```text
Find Previous Greater
```

---

## ⚡ FORMULA

```text
span = i - previousGreaterIndex
```

---

## 🔥 KEY LOGIC

```java
while(price[stack.peek()] <= price[i]){
    stack.pop();
}
```

---

## 🧠 WHY <= ?

```text
Equal values are INCLUDED in span
```

---

## 💣 INTUITION

```text
Remove everything that belongs to span  
Keep only blockers
```

---

# ⚔️ 5. DEQUE (SLIDING WINDOW MAX)

---

## 🧠 PROBLEM

```text
Max in every window of size k
```

---

## 💡 CORE IDEA

```text
Maintain max dynamically using deque
```

---

## 🧠 DEQUE RULE

```text
Store indices  
Values in decreasing order
```

---

## ⚡ OPERATIONS

---

### 1️⃣ Remove OUTSIDE window

```java
if(dq.peekFirst() == i - k){
    dq.pollFirst();
}
```

---

### 2️⃣ Remove USELESS

```java
while(nums[dq.peekLast()] <= nums[i]){
    dq.pollLast();
}
```

---

### 3️⃣ Add current

```java
dq.offerLast(i);
```

---

### 4️⃣ Answer

```java
nums[dq.peekFirst()]
```

---

# 🧠 DEQUE MENTAL MODEL

```text
Front → max  
Back → weakest candidates
```

---

# 💣 TWO TYPES OF REMOVAL

| Type    | From  | Why            |
| ------- | ----- | -------------- |
| Expired | Front | Out of window  |
| Useless | Back  | Smaller values |

---

# ⚡ ONE LINE

```text
Front removes expired  
Back removes weak
```

---

# ⚔️ 6. UNIFIED MASTER THINKING

---

## 🧠 When to use STACK?

```text
Nearest greater/smaller  
Left/right dependency  
Monotonic relation
```

---

## 🧠 When to use DEQUE?

```text
Sliding window + need max/min
```

---

## 🧠 When to use NORMAL STACK?

```text
Parentheses / recursion / undo
```

---

# 💣 FINAL SUPER PATTERN

```text
1. What am I finding? (greater/smaller)
2. Which side? (left/right)
3. Maintain monotonic stack
4. Clean useless elements
5. Use top as answer
```

---

# ⚡ FINAL MINDSET

```text
Stack = future candidates  
Pop = remove dead ones  
Top = nearest valid answer
```

---

# 🧠 LAST LINE (REMEMBER THIS FOREVER)

```text
"Find answer → clean garbage → register myself"
```

---

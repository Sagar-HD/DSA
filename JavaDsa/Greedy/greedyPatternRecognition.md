
---

# 💰 GREEDY — COMPLETE PATTERN RECOGNITION README

---

# 🧠 1. FIRST PRINCIPLE

```text
Greedy = Take best choice NOW and never reconsider
```

---

# 🔥 CORE IDEA

```text
Local optimum → leads to global optimum
```

👉 BUT only works for **specific problems**

---

# 🎯 2. HOW TO IDENTIFY GREEDY

## 🔍 Signals:

```text
• maximum / minimum asked
• choices available at each step
• no need to revisit decisions
• problem feels like "pick best and move"
```

---

## 💡 Strong keywords:

```text
• earliest finish
• smallest / largest
• minimum cost
• maximum profit
• interval scheduling
```

---

# ❌ WHEN GREEDY FAILS

```text
• choices affect future heavily
• need to explore combinations
• overlapping subproblems → DP
```

👉 If unsure → try DP

---

# 🧠 3. CORE GREEDY PROPERTY

---

## ✅ Greedy Choice Property

```text
Choosing best NOW never ruins future answer
```

---

## ✅ Optimal Substructure

```text
Remaining problem is same type
```

---

# 🧩 4. MASTER GREEDY PATTERNS

---

# 🔴 1. INTERVAL SCHEDULING

---

## 🧠 Recognition:

```text
• intervals given
• maximize number of tasks
```

---

## Strategy:

```text
Sort by END time
Pick earliest finishing
```

---

## Examples:

* activity selection
* meeting rooms

---

# 🟠 2. FRACTIONAL KNAPSACK

---

## 🧠 Recognition:

```text
• can take fraction
• maximize profit
```

---

## Strategy:

```text
Sort by value/weight (ratio)
Take highest first
```

---

# 🟡 3. MINIMUM COINS (GREEDY VERSION)

---

## 🧠 Recognition:

```text
• coins given
• minimize number
```

---

⚠️ Works only for **canonical coins**

---

# 🟢 4. JOB SEQUENCING

---

## 🧠 Recognition:

```text
• deadline + profit
• maximize profit
```

---

## Strategy:

```text
Sort by profit DESC
Place job in latest free slot
```

---

# 🔵 5. MERGE / CONNECT (HEAP GREEDY)

---

## 🧠 Recognition:

```text
• combine elements
• minimize total cost
```

---

## Strategy:

```text
Always pick smallest 2
→ min heap
```

---

## Examples:

* connect ropes
* Huffman coding

---

# 🟣 6. GAS STATION / JUMP GAME

---

## 🧠 Recognition:

```text
• reach destination
• feasibility / jumps
```

---

## Strategy:

```text
track max reach
```

---

# 🟤 7. SORT + GREEDY

---

## 🧠 Recognition:

```text
Sorting simplifies decision
```

---

👉 90% greedy = **sort first**

---

# ⚡ 5. HOW TO DERIVE GREEDY (REAL SKILL)

---

## 🎯 Step-by-step:

```text
1. Can I make a choice at each step?
2. If I pick best now → will it always help?
3. Can I prove no future regret?
```

---

## 🧠 Trick:

```text
Try small examples

If greedy always works → pattern found
```

---

# 🚨 6. GREEDY vs DP (CRITICAL)

---

| Situation          | Use    |
| ------------------ | ------ |
| local choice works | Greedy |
| choices interact   | DP     |

---

## 🔥 Example:

### ❌ 0/1 Knapsack

→ Greedy fails → DP

### ✅ Fractional Knapsack

→ Greedy works

---

# 🧠 7. COMMON GREEDY PROOFS (INTUITION)

---

## Exchange Argument (important)

```text
If optimal solution differs from greedy
→ we can swap to greedy without loss
```

👉 proves greedy correctness

---

# 🧠 8. TEMPLATE THINKING

---

```text
Sort input

for(each element):
    if(valid):
        take it
```

---

# 🔥 9. COMPLETE PATTERN MAP

---

| Pattern      | Strategy             |
| ------------ | -------------------- |
| intervals    | sort by end          |
| profit       | sort by profit       |
| ratio        | sort by value/weight |
| merging      | heap                 |
| reachability | track max            |
| deadlines    | slot filling         |

---

# 🧠 10. FINAL TRIGGERS

```text
“pick best at each step” → greedy

“sort and decide” → greedy

“intervals” → sort by end

“ratio” → fractional

“merge cost” → heap greedy

“reach end” → greedy traversal
```

---

# 🧠 11. FINAL MENTAL MODEL

```text
Greedy = no backtracking
       = no revisiting
       = one pass decision making
```

---

# 🔥 FINAL LOCK

```text
If greedy works → fastest solution

If greedy fails → switch to DP
```

---

# 🚀 DONE

Now you have:

* pattern recognition ✅
* when to trust greedy ✅
* when to avoid ❌

---

# NEXT


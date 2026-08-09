
---

# 📘 RECURSION + BACKTRACKING — PATTERN RECOGNITION README

---

# 🧠 1. FIRST PRINCIPLE (DON’T SKIP THIS)

```text
Recursion = Solve problem by calling same problem on smaller input

Backtracking = Try all possibilities + undo (explore full decision tree)
```

---

# 🎯 2. HOW TO IDENTIFY RECURSION (FROM QUESTION)

## 🔍 Look for THESE signals:

### ✅ Signal 1: “Do something for every possibility”

* generate all
* print all
* return all combinations
* count all ways

👉 This = recursion (tree expansion)

---

### ✅ Signal 2: “Break into smaller same problem”

* array → smaller array
* string → substring
* n → n-1

👉 This = pure recursion

---

### ✅ Signal 3: “Choice at every step”

* pick / not pick
* include / exclude
* left / right

👉 This = decision tree

---

### ✅ Signal 4: “Constraints + valid paths”

* valid parentheses
* sudoku
* n-queens
* word search

👉 This = backtracking

---

# ❌ WHEN NOT TO USE RECURSION

### 🚫 If problem says:

* maximum / minimum (no combinations)
* sorted / binary search
* sliding window
* prefix sum

👉 Use iterative / greedy / dp

---

# 🧠 3. CORE THINKING (REAL GAME)

## Every recursion problem = TREE

```text
At each step:
    What choices do I have?
```

---

## 🔥 Example thinking

```text
String = "abc"

At index 0:
    take 'a'
    don't take 'a'

At index 1:
    take 'b'
    don't take 'b'
```

👉 This builds FULL TREE

---

# 🧩 4. TYPES OF RECURSION (FROM YOUR FILES)

---

## 1. 🟢 Linear Recursion (Simple)

👉 One call → goes deep

Examples:

* factorial
* fibonacci
* sum of array
* reverse array

### Pattern:

```java
return f(n-1)
```

---

## 2. 🟡 Recursion on Arrays

👉 Index moves

```java
f(i):
    do something
    f(i+1)
```

Used in:

* linear search
* check sorted
* move zeros

---

## 3. 🔵 Hypothesis-Induction

👉 Assume smaller problem works

Examples:

* reverse stack
* sort stack
* josephus

### Pattern:

```text
1. solve(n-1)
2. fix for nth element
```

---

## 4. 🟣 Subsets / Subsequences (MOST IMPORTANT)

👉 pick / not pick

```java
take
not take
```

Examples:

* SubSequenceOfAString
* PowerSet
* SubSetWithoutDuplicates

---

## 5. 🔴 Backtracking (CORE)

👉 try → explore → undo

Examples:

* NQueen
* Sudoku
* WordSearch
* PalindromePartitioning

### Pattern:

```java
for(choice):
    choose
    recurse
    undo
```

---

## 6. 🟠 Permutations

👉 order matters

### Pattern:

* swap OR
* visited array

Examples:

* Permutation.java
* LetterCaseChange

---

## 7. 🟤 Path Problems

👉 move in grid / graph

Examples:

* PrintPaths
* PathWithObstacles

### Pattern:

```java
go right
go down
go all directions
```

---

# 🧠 5. BACKTRACKING RECOGNITION (CRITICAL)

## 🔥 Ask:

```text
Am I exploring all possibilities AND reverting state?
```

If YES → BACKTRACKING

---

## 💡 Example

### N-Queens

```text
place queen
→ check valid
→ go next row
→ remove queen
```

---

### Word Search

```text
mark visited
→ explore neighbors
→ unmark
```

---

# ⚡ 6. TEMPLATE YOU MUST MEMORIZE

---

## 🔹 PICK / NOT PICK

```java
void solve(i){

    if(i == n){
        store
        return;
    }

    // pick
    take element
    solve(i+1)

    // not pick
    remove element
    solve(i+1)
}
```

---

## 🔹 BACKTRACKING (LOOP STYLE)

```java
void solve(){

    if(base){
        store
        return;
    }

    for(all choices){

        if(invalid) continue;

        choose
        solve()
        undo
    }
}
```

---

# 🧠 7. HOW TO DERIVE FROM QUESTION (REAL SKILL)

---

## 🎯 Step-by-step thinking:

### 1. What do they want?

* all answers? → recursion
* best answer? → not recursion

---

### 2. Can I try all possibilities?

YES → recursion

---

### 3. What are choices at each step?

👉 build tree mentally

---

### 4. Do I need to undo?

YES → backtracking

---

### 5. What is base case?

👉 when answer is ready

---

# 🧩 8. QUICK PATTERN MAP

| Problem Type   | Pattern             |
| -------------- | ------------------- |
| subsets        | pick/not pick       |
| combinations   | loop                |
| permutations   | swap/visited        |
| constraints    | backtracking        |
| path finding   | recursion + visited |
| stack problems | hypothesis          |

---

# 🧠 9. MOST IMPORTANT REALIZATION

```text
Recursion is NOT magic.

It is just:
→ tree traversal
→ depth-first search of possibilities
```

---

# 🔥 FINAL ONE-LINE TRIGGER

```text
“If problem asks ALL possibilities → think recursion tree”
“If need to revert state → backtracking”
```

---

# 🚀 NEXT MOVE



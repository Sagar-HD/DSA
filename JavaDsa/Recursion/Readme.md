# Recursion

This repository organizes recursion by **problem-solving patterns**, not by problem names. Each folder represents a different way recursion is used.

## Structure

```text
Recursion
├── Simple
├── RecursionOnArray
├── RecursionWithPassingAnsInArgs
├── RecursionCombiningAnsFromBelow
├── Backtracking
├── SubSetsAndPermutation
├── SortingWithRecursion
├── HypothesisInductionBase
└── Other
```

* **Simple** – Basic recursion and call flow.
* **RecursionOnArray** – Recursive processing of arrays.
* **RecursionWithPassingAnsInArgs** – State is propagated downward through function arguments.
* **RecursionCombiningAnsFromBelow** – Recursive calls return answers which are combined by the parent.
* **Backtracking** – Explore a search space while pruning invalid states.
* **SubSetsAndPermutation** – Choice-based recursion.
* **SortingWithRecursion** – Recursive sorting techniques.
* **HypothesisInductionBase** – Recursive solutions designed using the Hypothesis–Induction–Base method.

---

# Recursion as a State Space Graph

Every recursive problem can be viewed as traversing a **state space graph**.

* A **node** represents a state.
* An **edge** represents a valid transition (decision) from one state to another.

Examples of states:

```text
Binary Search
(low, high)

Maze
(currentRow, currentCol)

Dice
(diceUsed, currentSum)

N Queens
(currentRow, occupiedColumns)
```

The recursive function moves from one state to another until a terminal state is reached.

---

# Why DFS?

Recursion naturally performs **Depth First Search (DFS)**.

```text
State
├── Choice 1
│   ├── ...
│   └── ...
├── Choice 2
└── Choice 3
```

The function completely explores one branch before returning and exploring the next.

This is exactly DFS.

---

# Can BFS Be Used?

Yes.

The same state space can be explored using **Breadth First Search** by maintaining an explicit queue instead of the call stack.

DFS uses:

* Function call stack
* Memory proportional to recursion depth

BFS uses:

* Queue
* Stores every active state of the current level

For most recursive search problems, BFS requires much more memory because every unfinished choice must remain in the queue simultaneously.

DFS only keeps the current path.

Therefore recursive solutions are naturally written as DFS.

---

# Backtracking

Backtracking is DFS on a state space graph with pruning.

Algorithm:

1. Visit current state.
2. Generate all possible next states.
3. Ignore invalid states.
4. Recursively explore valid states.
5. Undo changes if necessary.
6. Continue with the next choice.

Only feasible states are explored.

---

# Two Recursive Views

The same recursion can be designed in two different ways.

## 1. Choice-Based Recursion

Question:

> **What choices are available from the current state?**

Example:

```text
Dice

Choose 1
Choose 2
...
Choose 6
```

The function constructs a complete solution.

State contains everything needed for future decisions.

Examples:

```text
currentSum
currentPath
visited[]
board
index
```

The state depends on previous choices, so this information is passed to recursive calls.

### Base Case

The recursion stops after all choices have been made.

Then the completed solution is validated.

```text
All dice used

sum == target ?

Yes -> 1
No  -> 0
```

Information flows **downward**.

---

## 2. Subproblem (DP) Recursion

Question:

> **What is the answer for this state?**

Example:

```text
Ways(diceLeft, remainingTarget)
```

The function does not construct solutions.

It simply returns the answer for the current state.

Parent states combine answers returned by child states.

```text
Ways(3,7)

=

Ways(2,6)
+
Ways(2,5)
+
Ways(2,4)
...
```

### Base Case

Return the answer for the smallest known problem.

Example:

```text
Ways(0,0) = 1

Ways(0,x) = 0
```

Information flows **upward**.

---

# Why Does Choice-Based Recursion Pass More Information?

Future decisions depend on previous decisions.

Example:

```text
Current Sum = 12
Dice Used = 3
```

The next recursive call must know these values because future validity depends on them.

The recursion carries the current state forward.

---

# Why Does DP Not Need Full History?

DP stores only the information required to define the remaining problem.

Example:

```text
Dice Left = 2
Remaining Target = 5
```

It does not matter whether this state was reached by

```text
1,4
```

or

```text
2,3
```

The remaining problem is identical.

The previous path is irrelevant.

A DP state is therefore a **compressed representation of history**.

---

# Why Dynamic Programming?

Pure recursion recomputes identical states.

Example:

```text
Choose 1 → Choose 2

Choose 2 → Choose 1
```

Both may reach

```text
(diceLeft = 2, remainingTarget = 5)
```

Without DP:

```text
Solve the same state repeatedly.
```

With memoization:

```text
Solve once.
Store.
Reuse.
```

The recursion tree becomes a Directed Acyclic Graph (DAG), where each unique state is computed only once.

---

# When to Use Each Approach

### Choice-Based Recursion

Use when the goal is to:

* Generate solutions
* Print solutions
* Enumerate paths
* Explore combinations
* Explore permutations
* Perform backtracking

### Subproblem (DP) Recursion

Use when the goal is to:

* Count ways
* Find minimum/maximum
* Compute optimal values
* Compute probabilities
* Avoid repeated computation using memoization

The recursive calls may be identical in both approaches. The difference lies in what the recursive function represents:

* **Choice recursion** explores decisions.
* **Subproblem recursion** returns answers for states.

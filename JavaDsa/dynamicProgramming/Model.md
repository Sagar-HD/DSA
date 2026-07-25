# 🧭 The Ultimate DP Blueprint: State Design & Execution

> Dynamic Programming is **not** about converting recursion into a table.
> It is the art of framing a subproblem with **exactly enough information** to derive its answer from smaller subproblems.

---

## 🗂️ Table of Contents

1. [Part 1: The DP Design Workflow](https://www.google.com/search?q=%23-part-1-the-dp-design-workflow)
2. [Part 2: Push vs. Pull & The State Reduction Pivot](https://www.google.com/search?q=%23-part-2-push-vs-pull--the-state-reduction-pivot)
3. [Part 3: Worked Example: Longest Common Substring](https://www.google.com/search?q=%23-part-3-worked-example-longest-common-substring)
4. [Part 4: Core Mental Triggers & Golden Rules](https://www.google.com/search?q=%23-part-4-core-mental-triggers--golden-rules)

---

## 📐 Part 1: The DP Design Workflow

When tackling any DP problem, start with whatever recursive mental model comes naturally. Once you have a working recursive intuition, refine the state dimensions before building the DP table.

```text
                        PROBLEM
                           │
                           ▼
              Write Natural Recursion 
               (Push or Pull Model)
                           │
                           ▼
          What information is being carried?
                           │
                           ▼
          Can this variable be derived from
             the other state variables?
                           │
            ┌──────────────┴──────────────┐
           YES                            NO
            │                             │
            ▼                             ▼
     Remove Redundant           Can I redefine the state 
        Variable                 so this info becomes 
                                   the DP VALUE?
                                         │
                          ┌──────────────┴──────────────┐
                         YES                            NO
                          │                             │
                          ▼                             ▼
                  Reframe as Pull DP           Keep Extra Dimension
                 (Reduced Dimension)          (e.g., dp[i][j][count])

```

---

## ⚡ Part 2: Push vs. Pull & The State Reduction Pivot

### 1. Write What Feels Natural First

When encountering a new problem, write down whichever recursion model comes to mind first:

* **Push Recursion:** Accumulates information downward through parameters as you traverse choices (e.g., `solve(index, current_sum, current_streak)`).
* **Pull Recursion:** Queries child subproblems upward and returns a value to the parent (e.g., `solve(index) = best_of(solve(index + 1))`).

Both Push and Pull recursion can technically be converted into DP tables. However, **Pull DP is heavily preferred** for tabulation because it yields cleaner dependency loops and direct array assignments.

---

### 2. The Push State Reduction Trap

In Push recursion, state parameters often represent **accumulated history** passed forward (e.g., running total, current matching streak, available capacity).

Attempting to reduce dimensions while staying in a Push mindset is often difficult or impossible because future states depend on that carried history.

---

### 3. The Pivot: Reframe Push into Pull

To reduce state space, pivot your perspective:

> **Instead of asking:** *"What running state am I carrying forward?"* (Push)
> **Ask:** *"What does this subproblem contribute/return on its own?"* (Pull)

By redefining the subproblem in terms of what it **returns** rather than what it **receives**, accumulated history parameters are transformed into the **value stored inside the DP table**.

```text
PUSH RECURSION (Carries History)             PULL DP (Returns Contribution)
--------------------------------             -----------------------------
f(i, j, streak)                     ──►      dp[i][j] = Longest streak
State: (i, j, streak)                        ENDING at (i, j)
Extra dimension required!                    Dimension reduced!

```

---

## 🧪 Part 3: Worked Example: Longest Common Substring

### Step 1: Natural Push Recursion

When comparing strings $A$ and $B$, the initial intuition is often to push the running streak forward:

```text
f(i, j, streak)

```

* **State:** $(i, j, \text{streak})$
* **Is `streak` redundant?** No. You can reach $(i, j)$ with different running streak lengths.
* **Direct Memoization:** Requires a 3D table `dp[i][j][streak]` (expensive in time and space).

---

### Step 2: The Pull State Pivot

To drop the `streak` dimension, reframe the subproblem into a Pull state:

> Define $dp[i][j]$ as: **The length of the longest common substring ENDING at index $i$ in string A and index $j$ in string B.**

Now, `streak` is no longer a function argument passed down. It is the **value returned** by the subproblem:

$$\text{State Space Reduction: } (i, j, \text{streak}) \longrightarrow (i, j)$$

```text
if A[i] == B[j]:
    dp[i][j] = 1 + dp[i-1][j-1]
else:
    dp[i][j] = 0

```

The core problem never changed—only the subproblem definition was pivoted to a Pull structure to drop the extra dimension.

---

## 🧠 Part 4: Core Mental Triggers & Golden Rules

### The State Reduction Decision Matrix

| Question | Outcome | Action |
| --- | --- | --- |
| **Is the variable mathematically derivable from other state parameters?** | **YES** | Drop the variable immediately. |
| **Can the variable be represented as what the subproblem returns?** | **YES** | Reframe as Pull DP. Convert parameter into the DP stored value. |
| **Is the variable an independent degree of freedom that cannot be returned?** | **NO** | Retain it as an explicit DP table dimension (e.g., $dp[i][j][k]$). |

---

### 👑 The DP Golden Rule

1. **Start Natural:** Write whichever recursion model (Push or Pull) comes to mind first.
2. **Inspect Carried Variables:** Identify extra arguments tracking accumulated history.
3. **Reframe to Pull:** Convert carried history into the DP table's return value to drop dimensions.
4. **Tabulate:** Build the Pull DP table using clean, ordered loops ($0 \to n$ or $n \to 0$).
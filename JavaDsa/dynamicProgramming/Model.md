```markdown
# Mental Model: Push vs Pull Recursion & DP

```text
                    USER PROBLEM
                         │
                         ▼
               Define State (English)
                         │
                         ▼
          Does this state answer "what do I
          already know" or "what do I need
          from below"?
                         │
          ┌──────────────┴──────────────┐
          │                             │
          ▼                             ▼
      PUSH MODEL                    PULL MODEL
 "I know this. Let me          "I don't know this.
  tell my future self."         Let me ask my children."
          │                             │
          ▼                             ┌────────┴────────┐
   State Propagation                    │                 │
 (DFS / Reachability /                  ▼                 ▼
  Relaxation)                     Backward Pull      Forward Pull
          │                       (Prefix State)    (Suffix State)
          │                             │                 │
          ▼                             ▼                 ▼
   Memo = visited[]               Memo = answer[]   Memo = answer[]
          │                             │                 │
          ▼                             ▼                 ▼
   Tabulation                    Tabulation        Tabulation
          │                             │                 │
          ▼                             ▼                 ▼
 Initialize source               Initialize Base   Initialize Base
 (starting state)                     Cases             Cases
          │                             │                 │
          ▼                             ▼                 ▼
 Propagate Forward                 Fill 0 → n        Fill n → 0
          │                             │                 │
          ▼                             ▼                 ▼
 Read destination               Return dp[n][K]   Return dp[0][0]
 (goal state)

```

---

## 🎯 Step 0: The Core DP Decision

When transitioning from pure recursion to Dynamic Programming, the entire structure of your memoization table and loops hinges on one fundamental question about your state:

> 💡 **"At the moment I define `dp[state]`, do I already have enough information to compute its value directly — or does computing it require answers from states I haven't computed yet?"**

* **If you already have enough info:** You are **pushing** that finalized value forward to update future states.
* **If you need info from unvisited states:** You are **pulling** values back from dependencies to build the current state.

This is a design decision made when you frame the state, not an immutable property of the problem. Same problem, different state framing = completely different mode.

### Example: The Knapsack Problem Both Ways

* **Pull (Suffix) Formulation:**
`solve(i, w)` = *"Best value using items from index i onward, with capacity w"*
`solve(i, w)` depends on `solve(i+1, w)` and `solve(i+1, w - wt[i])`. This is a classic **Forward Pull** requiring a table fill from $n \rightarrow 0$.
* **Push (Prefix) Formulation:**
`dp[i][w]` = *"Best value achievable using the first i items, with capacity w"*
Built via **Forward Propagation / Relaxation**. You process item `i` and immediately push its finalized effect forward to update `dp[i+1][*]`. This is a **Push Model** requiring a table fill from $0 \rightarrow n$.

---

## 🫸 THE PUSH MODEL

### 1. Pure Push Recursion (State Generation)

Used when the goal is exploration, configuration check, or total generation rather than optimal value accumulation.

* **Natural Home:** *DFS, Flood Fill, Maze Traversal, N-Queens, Sudoku Solver, Generating Subsets/Permutations, Combination Sum.*
* **The Mindset:** *"I know my current state layout perfectly. Let me hand it off to create valid children."*
* **Information Flow:** Parent $\rightarrow$ Children. No return value flows back up that alters correctness; you are mapping state space reachability.

### 2. Push DP (Forward Propagation / Relaxation)

Used when processing edges, events, or transitions in an explicit order where each step updates downstream possibilities.

* **Natural Home:** *DAG Longest/Shortest Path (Topological Relaxation), Bellman-Ford, Floyd-Warshall, Reachability DP, Automata/State Machine DP, BFS-layer DP, Online Streaming Algorithms.*
* **The Mindset:** *"This state is already valid and finalized. Let me update all future states that can be reached from here."*

### DP Execution Pipeline

1. **Initialize:** Set the starting source state(s) to a base value (e.g., `dp[src] = 0` or `true`).
2. **Propagate:** Iterate forward through states, pushing updates down to future dependencies.
3. **Memoization Strategy:** Uses a `visited[]` array or distance check (`if (next_dist > curr_dist + weight)`) to track finalized states.
4. **Read Output:** The answer is read directly from the destination goal state at the end of execution.

---

## 🫴 THE PULL MODEL

In a Pull model, a state's value is calculated as a direct function of its children's values. You cannot resolve the parent until you recursively or iteratively query the children first.

### 1. Backward Pull (Prefix State)

* **State Shape:** `dp[i]` = *"Best/possible answer using the first i elements"*
* **Natural Home:** *0/1 Knapsack (Prefix framing), Subset Sum, Partition Problems, Target Sum, Coin Change.*
* **The Mindset:** *"My answer for the first `i` items depends directly on the already-known answers for the first `i-1` items."*
* **Information Flow:** Children (`dp[i-1]`) $\rightarrow$ Parent (`dp[i]`).
* **Execution Profile:** Initialize base case `dp[0]`. Fill table sequentially from **$0 \rightarrow n$**. Return `dp[n][...]`.

### 2. Forward Pull (Suffix State)

* **State Shape:** `dp[i]` = *"Best/possible answer starting from index i onward to the end"*
* **Natural Home:** *LCS, Edit Distance, Distinct Subsequences, Wildcard/Regex Matching, Word Break, Decode Ways.*
* **The Mindset:** *"My answer at this current position depends on pulling the answers from future positions."*
* **Information Flow:** Children (`dp[i+1]`) $\rightarrow$ Parent (`dp[i]`).
* **Execution Profile:** Initialize base case `dp[n]`. Fill table backward from **$n \rightarrow 0$**. Return `dp[0][0]`.

---

## ⚖️ Diagnostic Matrix: When Direction is Forced

While many DP problems can be modeled both ways, certain constraints will force your hand:

| Forces PUSH Only | Forces PULL Only |
| --- | --- |
| **Online/Streaming Input:** Future items do not exist yet when you process index `i`. You must push current data into a running state. | **Global Logic Dependencies:** You need a single global evaluation that logically requires evaluating all execution branches completely before an answer is known (e.g., full string parsers). |
| **No Fixed Topology:** The graph has no clean recursive structure (e.g., general graphs with negative edges like Bellman-Ford). | **Strict Decomposition:** The state breaks down cleanly into smaller, completely isolated subproblems with zero state cross-talk. |
| **Incremental Queries:** You need to support anytime queries mid-computation. | **Bounded Stack Space:** The recursion tree depth is small enough that the language's call stack handles execution natively and cleanly. |

---

## 🧠 One-Line Mental Triggers

* **PUSH:** *"I already know something. Let me propagate it forward, once, as I learn it."*
`Initialize Start` $\rightarrow$ `Propagate updates` $\rightarrow$ `Read Final Goal`
* **PULL:** *"I don't know my answer yet. Let me ask my children for theirs and combine them."*
`Initialize Base Cases` $\rightarrow$ `Compute Dependencies` $\rightarrow$ `Return Root State Value`

---

## 👑 The DP Golden Rule

> **The state you choose defines the recursion.**
> **The recursion defines the dependencies.**
> **The dependencies define whether you are pushing or pulling — not the problem itself.**
> * **Push Mode:** Destination states accumulate the final answer as a cumulative side-effect of forward propagation.
> * **Pull Mode:** The initial recursive state call's returned value *is* the final answer.
> 
> 

```

```
# 🧠 THE DSA PATTERN ENGINE

### A Complete Mental Framework for Cold-Classifying Unseen Problems & Killing Wrong Hypotheses

---

## 0. Why This System Works: Vocabulary vs. Structure

Most engineers fail cold-recognition because they match **vocabulary keywords** rather than **underlying mathematical invariants**.

```
❌ WEAK RECOGNITION (Keyword-Driven):
   "Find max sum..." ──► Kadane's ──► Fails when array contains negative multipliers

✅ STRONG RECOGNITION (Structure & Rejection Engine):
   "Contiguous subarray + Optimization" ──► Candidate: Sliding Window
                                         └──► Run Rejection Test: Is window monotonic?
                                               ├── YES ──► Sliding Window
                                               └── NO  ──► REJECT ──► Prefix Sum / DP

```

> **The 3-Part Rule for Every Pattern:**
> 1. **TRUE SIGNAL:** The underlying structural invariant (not story words).
> 2. **TRAP:** The look-alike problem that tricks keyword matching.
> 3. **REJECT WHEN:** The 5-second fatal condition test that proves a hypothesis wrong.
> 
> 

---

## 1. The Seven-Layer Pipeline

```
┌─────────────────────────────────────────────────────────────────────────────┐
│ LAYER 1: Decode Story      ──► Strip vocabulary to Input, Output, Ask       │
├─────────────────────────────────────────────────────────────────────────────┤
│ LAYER 2: Constraint Gate   ──► Map N to strict Time Complexity Budget       │
├─────────────────────────────────────────────────────────────────────────────┤
│ LAYER 3: Candidate Engine  ──► Generate 2–3 structural candidate patterns   │
├─────────────────────────────────────────────────────────────────────────────┤
│ LAYER 4: Rejection Matrix  ──► Run fatal invariant tests to kill candidates │
├─────────────────────────────────────────────────────────────────────────────┤
│ LAYER 5: Transformations   ──► If all candidates die, apply disguise map    │
├─────────────────────────────────────────────────────────────────────────────┤
│ LAYER 6: N=3 Simulation    ──► Dry-run surviving pattern on tiny trace      │
├─────────────────────────────────────────────────────────────────────────────┤
│ LAYER 7: Implement & Code  ──► Select optimal Data Structures & write code  │
└─────────────────────────────────────────────────────────────────────────────┘

```

---

## 2. Layer 1 — Decode the Story (Story Vocabulary Translator)

Before pattern matching, convert story prose into raw mathematical objects using this lookup engine:

| Story Vocabulary Phrase | Raw Abstract Mathematical Object |
| --- | --- |
| "rooms", "islands", "provinces", "friend circles" | **Connected components in a graph** |
| "cheapest", "minimum cost to connect all" | **Minimum Spanning Tree (MST) or Shortest Path** |
| "ways to reach", "ways to climb", "ways to decode" | **Counting paths (Combinatorial DP)** |
| "maximum profit", "best time to buy/sell" | **Sequence DP or Greedy Choice** |
| "can you partition", "split into two equal sums" | **Subset-Sum Decision Transform** |
| "next warmer day", "next greater element", "span" | **Monotonic Stack** |
| "k-th largest", "top k frequent elements" | **Min/Max Heap or Quickselect** |
| "rotting oranges", "infection spreads", "simultaneous" | **Multi-Source BFS** |
| "prerequisite", "must complete A before B" | **Topological Sort (DAG)** |
| "smallest window containing required chars" | **Variable Sliding Window** |
| "ways to form target, reuse elements allowed" | **Unbounded Knapsack DP** |
| "ways to form target, use each element once" | **0/1 Knapsack DP** |
| "longest chain/sequence, order fixed in input" | **LIS-Family DP** |
| "edit string A into string B with min operations" | **Edit Distance (2D Matrix DP)** |
| "matching brackets", "valid nesting structure" | **LIFO Stack** |
| "range sum / range updates across many queries" | **Prefix Sum / Segment Tree / Binary Indexed Tree** |
| "running median", "median of continuous stream" | **Two-Heap System (Max-Heap + Min-Heap)** |
| "schedule meetings without overlap", "max events" | **Greedy Interval Scheduling (Sort by end time)** |
| "group anagrams", "find items with same structure" | **Hash Map by Canonical Key / Signature** |

> ### 📌 The 1-Line Protocol
> 
> 
> If you cannot state your problem in this exact format, you are not ready to match patterns:
> **`INPUT:`** `<type>` *(e.g., Array of ints, Unweighted Graph, Two Strings)*
> **`OUTPUT:`** `<type>` *(e.g., Int count, Boolean, Maximum value, List of paths)*
> **`ASK:`** `<verb>` *(e.g., Count / Maximize / Minimize / Check Existence / Find Shortest)*

---

## 3. Layer 2 — Constraints as a Hard Gate

Your complexity budget instantly eliminates non-viable pattern families before you write code.

| $n$ Constraint Range | Max Allowed Complexity | Patterns Allowed | Patterns KILLED |
| --- | --- | --- | --- |
| $n \le 12 - 20$ | $O(2^n)$ / $O(n \cdot 2^n)$ | Bitmask DP, Full Subset Enumeration, Backtracking | Polynomial $O(n^2)$ assumptions (author hints at exponential) |
| $n \le 400 - 500$ | $O(n^3)$ | 3D Matrix DP, Floyd-Warshall, Range/Interval DP | High-degree exponential algorithms |
| $n \le 2000 - 5000$ | $O(n^2)$ | DP on Pairs, Nested Loops, 2D Sequence Alignment (LCS) | $O(n^2 \log n)$ heavy sorting or cubic loops |
| $n \le 10^5$ | $O(n \log n)$ | Sorting + Binary Search, Heap, Segment Tree, Monotonic Stack | Plain $O(n^2)$ DP, Un-memoized Recursion |
| $n \le 10^6 - 10^7$ | $O(n)$ / Tight $O(n \log n)$ | Sliding Window, Two Pointers, Prefix Sum, Hash Maps, DSU | Heavy log factors per element, deep recursive call stacks |
| $n \ge 10^9$ or Stream | $O(\log n)$ / $O(1)$ | Math Formulas, Binary Search on Answer, Matrix Exponentiation | Any algorithm performing a full $O(n)$ pass |

> **⚠️ Second-Order Signal:** If an array problem specifies an unusually small constraint (e.g., $n \le 20$), the author is explicitly signaling a **Bitmask DP / Subset State Search**, regardless of array vocabulary!

---

## 4. Layers 3 & 4 — Candidate Generation & Rejection Tests

### 4.1 Sliding Window / Two Pointer

* **🟢 TRUE SIGNAL:** Contiguous subarray/substring + **monotonic window condition** (expanding window only increases/decreases target metric).
* **🟡 TRAP:** "Contiguous subarray with max sum" (looks like sliding window, but negative numbers ruin window shrinking).
* **🔴 REJECT WHEN:** Non-monotonic condition. Expanding window can make a state valid $\rightarrow$ invalid $\rightarrow$ valid again. Go to **Prefix Sum + Hash Map** or **DP**.

### 4.2 Prefix Sum (+ Hash Map)

* **🟢 TRUE SIGNAL:** Subarray sum equals target $k$, or range sum queries $f(i, j)$ with negative numbers present.
* **🟡 TRAP:** Appears solvable by Sliding Window, but negative values break two-pointer expansion guarantees.
* **🔴 REJECT WHEN:** You need optimal boundary tracking under complex monotonic constraints rather than count/existence checks.

### 4.3 Kadane’s / Local-Global DP

* **🟢 TRUE SIGNAL:** Maximum or minimum sum/product of a contiguous array with negative values.
* **🟡 TRAP:** "Maximum Subarray Product" — negative values flip signs (min becomes max).
* **🔴 REJECT WHEN:** State transition relies on multiple historical steps or non-associative operators. For products, track both **`max_so_far` AND `min_so_far**`.

### 4.4 Binary Search

* **🟢 TRUE SIGNAL A:** Array is sorted or explicitly ordered.
* **🟢 TRUE SIGNAL B (Disguise):** Monotonic Answer Space. "Can we achieve target $X$ under constraint $C$?" is boolean monotonic (`true` for all $X \ge \text{threshold}$).
* **🟡 TRAP:** Phrased as "Minimize the Maximum" or "Maximize the Minimum" (sounds like DP, usually BS on Answer).
* **🔴 REJECT WHEN:** Predicate `can(x)` is non-monotonic (i.e., `can(x) = true` does **not** guarantee `can(x+1) = true`).

### 4.5 Monotonic Stack

* **🟢 TRUE SIGNAL:** Find the **nearest** element on left/right satisfying a comparison operator ($>$, $<$, $\ge$, $\le$).
* **🟡 TRAP:** "Find the $k$-th greatest element so far" (requires global ordering, not nearest neighbor).
* **🔴 REJECT WHEN:** You require global ranking or top-$k$ elements $\rightarrow$ **Reject Stack, use Heap**.

### 4.6 Heap / Priority Queue

* **🟢 TRUE SIGNAL:** $k$-th largest/smallest, dynamic top-$k$, merging $k$ sorted lists, running median.
* **🟡 TRAP:** Sorting the full array works, but Heap is required when input is **streaming** or $k \ll n$.
* **🔴 REJECT WHEN:** $k = n$ (just sort directly), or priority depends on topological/spatial adjacency $\rightarrow$ **Use Stack or Graph**.

### 4.7 DFS / BFS (Trees & Graphs)

* **🟢 TRUE SIGNAL:** Explicit graph, tree traversal, or implicit state space (grid cells, word transformations).
* **🟡 TRAP:** Using BFS for shortest path on weighted graphs (BFS assumes uniform edge cost = 1).
* **🔴 REJECT WHEN:**
* Weights are non-uniform $\rightarrow$ **Reject BFS, use Dijkstra**.
* Seeking shortest path $\rightarrow$ **Reject DFS** (DFS must exhaustively check all paths).
* Graph contains negative weights $\rightarrow$ **Reject Dijkstra, use Bellman-Ford**.



### 4.8 Topological Sort

* **🟢 TRUE SIGNAL:** Explicit prerequisites, task ordering, dependency resolution, DAG validation.
* **🟡 TRAP:** Using plain DFS when cycle detection in a directed graph is mandatory for validity.
* **🔴 REJECT WHEN:** Graph is guaranteed cycle-free and only simple reachability is needed $\rightarrow$ **Use basic DFS/BFS**.

### 4.9 Union-Find / Disjoint Set Union (DSU)

* **🟢 TRUE SIGNAL:** Dynamic connectivity queries ("Are $A$ and $B$ connected now?"), incremental edge additions.
* **🟡 TRAP:** Static graph connectivity (DSU works, but single-pass DFS/BFS is simpler and faster).
* **🔴 REJECT WHEN:** Graph is completely static and only a single final count of components is asked $\rightarrow$ **Use DFS/BFS**.

### 4.10 Trie (Prefix Tree)

* **🟢 TRUE SIGNAL:** String prefix matching ("starts with"), dictionary autocomplete, XOR maximum pair matching (Bit-Trie).
* **🟡 TRAP:** "Find all strings containing substring $X$" (Trie only optimizes prefixes, not arbitrary substrings).
* **🔴 REJECT WHEN:** Queries involve arbitrary substring matching or anagram signatures $\rightarrow$ **Use Hash Maps or Suffix Trees**.

### 4.11 Backtracking / Full Search

* **🟢 TRUE SIGNAL:** "Find ALL permutations / subsets / combinations / paths". Ask is **enumeration**, not optimal count.
* **🟡 TRAP:** "Count number of valid paths" sounds like backtracking, but overlapping subproblems cause TLE.
* **🔴 REJECT WHEN:** Subproblems overlap (same index and remaining target reached via different decisions) $\rightarrow$ **Add Memoization (DP)**.

### 4.12 Dynamic Programming (DP)

* **🟢 TRUE SIGNAL:** Optimal Substructure + Overlapping Subproblems (maximizing/minimizing or counting over sequence choices).
* **🟡 TRAP:** Reaching for DP when a Greedy choice is provably optimal.
* **🔴 REJECT WHEN (The Counter-Example Test):** Can you craft **ONE** counter-example where taking the locally optimal choice leads to a worse global answer?
* **Counter-Example Found** $\rightarrow$ **Confirm DP**.
* **No Counter-Example Possible** $\rightarrow$ **REJECT DP, use Greedy**.



### 4.13 Greedy Algorithms

* **🟢 TRUE SIGNAL:** Sorting along a single axis (end time, value-to-weight ratio) produces a provably optimal left-to-right processing sweep.
* **🔴 REJECT WHEN:** 0/1 Choice Constraints appear (e.g., 0/1 Knapsack where item cannot be fractionally taken). Local optimal pick blocks global optimal combination $\rightarrow$ **Fall back to DP**.

---

## 5. Layer 5 — The Transformation Catalog (Disguise Decoder)

When a problem resists direct pattern matching, apply these algebraic and structural transformations:

```
                  ┌──────────────────────────────────────────────┐
                  │           TRANSFORMATION CATALOG             │
                  └──────────────────────┬───────────────────────┘
                                         │
        ┌────────────────────────────────┼────────────────────────────────┐
        │                                │                                │
┌───────▼────────┐              ┌────────▼────────┐              ┌────────▼────────┐
│ 5.1 SUBSET SUM │              │ 5.3 PALINDROME  │              │ 5.5 BS ON ANSWER│
│ Assign + / -   │              │ LCS on String   │              │ Monotonic      │
│ to hit Target  │              │ and Reverse(S)  │              │ Feasibility fn  │
└───────┬────────┘              └────────┬────────┘              └────────┬────────┘
        │                                │                                │
        ▼                                ▼                                ▼
  Subset Target =                 LPS(S) =                         Binary Search
 (Total + T) / 2                  LCS(S, Rev(S))                   Search Range X

```

### 5.1 $\rightarrow$ Subset-Sum Transformation

* **Signal:** Partition array into two subsets with equal sum, or assign $+/-$ signs to each number to reach target $T$.
* **Algebraic Proof:**

$$\text{Sum}(+) - \text{Sum}(-) = T$$


$$\text{Sum}(+) + \text{Sum}(-) = \text{TotalSum}$$


$$\implies 2 \cdot \text{Sum}(+) = \text{TotalSum} + T \implies \mathbf{\text{Sum}(+) = \frac{\text{TotalSum} + T}{2}}$$


* **Result:** Problem transforms directly into classic **0/1 Subset-Sum DP**.

### 5.2 $\rightarrow$ Longest Common Subsequence (LCS) Family

* **Signal:** Two sequences, "min insertions/deletions to make equal", "shortest common supersequence".
* **Core Transform:** All sequence alignment problems map to $DP[i][j]$ state matrices comparing prefix $A[0..i]$ with $B[0..j]$.

### 5.3 $\rightarrow$ Palindrome DP via LCS

* **Signal:** "Longest Palindromic Subsequence in string $S$".
* **Core Transform:** $\text{LPS}(S) \equiv \text{LCS}(S, \text{Reverse}(S))$. Solved instantly using standard LCS DP.

### 5.4 $\rightarrow$ Implicit Graph Construction

* **Signal:** Word Ladder ("change one letter at a time"), Knight moves on chessboard, Min steps using given operators.
* **Core Transform:**

$$\mathbf{\text{State}} \equiv \text{Graph Node} \quad \vert{} \quad \mathbf{\text{Valid Move}} \equiv \text{Directed Edge}$$



Unweighted state transitions $\rightarrow$ **BFS**. Weighted state transitions $\rightarrow$ **Dijkstra**.

### 5.5 $\rightarrow$ Binary Search on the Answer Space

* **Signal:** "Minimize the maximum load", "Maximize the minimum distance between points".
* **Core Transform:** Instead of searching input data, binary search over the continuous answer range $[X_{\min}, X_{\max}]$. Write a simple predicate function `can(X)` to validate feasibility in $O(n)$.

### 5.6 $\rightarrow$ Complement Space (Negative-Space Thinking)

* **Signal:** Direct condition is complex with multiple overlapping edge cases.
* **Core Formulas:**

$$\text{Target Count} = \text{Total Combinations} - \text{Invalid Combinations}$$


$$\text{Max Valid Subarray} = \text{Total Length} - \text{Min Invalid Subarray}$$



### 5.7 $\rightarrow$ "Exactly K" Sliding Window Transformation

* **Signal:** Subarrays with **exactly** $K$ distinct elements (non-monotonic under direct window sliding).
* **Core Transform:**

$$\mathbf{\text{Exactly}(K) = \text{AtMost}(K) - \text{AtMost}(K - 1)}$$



Since $\text{AtMost}(K)$ is strictly monotonic, it is trivially solved with standard sliding window!

### 5.8 $\rightarrow$ Matrix Grid as Graph

* **Signal:** 2D grid, connected component counting ("islands"), infection spread.
* **Core Transform:** Grid cells $(r, c)$ are nodes; 4-directional or 8-directional adjacencies are edges. Simultaneous spreading processes $\rightarrow$ **Multi-Source BFS**.

### 5.9 $\rightarrow$ Interval Processing as Greedy-After-Sort

* **Signal:** "Max non-overlapping intervals", "Minimum conference rooms needed".
* **Core Transform:**
* Max non-overlapping intervals $\rightarrow$ **Sort by END time** (Greedy choice).
* Min overlapping tracks needed $\rightarrow$ **Sort by START time + Min-Heap of end times**.



---

## 6. Layer 6 & 8 — Verification & Negative-Space Toolkit

Before writing code, run your candidate pattern through this **$N=3$ trace mental model** to catch edge-case failures:

> ### 🧪 The $N=3$ Dry Run Test
> 
> 
> 1. Pick a minimal hand trace ($n=3$ or $n=4$).
> 2. Test boundary edge cases: All negative numbers, duplicate values, sorted order.
> 3. Verify monotonic invariant holding at step $i \rightarrow i+1$.
> 
> 

### Standing Complement Formulas

* **Probability:** $P(\ge 1 \text{ event}) = 1 - P(\text{zero events})$
* **Subarrays:** $\text{Count(Exactly } K) = \text{Count(At Most } K) - \text{Count(At Most } K - 1)$
* **Optimization:** $\max(\text{Valid Subset}) = \sum(\text{All Elements}) - \min(\text{Invalid Subset})$

---

## 7. Master Decision Flowchart

```
                                  ┌───────────────────────────┐
                                  │ DECODE: Input / Output /  │
                                  │ Ask 1-Line Protocol       │
                                  └─────────────┬─────────────┘
                                                │
                                  ┌─────────────▼─────────────┐
                                  │ CHECK CONSTRAINTS GATE    │
                                  │ Calculate Complexity      │
                                  └─────────────┬─────────────┘
                                                │
         ┌──────────────────────────────────────┼──────────────────────────────────────┐
         │                                      │                                      │
  ARRAY / STRING                           GRAPH / TREE                            SELECTION /
  (Contiguous / Subsequence)               (Explicit / Implicit)                   COMBINATORICS
         │                                      │                                      │
   ┌─────┴──────────────┐                 ┌─────┴──────────────┐                 ┌─────┴──────────────┐
   │ Contiguous Run?    │                 │ Weighted Edges?    │                 │ Enumerate ALL vs.  │
   └─────┬──────────────┘                 └─────┬──────────────┘                 │ Find OPTIMAL?      │
         │                                      │                                └─────┬──────────────┘
   ┌─────┴─────┐                          ┌─────┴─────┐                                │
  YES          NO                        YES          NO                         ┌─────┴─────┐
   │           │                          │           │                         ALL        OPTIMAL
   │        Binary Search                 │          BFS                        │            │
 Monotonic? (Sorted/Answer)               │       (Unweighted)              Backtracking  Greedy / DP
   │           │                       Negative?                                 + Memo       │
 ┌─┴─┐       ┌─┴─┐                        │                                      (DP)    Counter-Ex
YES  NO     YES  NO                     ┌─┴─┐                                             Test Passed?
 │    │      │    │                    YES  NO                                             │
 │  Prefix  BS   LIS                   │    │                                            ┌─┴─┐
 │   Sum   Ans   DP                 Bellman Dijkstra                                    YES  NO
 Sliding                             Ford                                                │    │
 Window                                                                                 DP  Greedy

```

---

## 8. Worked Disguise Walkthroughs

### Walkthrough A — "House Robber in a Circular Street"

* **Input:** Array of integers `houses[]`, cyclic constraint (first and last house are adjacent).
* **Ask:** Maximize sum with no two adjacent houses chosen.
* **Attempt 1:** Standard linear DP. **REJECT:** Circularity breaks the $DP[i] = \max(DP[i-1], DP[i-2] + \text{val})$ invariant at index $n-1$.
* **Transformation:** Break cycle into two independent linear DP subproblems:

$$\text{Result} = \max(\text{Rob}(houses[0 \dots n-2]), \text{Rob}(houses[1 \dots n-1]))$$


* **Simulation:** Tested on $[2, 3, 2] \rightarrow \max(\text{Rob}[2, 3], \text{Rob}[3, 2]) = 3$. Verified!

### Walkthrough B — "Minimum Days to Make $m$ Bouquets from $k$ Adjacent Flowers"

* **Input:** `bloomDay[]` array, integers $m$ and $k$.
* **Ask:** Minimum day $D$ to collect $m$ contiguous groups of $k$ bloomed flowers.
* **Attempt 1:** DP over day states. **REJECT:** Days value space is huge ($10^9$), subproblem state space explodes.
* **True Signal:** Predicate function `canMakeBouquets(day)` is **monotonic** (If $D$ days is enough, $D+1$ days is guaranteed enough).
* **Pattern:** **Binary Search on Answer Space** $[1, \max(bloomDay)]$.
* **Feasibility Check:** $O(n)$ greedy sweep over `bloomDay` checking contiguous bloomed count $\ge k$.

### Walkthrough C — "Subarray Sum Equals $K$ (Negatives Allowed)"

* **Input:** Array `nums[]` with positive and negative integers, target $K$.
* **Ask:** Total count of contiguous subarrays summing to $K$.
* **Attempt 1:** Sliding Window. **REJECT:** Negatives destroy window sum monotonicity (expanding window can decrease sum).
* **Transformation:** **Prefix Sum + Hash Map**. Maintain running prefix sum $P$. At index $j$, query frequency of seen prefix sum $P - K$ in map.
* **Verification:** Handles negative steps seamlessly where sliding window fails.

---

## 9. Quick-Reference Rejection Table

| If problem looks like... | But check this invariant... | If invariant fails, switch to... |
| --- | --- | --- |
| **Sliding Window** | Is window expansion/contraction strictly monotonic? | **Prefix Sum + Hash Map** or **DP** |
| **Kadane’s Algorithm** | Are negative values multiplied (sign flips)? | **Track dual states (`max_so_far`, `min_so_far`)** |
| **Binary Search** | Is array sorted, OR is the answer space monotonic? | **Sequence DP** or **Two Pointers** |
| **BFS Shortest Path** | Are all edge weights strictly equal ($w = 1$)? | **Dijkstra** (if $w \ge 0$) or **Bellman-Ford** (if $w < 0$) |
| **DFS Path Finding** | Is the ask for the MINIMUM/SHORTEST path? | **BFS** or **Dijkstra** (DFS doesn't guarantee shortest) |
| **Greedy Choice** | Can you construct 1 counter-example where choice fails? | **Dynamic Programming (DP)** |
| **Backtracking (Count)** | Do recursive calls hit duplicate $(idx, \text{state})$ pairs? | **Memoized DP** |
| **DSU / Union-Find** | Is edge topology dynamic, or completely static? | **Single-pass DFS/BFS** (if static) |
| **Trie Structure** | Are queries prefix-based, or arbitrary substrings? | **Hash Map** / **Suffix Automaton** |
| **Monotonic Stack** | Is neighbor lookup local, or is global ranking required? | **Min/Max Heap** |
| **"Exactly K" Window** | Can window expand/shrink predictably with exact $K$? | **$\text{AtMost}(K) - \text{AtMost}(K-1)$** |

---

## 10. The Standing Pre-Code Checklist

```
[ ] 1. Written 1-line PROTOCOL: INPUT, OUTPUT, ASK.
[ ] 2. Checked N constraint bounds and locked Time Complexity Budget.
[ ] 3. Selected 2–3 Candidate Patterns based on Structural Invariants.
[ ] 4. Executed REJECTION TESTS against every candidate hypothesis.
[ ] 5. Applied TRANSFORMATION CATALOG if direct patterns were rejected.
[ ] 6. Performed N=3 trace dry-run to verify edge-case boundaries.
[ ] 7. Confirmed optimal Data Structures before typing code.

```

---

## 💡 The Core Axiom

> **Weak Problem Solver:** Keyword in statement $\rightarrow$ Recall pattern $\rightarrow$ Write buggy code.
> **Strong Problem Solver:** Structure in statement $\rightarrow$ Generate candidates $\rightarrow$ **Actively try to REJECT each candidate** $\rightarrow$ Confirm survivor on $N=3$ trace $\rightarrow$ Write optimal code.

---

### 
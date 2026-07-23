# Subsets, Combinations & Permutations


# 1. The Biggest Difference

Almost every recursion problem in this folder belongs to one of these two categories.

## Category 1 : Binary Choice (Subset / Combination)

At every element, ask:

```text
Take this element?
OR
Don't take this element?
```

Example:

```text
Array : [1,2,3]

Element 1
├── Take
└── Don't Take

Element 2
├── Take
└── Don't Take

Element 3
├── Take
└── Don't Take
```

Notice:

* We make a decision **about one element**.
* After deciding, we **move forward**.
* We never revisit previous elements.

The recursion naturally progresses using an **index**.

State:

```text
(index)
```

---

## Category 2 : Variable Choice (Permutation)

Permutation is completely different.

We are **not deciding about elements.**

Instead we ask:

> **Which element should occupy the next position?**

Example:

```text
Array : [1,2,3]

Position 0

Choices:
1
2
3
```

Suppose we place

```text
2
```

Now

```text
Position 1

Choices:
1
3
```

Now

```text
Position 2

Choices:
3
```

Notice:

The available choices change every level.

Initially

```text
3 choices
```

Then

```text
2 choices
```

Then

```text
1 choice
```

Unlike subsets, the choices are **not fixed.**

---

# One Sentence To Remember

## Subset / Combination

> Decide **whether to take** an element.

## Permutation

> Decide **which unused element** should go in the next position.

That single difference changes the entire recursion.

---

# 2. Why Combination Moves Forward

Suppose

```text
1 2 3 4
```

After processing

```text
1
```

there is never a reason to come back.

Why?

Because

```text
{1,2}
```

and

```text
{2,1}
```

represent the same combination.

Order doesn't matter.

So moving only forward automatically avoids duplicates.

---

# 3. Why Permutation Doesn't Move Forward

Suppose

```text
1 2 3
```

If we choose

```text
2
```

first,

the next choices are

```text
1
3
```

Notice

We still need element

```text
1
```

even though it appeared before 2 in the array.

Therefore we cannot simply move forward.

Instead we ask

> Which unused element is available?

That is why permutations use

* visited[]
* remaining input
* swapping

instead of only an index.

---

# 4. Binary Choices vs Variable Choices

## Binary Choice

Every recursion makes exactly two calls.

```text
Take

Don't Take
```

Example

* Subsets
* Combination Sum
* Include / Exclude problems

---

## Variable Choice

Every recursion loops over all available choices.

Example

```java
for(each available choice){
    choose
    recurse
}
```

Problems

* Permutations
* N Queens
* Sudoku
* Word Search
* Graph coloring

---

# 5. Why Backtracking?

Many people think backtracking is required.

It is not.

Backtracking is simply a memory optimization.

Without backtracking

```java
List<Integer> next = new ArrayList<>(current);
```

Each recursion owns its own copy.

Very simple.

But creates many objects.

---

With backtracking

```java
current.add(x);

recurse();

current.remove(current.size()-1);
```

The same list is reused.

Less memory.

Less copying.

Same recursion.

Same answer.

Only the implementation differs.

---

# 6. Different Ways To Generate Permutations

All methods solve exactly the same problem.

Only the state representation changes.

---

## Method 1 : Insertion Method

State

```text
Processed
Unprocessed
```

Idea

Take the next character and insert it into every possible position.

Example

```text
Processed = ab

Next = c

cab
acb
abc
```

Very intuitive.

No backtracking required.

---

## Method 2 : Visited Array

State

```text
Current Answer

visited[]
```

Idea

Choose any unused character.

Mark it visited.

Recurse.

Undo.

Most common interview solution.

---

## Method 3 : Remaining Input

State

```text
Current Answer

Remaining Input
```

Idea

Instead of remembering visited characters,

remove the chosen character from the remaining input.

Example

```text
Input

abc

Choose b

Remaining

ac
```

Very clean approach.

No visited array.

---

## Method 4 : Swapping

State

```text
Current Arrangement

Current Index
```

Idea

Fix one position at a time.

Swap every possible character into the current position.

Move to the next position.

Most memory efficient.

Common in interview questions.

---

# Why do all four work?

All four solve the same problem.

They simply represent the recursion state differently.

| Method          | State                             |
| --------------- | --------------------------------- |
| Insertion       | Processed + Unprocessed           |
| Visited         | Current Answer + visited[]        |
| Remaining Input | Current Answer + Remaining Input  |
| Swap            | Current Arrangement + Fixed Index |

Although the state changes,

the recursive choice is always

> **Choose the next character to place.**

---

# 7. Combination Methods

---

## Take / Don't Take

Classic recursion.

Every element has two choices.

```text
Take

Don't Take
```

Used for

* Subsets
* Target Sum
* Combination Sum
* Include / Exclude problems

---

## Start Index Method

Instead of explicitly saying

```text
Don't Take
```

we simply continue the loop.

```java
for(i=start;i<n;i++)
```

This automatically avoids duplicates.

Very common in backtracking.

---

## Target Problems

State

```text
Index

Current Answer

Remaining Target
```

Every recursive call reduces

```text
Target
```

until

```text
0
```

is reached.

---

# 8. Recursive vs Iterative

Recursive thinking

```text
Go deep

Return

Explore sibling
```

---

Iterative thinking

```text
Build one level completely

Then move to next level
```

Subsets

Duplicate all existing subsets.

Add current element.

---

Permutations

Take all existing partial permutations.

Insert the new character at every position.

---

# 9. Common Mistakes

### ans.add(cur)

Wrong

Stores only the reference.

After backtracking every answer becomes empty.

Correct

```java
ans.add(new ArrayList<>(cur));
```

Always copy the current answer before storing.

---

### Duplicate Handling

Subsets

Sort first.

Skip duplicates.

---

Permutations

Use a HashSet at every level.

Each position should choose a duplicate character only once.

---

### Forgetting State

Always ask

> What information uniquely describes the remaining work?

That is your recursion state.

---

# 10. Cheat Sheet

| Problem            | Choice                              | State                            |
| ------------------ | ----------------------------------- | -------------------------------- |
| Subset             | Take / Don't Take                   | index                            |
| Combination        | Take / Skip                         | index                            |
| Combination of K   | Choose next from remaining          | start index                      |
| Combination Sum    | Take / Skip or Loop                 | index + target                   |
| Permutation        | Choose any unused element           | visited / remaining input / swap |
| Permutation (Swap) | Choose element for current position | index                            |

---

# Final Mental Model

Whenever you see a recursion problem, ask these questions.

### Question 1

Am I deciding **about an element?**

If yes,

it is usually a **Subset / Combination** problem.

---

### Question 2

Am I deciding **who should occupy the next position?**

If yes,

it is usually a **Permutation** problem.

---

### Question 3

Does every recursion have exactly two choices?

If yes,

it is a **Binary Choice** recursion.

---

### Question 4

Does every recursion loop over all available choices?

If yes,

it is a **Variable Choice** recursion.

---

If you can answer these four questions before writing code, you'll usually recognize the correct recursion pattern within a few seconds.

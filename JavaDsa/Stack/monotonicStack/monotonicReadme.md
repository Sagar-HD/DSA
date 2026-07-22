# Monotonic Stack 🏢

## 🌆 The Building Story

Imagine every building has a person standing on its roof asking:

> **"What is the first taller building I can see on my right?"**

Instead of looking right for every building again and again, we scan **from right to left** so that when we reach a building, we already know everything about its right side.

---

## 📊 Visualizing the Skyline

Building heights:

```text
       🏢 (5)
       ███
       ███         🏢 (4)
 🏢 (3)███         ███
 ███   ███   🏢 (2)███
 ███   ███   ███   ███   🏢 (1)
 ███   ███   ███   ███   ███
───────────────────────────────
  3     5     2     4     1   ◀── Scan Right → Left
```

---

## 📓 The Notebook

Think of the stack as a **notebook of buildings that are still useful**.

Whenever we visit a new building:

- If it is **taller**, scratch out every shorter building.
- If it is **shorter**, simply write it down.

Only buildings that might help someone further left stay in the notebook.

---

## 💭 Where Does the Stack Idea Come From?

The brute-force solution is:

```java
for every building
    scan right until you find a taller one
```

The same buildings are scanned repeatedly.

So ask:

> **Can I remember what I already discovered instead of searching again?**

At first you may think:

> "I'll just remember the tallest building."

That fails.

Example:

```text
5 4 3
```

For `3`, the answer is `4`, not `5`.

So we must remember **multiple valid candidates**, not just one.

---

## 🗑️ Why Remove Buildings?

Consider:

```text
5 2 8
```

When `8` arrives:

- `2` becomes useless.
- `5` also becomes useless.

Why?

Because `8` is:

- taller
- closer

Nobody further left will ever choose `2` or `5` before reaching `8`.

So remove them immediately.

The notebook should contain **only useful candidates**.

---

## 📚 Why a Stack?

Suppose the notebook contains:

```text
Top
2
3
4
5
```

Now building `6` arrives.

Buildings disappear like this:

```text
2 ❌
3 ❌
4 ❌
5 ❌
```

Notice the order.

The **newest** building disappears first.

The **oldest** disappears last.

That's exactly **Last-In, First-Out (LIFO)**.

A stack isn't chosen because the problem says *Next Greater*.

It is chosen because **useful candidates naturally become useless in reverse order of insertion.**

---

## 🎯 Why Is the Answer on Top?

This is the most important idea.

The goal isn't just to keep useful buildings.

The goal is to arrange them so that **the nearest valid answer is always at the top.**

Example:

```text
Top
4
5
```

Current building = `3`.

Both are taller.

Which answer do we want?

`4`.

Since we scanned from right to left, `4` was added later than `5`, so it naturally sits on top.

Now consider:

```text
Current = 6

Top
2
3
4
5
```

Remove every shorter building.

Either:

- the stack becomes empty → answer = `-1`
- or the first taller building reaches the top.

That top building is automatically:

- ✔ taller
- ✔ nearest

So the answer is simply:

```java
answer = stack.isEmpty() ? -1 : stack.peek();
```

We never search the stack.

We maintain it so the answer is already waiting on top.

---

## 📜 Core Algorithm

```java
while (!stack.isEmpty() && stack.peek() <= currentHeight)
    stack.pop();

answer = stack.isEmpty() ? -1 : stack.peek();

stack.push(currentHeight);
```

---

## 🧠 Why Does This Work?

Every building in the notebook satisfies two properties:

- It is still useful.
- No taller, closer building has hidden it.

Whenever a taller building arrives, remove every building it permanently hides.

After those removals, the building on top is automatically the nearest valid answer.

---

## 🔎 How to Recognize a Monotonic Stack Problem

Start from the brute-force solution.

```java
for every element
    scan left/right until some condition is met
```

Now ask:

> **What am I repeatedly searching for?**

If you're repeatedly looking for:

- nearest greater
- nearest smaller
- previous greater
- previous smaller

then ask:

> **Can I carry only the useful candidates?**

If some candidates become **permanently useless** when a new element arrives, remove them immediately.

That's exactly when a **monotonic stack** appears.

Typical problems:

| Pattern | Problems |
|---------|----------|
| Greater | Next Greater, Previous Greater, Daily Temperatures, Stock Span |
| Smaller | Next Smaller, Previous Smaller, Largest Rectangle |
| Visibility | Visible People in Queue |
| Boundaries | Trapping Rain Water |
| Greedy | Remove K Digits |

---

## ⏱️ Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

Even though there is a nested `while` loop, every building:

- enters the stack once,
- leaves the stack at most once.

So total operations ≤ `2n`.

---

## 💡 One-Line Intuition

> **A monotonic stack is a notebook of useful candidates. Whenever a new building permanently hides older ones, scratch them out immediately. After this pruning, the nearest valid answer is already sitting on top, waiting to be used.**
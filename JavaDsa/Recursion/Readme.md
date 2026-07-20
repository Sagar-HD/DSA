# Mental Model: Recursion — Why It Exists

Most books define recursion as

> **"A function calling itself."**

While that is technically correct, it doesn't explain **why recursion exists** or **why anyone would ever want a function to call itself.**

To understand recursion, forget the definition for a moment and think about how we naturally solve problems.

---

# The Story: Where Recursion Comes From

Imagine you're writing code normally.

Suppose someone asks you to print:

```java
print(1);
print(2);
print(3);
print(4);
print(5);
```

This works.

But tomorrow someone asks you to print till **100**.

Then till **1000**.

Now you notice something.

You are **not writing different logic every time.**

The work is exactly the same.

Only the **input changes**.

Naturally, you think,

> **"Instead of writing the same code again and again, why don't I call the same function again with the next input?"**

That observation is the birth of recursion.

A function is allowed to call another function.

Nothing says that the other function cannot be **itself**.

So instead of writing the same code repeatedly, we simply let the function call itself with a different input.

Now only one question remains.

> **"When should it stop?"**

The answer to that question is called the **base case**.

The base case is not a special recursion concept.

It simply means:

> **"This is the condition after which I don't need to repeat the same work anymore."**

That's the entire idea behind recursion.

Whenever the **same work needs to be performed repeatedly on different inputs**, recursion naturally matches that requirement.

---

# Two Different Problems Naturally Fit This Idea

Once recursion exists, we start noticing that many completely different problems naturally fit this pattern.

Interestingly, they fall into two categories.

---

# Story 1 — The Walker

Imagine someone tells you:

> **"From here, keep walking straight, then turn right. Repeat these instructions until you reach your destination."**

Notice what is happening.

The same instruction is repeated again and again.

```
Walk

↓

Take Right

↓

Walk

↓
Take Right

↓

Destination
```

This perfectly matches recursion.

The same function keeps calling itself to repeat the same instruction.

Now ask,

> **"When do I stop?"**

The answer is simple.

When I reach the destination.

That stopping condition becomes the **base case**.

And something important happens here.

The moment we stop,

**we already have our answer.**

There is nothing left to calculate.

Nothing needs to be combined.

The recursive calls only existed to repeat the same instruction.

This way of thinking is called

# Push Recursion

because every recursive call simply **pushes the work forward** until the stopping condition itself becomes the answer.

---

# Story 2 — The Mathematician

Now imagine asking a mathematician

> **"What is the sum of the first `n` numbers?"**

Can they immediately answer?

Usually, no.

This is how we naturally solve almost every difficult problem in real life.

If we don't already know the answer as a fact,

we build it from smaller answers.

For example,

```
Sum(5)

=

5 + Sum(4)
```

But

```
Sum(4)

=

4 + Sum(3)
```

Then

```
Sum(3)

=

3 + Sum(2)
```

Eventually we reach something whose answer is already known.

```
Sum(1)=1
```

This becomes the **base case**.

Notice the difference from the walker.

Stopping here **does not** give the final answer.

Stopping only gives us the **smallest known fact**.

Now the recursive calls start returning.

As the call stack returns,

each function simply combines its own contribution.

```
Sum(2)=2+1

↓

Sum(3)=3+3

↓

Sum(4)=4+6

↓

Sum(5)=5+10
```

Every function is saying,

> **"Once the smaller answer comes back, I'll add my own part to it."**

Even mathematical formulas were discovered like this.

For example,

```
n(n+1)/2
```

didn't magically appear.

Someone first solved many smaller cases,

noticed the pattern,

and finally compressed everything into one formula.

This style of recursion is called

# Pull Recursion

because every recursive call **pulls** the answer from a smaller recursive call and combines it into its own answer.

Unlike Push,

the base case is **not** the final answer.

It is only the smallest known fact from which every larger answer is built.

---

# The Difference Between Push and Pull

Every recursive problem can be understood by asking one simple question.

> **"When I reach the base case, do I already have my answer?"**

If the answer is

> **Yes.**

Then it is **Push Recursion**.

The answer is obtained the moment recursion stops.

If the answer is

> **No. I still have to combine smaller answers while returning.**

Then it is **Pull Recursion**.

The answer is built while the **call stack unwinds**.

That is the only difference.

---

# Pull Recursion Can Be Modeled in Two Ways

Once you've decided that your problem is Pull Recursion,

you can model it in two different directions.

## Backward Pull

The base case is the **smallest known answer**.

```
1

↓

2

↓

3

↓

...

↓

n
```

Recursion keeps going until it reaches the smallest fact.

Then while returning through the call stack,

every function combines its own contribution.

Examples:

- Factorial
- Sum
- Tree Height
- Reverse Stack

---

## Forward Pull

Sometimes the problem is naturally defined from the other side.

Instead of asking

> **"Answer till i"**

we ask

> **"Answer from i till the end."**

Now the recursion keeps moving toward the end.

```
0

↓

1

↓

2

↓

...

↓

n
```

The base case now lives at the end instead of the beginning.

When recursion reaches it,

the complete answer is still **not ready**.

The answer is still built only while the recursive calls return.

So this is **still Pull Recursion**.

The only thing that changes is **where the base case is placed**.

---

# Forward vs Backward Recursion (Different Concept)

Your repository also has folders named

- `ForwardRecursion`
- `BackwardRecursion`

These are talking about something completely different.

They answer a different question.

Instead of asking

> **"When do I get my answer?"**

they ask

> **"When do I perform my work?"**

Forward Recursion

```text
Work

↓

Recursive Call
```

Backward Recursion

```text
Recursive Call

↓

Work
```

This is simply about whether the work happens before or after the recursive call.

It is completely independent of Push and Pull.

---

# Repository Structure

The folders in this repository follow these mental models.

- **Simple/** introduces recursion itself and demonstrates the difference between doing work before or after the recursive call.
- **RecursionOnArray/** applies the same recursive operation repeatedly on arrays.
- **HypothesisInductionBase/** teaches Pull recursion using the hypothesis-induction-base way of thinking.
- **RecursionCombiningAnsFromBelow/** focuses entirely on combining answers while returning through the call stack.
- **RecursionWithPassingAnsInArgs/** demonstrates Push recursion by carrying the answer downward instead of combining it later.
- **Backtracking/** repeatedly makes choices until a stopping condition is reached, undoing those choices while returning.
- **SubSetsAndPermutation/** explores every possible choice using recursive branching.
- **SortingWithRecursion/** applies recursion to recursive sorting techniques.
- **RecursionSimulationByStack/** demonstrates how recursion actually behaves internally by simulating the call stack explicitly.

---

# Golden Rule

> **Recursion exists because we observed that whenever the same work must be repeated on different inputs, the simplest solution is to let the same function call itself repeatedly.**

> **The base case simply tells recursion when to stop repeating that work.**

> **If stopping itself gives the answer, it's Push Recursion.**

> **If stopping only gives the smallest known fact and the answer is built while the call stack returns, it's Pull Recursion.**

> **Forward Pull and Backward Pull only differ in where the base case is defined. In both cases, the answer is still built while the call stack unwinds.**

> **Forward Recursion and Backward Recursion are a different idea altogether—they only describe whether the work happens before or after the recursive call.**
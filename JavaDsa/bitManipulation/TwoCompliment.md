# Two's Complement — Understanding Negative Numbers in Binary

Two's complement can initially look like a random rule:

> To represent a negative number, flip all the bits and add `1`.

But **why?**

Why flip the bits?
Why add `1`?
Why does this represent a negative number?
Why does an 8-bit signed number range from `-128` to `127`?
What does modular arithmetic have to do with any of this?

The key idea is:

> **Two's complement is not fundamentally a "flip bits + 1" trick. It comes naturally from fixed-width binary arithmetic and modular arithmetic.**

---

# 1. Start With 8 Bits

We'll use **8 bits** because they're easier to visualize.

> In Java, `byte` is 8 bits.
> `short` is 16 bits, `int` is 32 bits, and `long` is 64 bits.

With 8 bits, we have:

```text
00000000
to
11111111
```

Each bit has 2 possibilities:

```text
0 or 1
```

Therefore:

```text
2^8 = 256
```

possible bit patterns exist.

They are:

```text
00000000
00000001
00000010
...
11111110
11111111
```

So there are **256 unique combinations**, not 255.

---

# 2. If We Interpret Them as Unsigned Numbers

Unsigned means:

> There are no negative values.

We simply interpret normal binary:

```text
00000000 =   0
00000001 =   1
00000010 =   2
...
01111111 = 127
10000000 = 128
...
11111111 = 255
```

Therefore an unsigned 8-bit integer has the range:

```text
0 → 255
```

Or generally, for `N` bits:

```text
0 → 2^N - 1
```

For 8 bits:

```text
0 → 2^8 - 1
0 → 255
```

---

# 3. Bits Themselves Don't Know What They Mean

This is extremely important.

Suppose memory contains:

```text
11111011
```

Memory doesn't store a label saying:

```text
"This is 251"
```

or:

```text
"This is -5"
```

It just contains bits:

```text
Memory
┌──────────────────┐
│    11111011      │
└──────────────────┘
```

How we **interpret** those bits determines the value.

For example:

```text
11111011
     │
     ├── unsigned interpretation → 251
     │
     └── signed two's complement → -5
```

Same bits.

Different interpretation.

---

# 4. Fixed-Width Binary Arithmetic Wraps Around

Here is where things get interesting.

The largest unsigned 8-bit value is:

```text
11111111 = 255
```

What happens if we add `1`?

```text
  11111111
+ 00000001
------------
1 00000000
```

The mathematical result is:

```text
256
```

But we only have **8 bits**.

There is no room for the extra leftmost bit.

So keeping only the lower 8 bits gives:

```text
00000000
```

Therefore, in 8-bit arithmetic:

```text
255 + 1 → 0
```

Visualize the numbers as a circle:

```text
        0
        ↑
        │
255 ←───┘

0 → 1 → 2 → 3 → ... → 253 → 254 → 255
↑                                      │
└──────────────────────────────────────┘
```

After `255`, we wrap back to `0`.

This is **modular arithmetic**.

For 8 bits:

```text
mod 256
```

because:

```text
2^8 = 256
```

Generally, an `N`-bit integer naturally behaves modulo:

```text
2^N
```

---

# 5. Think of It Like a Clock

A normal clock works modulo 12.

After:

```text
10 → 11 → 12
```

the next hour wraps around:

```text
1
```

Similarly, 8-bit binary arithmetic works like a **256-position clock**:

```text
0 → 1 → 2 → ... → 254 → 255 → 0 → 1 ...
```

So:

```text
256 ≡ 0 (mod 256)
```

Likewise:

```text
257 ≡ 1 (mod 256)
258 ≡ 2 (mod 256)
```

This wraparound behavior gives us a clever way to represent negative numbers.

---

# 6. What Should `-5` Mean?

Forget binary for a moment.

What is the most important property of `-5`?

It cancels `+5`:

```text
5 + (-5) = 0
```

So in our 8-bit system, we want to find a bit pattern `X` such that:

```text
5 + X = 0
```

But remember our numbers wrap around at `256`.

Therefore reaching `256` is equivalent to reaching `0`:

```text
256 ≡ 0 (mod 256)
```

So we can instead ask:

```text
5 + X = 256
```

Solve for `X`:

```text
X = 256 - 5

X = 251
```

Therefore:

```text
5 + 251 = 256
```

and in 8-bit arithmetic:

```text
256 → 0
```

So:

```text
5 + 251 → 0
```

That means the bit pattern normally representing unsigned `251` can represent:

```text
-5
```

in signed two's-complement interpretation.

---

# 7. Convert 251 to Binary

```text
251 = 11111011
```

Therefore:

```text
+5 = 00000101

-5 = 11111011
```

Again:

```text
11111011
```

hasn't magically become negative.

We are **interpreting** this bit pattern as `-5` in the signed two's-complement system.

---

# 8. The Real Two's Complement Formula

For an `N`-bit number:

```text
-x is represented by:

2^N - x
```

For 8 bits:

```text
2^8 - x
=
256 - x
```

So for `-5`:

```text
256 - 5
=
251
```

Binary:

```text
251 = 11111011
```

Therefore:

```text
-5 = 11111011
```

This is the fundamental idea.

---

# 9. Then Why Do People Say "Flip Bits + 1"?

Now we can derive it instead of memorizing it.

We know:

```text
-x = 256 - x
```

Rewrite:

```text
256 - x
=
255 - x + 1
```

Therefore:

```text
-x = (255 - x) + 1
```

Now notice:

```text
255 = 11111111
```

Suppose:

```text
x = 5

00000101
```

Calculate:

```text
255 - 5
```

In binary:

```text
  11111111
- 00000101
------------
  11111010
```

Look carefully.

Original:

```text
00000101
```

Result:

```text
11111010
```

Every bit flipped!

Why?

Because each bit of `255` is `1`.

For every position:

```text
1 - 0 = 1
1 - 1 = 0
```

Therefore:

```text
255 - x
```

is equivalent to:

```text
flip every bit of x
```

---

# 10. Now Add the Missing `+1`

Remember:

```text
256 - x
=
255 - x + 1
```

And:

```text
255 - x
=
flip(x)
```

Therefore:

```text
256 - x
=
flip(x) + 1
```

And because:

```text
-x = 256 - x
```

we finally get:

```text
-x = flip(x) + 1
```

🎯 That is where the famous rule comes from.

It is **not an arbitrary trick**.

It falls directly out of modular arithmetic.

---

# 11. Example: Find `-5`

Start with:

```text
+5

00000101
```

### Step 1 — Flip every bit

```text
00000101
↓
11111010
```

### Step 2 — Add 1

```text
  11111010
+ 00000001
------------
  11111011
```

Therefore:

```text
+5 = 00000101
-5 = 11111011
```

---

# 12. Verify That It Actually Works

Let's calculate:

```text
5 + (-5)
```

Binary:

```text
  00000101
+ 11111011
------------
1 00000000
```

But we're working with only 8 bits.

Discard the carry outside those 8 bits:

```text
00000000
```

Therefore:

```text
5 + (-5) = 0
```

Exactly what we wanted.

---

# 13. Another Example: `-10`

Start:

```text
10 = 00001010
```

Flip:

```text
11110101
```

Add 1:

```text
  11110101
+ 00000001
------------
  11110110
```

Therefore:

```text
-10 = 11110110
```

Check using the mathematical method:

```text
256 - 10
=
246
```

And:

```text
246 = 11110110
```

Same result.

---

# 14. Why Signed 8-Bit Range Is -128 to +127

There are:

```text
256
```

possible patterns.

Two's complement interprets them as:

```text
00000000 =    0

00000001 =   +1
00000010 =   +2
...
01111111 = +127

10000000 = -128
10000001 = -127
...
11111110 =   -2
11111111 =   -1
```

So the range is:

```text
-128 → +127
```

Count them:

```text
128 negative values
127 positive values
1 zero

128 + 127 + 1
=
256
```

All 256 bit patterns are used.

---

# 15. Why Is There One More Negative Number?

Positive side:

```text
0 → 127
```

Negative side:

```text
-1 → -128
```

There are 128 negative numbers but only 127 strictly positive numbers.

Why?

Because one pattern is needed for:

```text
0
```

Two's complement has only **one zero**:

```text
00000000
```

This gives the signed 8-bit range:

```text
-128 → 127
```

instead of:

```text
-127 → 127
```

---

# 16. The Most Significant Bit

In an 8-bit signed two's-complement number:

```text
bit 7                           bit 0
 ↓                               ↓
[ ? ][ ? ][ ? ][ ? ][ ? ][ ? ][ ? ][ ? ]
```

If the most significant bit is:

```text
0 → non-negative
1 → negative
```

Examples:

```text
01111111 → +127

00000101 → +5

11111011 → -5

10000000 → -128
```

Be careful with the phrase **"sign bit."**

Two's complement is not simply:

```text
first bit = sign
remaining bits = magnitude
```

For example:

```text
10000101
```

does NOT mean:

```text
-5
```

Two's complement uses the entire bit pattern to represent the value.

---

# 17. How Do I Read a Negative Two's-Complement Number?

Suppose you see:

```text
11111011
```

The first bit is `1`, so it's negative.

To find its magnitude, reverse the two's-complement operation.

Flip:

```text
11111011
↓
00000100
```

Add 1:

```text
00000100
+
00000001
--------
00000101
```

That's:

```text
5
```

Therefore:

```text
11111011 = -5
```

---

# 18. Unsigned vs Signed — Same Bits

This is worth repeating.

Take:

```text
11111011
```

Unsigned:

```text
128 + 64 + 32 + 16 + 8 + 2 + 1
=
251
```

So:

```text
unsigned → 251
```

Signed two's complement:

```text
signed → -5
```

Therefore:

```text
             11111011
              /     \
             /       \
            ▼         ▼

      unsigned       signed
         251           -5
```

The bits did not change.

The **interpretation changed**.

---

# 19. Does Java Convert Numbers Every Time They're Stored?

Don't imagine Java doing this repeatedly:

```text
"I see -5"

↓ flip

↓ add 1

↓ store
```

Two's complement is fundamentally the binary representation used for Java's signed integer primitive types.

For example:

```java
byte x = -5;
```

The corresponding 8-bit representation is:

```text
11111011
```

Memory ultimately stores bits.

The JVM/CPU operations work according to the integer representation and instruction semantics.

---

# 20. Java Integer Sizes

Java's integral primitive types:

```text
byte  →  8 bits
short → 16 bits
int   → 32 bits
long  → 64 bits
char  → 16-bit unsigned code unit
```

For `int`:

```text
N = 32

2^32 possible bit patterns
```

Signed range:

```text
-2^31
to
2^31 - 1
```

Therefore:

```text
-2147483648
to
 2147483647
```

The same two's-complement idea applies.

---

# 21. Two's Complement Formula for Any Bit Width

For `N` bits:

```text
Number of patterns:

2^N
```

Unsigned range:

```text
0 → 2^N - 1
```

Signed two's-complement range:

```text
-2^(N-1) → 2^(N-1) - 1
```

Representation of `-x`:

```text
2^N - x
```

And:

```text
2^N - x

= (2^N - 1 - x) + 1
```

Since:

```text
2^N - 1
```

is `N` ones:

```text
111111...111
```

subtracting `x` flips every bit.

Therefore:

```text
-x
=
flip(x) + 1
```

---

# 22. Java's `~` Operator

Java provides the bitwise NOT operator:

```java
~
```

It flips every bit.

Conceptually, for an 8-bit example:

```text
00000101
↓ ~
11111010
```

Therefore two's complement can be thought of as:

```text
-x = ~x + 1
```

For Java integers:

```java
int x = 5;

int negative = ~x + 1;
```

produces:

```text
-5
```

This gives the important identity:

```text
-x = ~x + 1
```

Rearranging:

```text
~x = -x - 1
```

So another useful Java identity is:

```text
~x = -(x + 1)
```

Example:

```text
~5 = -6
```

---

# 23. Why `n & -n` Works

This becomes much easier once two's complement makes sense.

Take:

```text
n = 12
```

Binary using 8 bits:

```text
12

00001100
```

Find `-12`.

Flip:

```text
11110011
```

Add 1:

```text
11110100
```

So:

```text
 n = 00001100
-n = 11110100
```

Now AND them:

```text
   00001100
 & 11110100
 -----------
   00000100
```

Result:

```text
00000100 = 4
```

That is the **rightmost set bit of 12**.

Therefore:

```java
n & -n
```

isolates the rightmost set bit.

Why?

Two's complement causes the bits around the rightmost `1` to line up in exactly the way needed for AND to remove everything except that bit.

This is why understanding two's complement is better than memorizing:

```java
n & -n
```

as a random trick.

---

# 24. Why `n & (n - 1)` Removes the Rightmost Set Bit

Take:

```text
n = 12

00001100
```

Subtract 1:

```text
n - 1

00001011
```

Compare:

```text
n     = 00001100
n - 1 = 00001011
```

AND:

```text
  00001100
& 00001011
----------
  00001000
```

The rightmost set bit disappeared.

Therefore:

```java
n & (n - 1)
```

removes the rightmost set bit.

This becomes useful for efficiently counting set bits.

---

# 25. Why Two's Complement Is So Useful

Suppose computers used completely separate representations and algorithms for:

```text
positive addition
negative addition
subtraction
```

hardware would become more complicated.

Two's complement gives a beautiful property:

```text
A - B
=
A + (-B)
```

And `-B` already has a binary representation that makes ordinary fixed-width binary addition work.

Example:

```text
5 - 3
=
5 + (-3)
```

Represent with 4 bits:

```text
+5 = 0101

+3 = 0011

-3:
0011
↓ flip
1100
↓ +1
1101
```

Now:

```text
  0101
+ 1101
------
1 0010
```

Keep the lower 4 bits:

```text
0010
```

Which is:

```text
2
```

Therefore:

```text
5 - 3 = 2
```

The same binary addition machinery can handle it.

---

# 26. The Entire Idea in One Picture

```text
              N BITS
                │
                ▼
          2^N bit patterns
                │
                ▼
      arithmetic modulo 2^N
                │
                ▼
       numbers wrap around
                │
                ▼

To represent -x, ask:

"What value added to x
gets us back to 0?"

                │
                ▼

         x + ? = 2^N

                │
                ▼

           ? = 2^N - x

                │
                ▼

      2^N - x
          =
      (2^N - 1 - x) + 1

                │
                ▼

2^N - 1 = 111111...111

                │
                ▼

(2^N - 1) - x
    = flip every bit of x

                │
                ▼

           -x
            =
        flip(x) + 1
```

That is two's complement.

---

# 27. Don't Memorize the Trick — Remember the Reason

If you forget:

```text
flip bits + 1
```

reconstruct it from:

```text
N bits → modulo 2^N
```

Then ask:

```text
What should -x do?

x + (-x) = 0
```

In modular arithmetic:

```text
x + (2^N - x)
=
2^N
=
0 mod 2^N
```

Therefore:

```text
-x = 2^N - x
```

And:

```text
2^N - x
=
(2^N - 1 - x) + 1
=
flip(x) + 1
```

So the real chain is:

```text
Fixed number of bits
        ↓
Modular arithmetic
        ↓
Need additive inverse of x
        ↓
2^N - x
        ↓
Flip bits + 1
        ↓
Two's complement
```

---

# Quick Reference

### 8-bit unsigned

```text
Range: 0 → 255
```

### 8-bit signed two's complement

```text
Range: -128 → 127
```

### Create `-x`

```text
1. Write x in N bits
2. Flip all bits
3. Add 1
```

Equivalent mathematically:

```text
-x ≡ 2^N - x  (mod 2^N)
```

### Useful identities

```text
-x = ~x + 1

~x = -x - 1

n & -n
→ isolate rightmost set bit

n & (n - 1)
→ remove rightmost set bit
```

---

# Final Mental Model

> **Memory stores bits. Signed and unsigned are interpretations of those bits.**

> **With N bits, arithmetic naturally wraps modulo `2^N`.**

> **The representation of `-x` is the value that, when added to `x`, wraps back to zero.**

> **That value is `2^N - x`.**

> **And `2^N - x` can be calculated in binary by flipping all bits and adding 1.**

That's the real reason two's complement works.

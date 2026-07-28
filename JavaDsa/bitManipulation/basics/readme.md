# Bit Manipulation — Basics

This folder contains the fundamental bit-manipulation concepts and operations.

The goal is to understand **what happens to the bits**, rather than memorizing formulas.

---

# 1. Decimal to Binary

**File:** `DecimalToBinary.java`

To convert a decimal number to binary, repeatedly divide the number by `2`.

At every step:

```text
remainder = num % 2
num = num / 2
```

The remainder gives the current binary digit.

Example:

```text
num = 5

5 % 2 = 1
5 / 2 = 2

2 % 2 = 0
2 / 2 = 1

1 % 2 = 1
1 / 2 = 0
```

The digits are generated from **right to left (LSB → MSB)**:

```text
Collected: 101
Binary:    101
```

### Bitwise approach

Instead of `% 2`:

```text
num & 1
```

extracts the last bit.

Instead of `/ 2` for positive integers:

```text
num >> 1
```

moves all bits one position to the right.

### Intuition

```text
num & 1  → What is your last bit?

num >> 1 → Remove/move past that bit.
```

---

# 2. Binary to Decimal

**File:** `BinaryToDecimal.java`

Every position in binary represents a power of `2`.

Example:

```text
Binary:     1   0   1   1
Index:      3   2   1   0
Power:     2³  2²  2¹  2⁰
Value:      8   4   2   1
```

Therefore:

```text
1011

= 1×8 + 0×4 + 1×2 + 1×1
= 8 + 2 + 1
= 11
```

General idea:

```text
bit at index i contributes:

bit × 2^i
```

---

# 3. Check Whether the ith Bit Is Set

**File:** `SetOrNotIthbit.java`

A **set bit** means the bit is `1`.

Bit indexing normally starts from `0` from the right.

```text
Binary:      1 0 0 1
Index:       3 2 1 0
```

Therefore:

```text
i = 0 → 1st bit from right
i = 1 → 2nd bit from right
i = 2 → 3rd bit from right
i = 3 → 4th bit from right
```

So index `i` corresponds to the `(i + 1)th` bit when counting normally.

## Method 1 — Right Shift

Move the target bit to position `0`.

```java
((num >> i) & 1) == 1
```

Example:

```text
num = 9 = 1001
i = 3

1001 >> 3

0001
```

Now extract the last bit:

```text
0001
&
0001
----
0001
```

Result is `1`, so the bit is set.

### Intuition

```text
Bring the target bit to position 0
              ↓
          AND with 1
              ↓
         inspect the bit
```

---

## Method 2 — Left Shift / Mask

Instead of moving the number, move a `1` to the target position.

```java
(num & (1 << i)) != 0
```

Example:

```text
num = 9 = 1001
i = 3

1 << 3

0001 → 1000
```

Now:

```text
  1001
& 1000
------
  1000
```

The result is non-zero, therefore the bit is set.

### Mental Model

```text
Right shift:
Bring the BIT to the mask.

Left shift:
Bring the MASK to the bit.
```

---

# 4. Set the ith Bit

**File:** `SetIthBit.java`

Setting a bit means making the target bit `1`.

There are two possible situations:

```text
Target is 0 → make it 1

Target is 1 → keep it 1
```

Therefore:

```text
0 → 1
1 → 1
```

Which operator has this behavior?

**OR**

```text
0 | 1 = 1
1 | 1 = 1
```

First create a mask:

```java
1 << i
```

Then:

```java
num | (1 << i)
```

## Case 1 — Target Bit Is 0

Suppose:

```text
num = 9 = 1001
i = 2

index:  3 2 1 0
        1 0 0 1
          ↑
        target
```

Create the mask:

```text
1 << 2

0001
  ↓
0100
```

Now OR:

```text
  1001
| 0100
------
  1101
```

The target changed:

```text
0 → 1
```

So:

```text
1001 = 9

becomes

1101 = 13
```

---

## Case 2 — Target Bit Is Already 1

Suppose:

```text
num = 13 = 1101
i = 2

index:  3 2 1 0
        1 1 0 1
          ↑
        already 1
```

Mask:

```text
0100
```

OR:

```text
  1101
| 0100
------
  1101
```

Nothing changes because:

```text
1 | 1 = 1
```

Therefore:

```text
Target 0 → becomes 1
Target 1 → remains 1
```

Formula:

```java
num = num | (1 << i);
```

Short form:

```java
num |= (1 << i);
```

### Intuition

```text
Want target = 1
      ↓
Put 1 in mask at target
      ↓
OR
      ↓
0 | 1 = 1
1 | 1 = 1
      ↓
Target guaranteed to be 1
```

---

# 5. Toggle the ith Bit

**File:** `ToggleithBit.java`

Toggle means **flip the current value**:

```text
0 → 1
1 → 0
```

XOR has exactly this property:

```text
0 ^ 1 = 1
1 ^ 1 = 0
```

Create the mask:

```java
1 << i
```

Then:

```java
num ^ (1 << i)
```

Example:

```text
num = 9

1001

Toggle bit 0:

mask = 0001
```

XOR:

```text
  1001
^ 0001
------
  1000
```

The last bit changed:

```text
1 → 0
```

If it had been `0`:

```text
0 ^ 1 = 1
```

so it would become `1`.

### Intuition

```text
Want to FLIP something
        ↓
      XOR with 1

0 ^ 1 → 1
1 ^ 1 → 0
```

---

# 6. Remove the Last Set Bit

**File:** `RemoveLastSetBit.java`

One of the most important bit tricks is:

```java
n & (n - 1)
```

It removes the **rightmost set bit**.

Example:

```text
n = 12

12 = 1100
11 = 1011
```

AND:

```text
  1100
& 1011
------
  1000
```

The rightmost set bit disappeared:

```text
1100
  ↑
rightmost 1

↓

1000
```

## Why Does `n - 1` Do This?

Take:

```text
n = 1100
```

Subtract `1`:

```text
  1100
- 0001
------
  1011
```

When subtracting `1`:

* the rightmost `1` becomes `0`
* all `0`s after it become `1`

Therefore:

```text
n     = xxxx1000
n - 1 = xxxx0111
```

AND them:

```text
xxxx1000
xxxx0111
--------
xxxx0000
```

The rightmost set bit disappears.

### Intuition

Remember:

```text
n & (n - 1)

      ↓

REMOVE RIGHTMOST 1
```

This single trick is used in many bit-manipulation problems.

---

# 7. Check Whether a Number Is a Power of 2

**File:** `PowerOf2.java`

Look at powers of `2` in binary:

```text
1  = 000001
2  = 000010
4  = 000100
8  = 001000
16 = 010000
32 = 100000
```

Notice something important:

> Every positive power of `2` has exactly **ONE set bit**.

Now remember:

```text
n & (n - 1)
```

removes the rightmost set bit.

If there is only **one** set bit, removing it leaves `0`.

Example:

```text
n = 8

8 = 1000
7 = 0111
```

AND:

```text
  1000
& 0111
------
  0000
```

Therefore:

```java
(n & (n - 1)) == 0
```

But we also need:

```java
n > 0
```

because `0` is not a power of `2`.

Final check:

```java
n > 0 && (n & (n - 1)) == 0
```

### Example of a Non-Power of 2

Take `10`:

```text
10 = 1010
 9 = 1001
```

AND:

```text
  1010
& 1001
------
  1000
```

Not zero.

Therefore `10` is not a power of `2`.

### Intuition

```text
Power of 2
    ↓
Exactly ONE set bit
    ↓
n & (n - 1)
    ↓
removes that one bit
    ↓
0
```

---

# 8. Count Set Bits

**File:** `CountOfSetBits.java`

A **set bit** is simply a bit whose value is `1`.

Example:

```text
13 = 1101

Set bits = 3
```

## Method 1 — Check Every Bit

Extract the last bit:

```java
num & 1
```

If it's `1`, increment the count.

Then:

```java
num >>= 1;
```

to move the next bit into the rightmost position.

```java
int count = 0;

while (num > 0) {

    if ((num & 1) == 1) {
        count++;
    }

    num >>= 1;
}
```

Example:

```text
1101
   ↑ check

0110
   ↑ check

0011
   ↑ check

0001
   ↑ check

0000
```

---

## Method 2 — Brian Kernighan's Algorithm

We already know:

```text
n & (n - 1)
```

removes one set bit.

So simply keep removing set bits:

```java
int count = 0;

while (num > 0) {
    num = num & (num - 1);
    count++;
}
```

Example:

```text
num = 12

1100
 ↓
1000     count = 1
 ↓
0000     count = 2
```

Therefore:

```text
12 has 2 set bits
```

### Intuition

```text
Each iteration removes ONE set bit.

Number of iterations
        =
Number of set bits
```

---

# 9. Swap Two Numbers Using XOR

**File:** `SwapTwoNumbersUsingXor.java`

Important XOR properties:

```text
x ^ x = 0

x ^ 0 = x
```

XOR is also reversible.

We can swap two numbers using:

```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```

Suppose:

```text
a = 5
b = 7
```

First:

```text
a = 5 ^ 7
```

Now `a` contains information about both numbers.

Then:

```text
b = a ^ b

  = (5 ^ 7) ^ 7

  = 5 ^ (7 ^ 7)

  = 5 ^ 0

  = 5
```

So now:

```text
b = 5
```

Then:

```text
a = a ^ b

  = (5 ^ 7) ^ 5

  = (5 ^ 5) ^ 7

  = 0 ^ 7

  = 7
```

Finally:

```text
a = 7
b = 5
```

They are swapped.

In normal Java code, a temporary variable is usually clearer. This trick is mainly useful for understanding XOR.

---

# Core Bitwise Operators

```text
&    AND
|    OR
^    XOR
~    NOT
<<   Left Shift
>>   Signed Right Shift
>>>  Unsigned Right Shift
```

---

## AND `&`

Truth table:

```text
0 & 0 = 0
0 & 1 = 0
1 & 0 = 0
1 & 1 = 1
```

Think:

```text
AND → checking / extracting bits
```

---

## OR `|`

Truth table:

```text
0 | 0 = 0
0 | 1 = 1
1 | 0 = 1
1 | 1 = 1
```

Think:

```text
OR → setting bits
```

---

## XOR `^`

Truth table:

```text
0 ^ 0 = 0
0 ^ 1 = 1
1 ^ 0 = 1
1 ^ 1 = 0
```

Important:

```text
x ^ x = 0
x ^ 0 = x
```

Think:

```text
XOR → toggle / cancel
```

---

## NOT `~`

NOT flips every bit:

```text
0 → 1
1 → 0
```

For Java integers:

```text
~x = -(x + 1)
```

Example:

```text
~5 = -6
```

Remember:

**NOT does not directly make a number negative.**

To obtain `-x` using two's complement:

```text
-x = ~x + 1
```

Example:

```text
5

00000101

flip:
11111010

+1:
11111011

= -5
```

---

# Shift Operators

## Left Shift `<<`

```text
x << i
```

moves bits `i` positions to the left.

Example:

```text
5 = 0101

5 << 1

1010 = 10
```

For values where overflow does not occur:

```text
x << i ≈ x × 2^i
```

Example:

```text
5 << 2

5 × 4 = 20
```

---

## Signed Right Shift `>>`

Moves bits to the right.

```text
8 = 1000

8 >> 1

0100 = 4
```

For positive numbers:

```text
x >> i ≈ x / 2^i
```

For negative numbers, Java preserves the sign by filling the left side with `1`s.

---

## Unsigned Right Shift `>>>`

Also shifts bits right, but fills the left side with `0`s.

This matters mainly for negative numbers.

```text
>>  → preserves sign

>>> → fills with zeros
```

---

# Java int and Two's Complement

Java `int` uses **32 bits**.

Range:

```text
-2^31 to 2^31 - 1
```

Which is:

```text
-2147483648
to
 2147483647
```

---

## Integer.MAX_VALUE

```text
2147483647
```

Binary:

```text
01111111 11111111 11111111 11111111
```

There are:

```text
31 ones
```

The first bit is `0`, indicating a positive value.

---

## Integer.MIN_VALUE

```text
-2147483648
```

Binary:

```text
10000000 00000000 00000000 00000000
```

---

# Two's Complement

Java represents negative integers using two's complement.

To find the representation of `-x`:

```text
1. Start with x
2. Flip every bit
3. Add 1
```

Example:

```text
5

00000101
```

Flip:

```text
11111010
```

Add `1`:

```text
11111011
```

That bit pattern represents:

```text
-5
```

Important mental model:

The machine doesn't need to repeatedly "convert it back."

```text
111...1011
```

is itself the two's-complement representation of `-5`.

---

# Integer Overflow

Java `int` only has 32 bits.

If normal integer arithmetic produces a result outside the representable range, the stored bits wrap around.

Example:

```java
int x = Integer.MAX_VALUE;
x++;

System.out.println(x);
```

Result:

```text
-2147483648
```

At the bit level:

```text
01111111 11111111 11111111 11111111
                                      + 1
------------------------------------------------
10000000 00000000 00000000 00000000
```

That resulting pattern represents `Integer.MIN_VALUE`.

Normal Java integer arithmetic does **not** throw an exception just because overflow occurs.

---

# Important Bit Tricks

## Check ith Bit

```java
(num & (1 << i)) != 0
```

or:

```java
((num >> i) & 1) == 1
```

---

## Set ith Bit

```java
num | (1 << i)
```

```text
0 → 1
1 → 1
```

---

## Toggle ith Bit

```java
num ^ (1 << i)
```

```text
0 → 1
1 → 0
```

---

## Extract Last Bit

```java
num & 1
```

---

## Remove Rightmost Set Bit

```java
num & (num - 1)
```

---

## Check Power of 2

```java
n > 0 && (n & (n - 1)) == 0
```

---

## Count Set Bits

Repeatedly:

```java
n = n & (n - 1);
```

Each iteration removes one set bit.

---

## Negate Using Two's Complement

```java
~n + 1
```

---

# Final Mental Model

Don't memorize each operation as an unrelated formula.

Think about **what you want to happen to the target bit**.

```text
CHECK a bit
    ↓
AND


SET a bit
0 → 1
1 → 1
    ↓
OR


TOGGLE a bit
0 → 1
1 → 0
    ↓
XOR


FLIP every bit
    ↓
NOT


MOVE bits
    ↓
SHIFT
```

The most important mask is:

```text
1 << i
```

It creates:

```text
00001000
    ↑
only target position is 1
```

Then choose the operator depending on what you want:

```text
CHECK   → num & (1 << i)

SET     → num | (1 << i)

TOGGLE  → num ^ (1 << i)
```

And remember this extremely useful pattern:

```text
n & (n - 1)
```

means:

```text
REMOVE THE RIGHTMOST SET BIT
```

From that one idea, you can understand:

```text
Remove last set bit
        ↓
Count set bits
        ↓
Check power of 2
```

The core of bit manipulation is not memorizing tricks — it is learning to look at a binary number, build the right **mask**, and choose the operator that creates the bit transformation you want.

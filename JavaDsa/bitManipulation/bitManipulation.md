# Bit Manipulation

## Basic Operations

### Check ith Bit
```java
(num & (1 << i)) != 0
```

### Set ith Bit
```java
num |= (1 << i);
```

### Clear ith Bit
```java
num &= ~(1 << i);
```

### Toggle ith Bit
```java
num ^= (1 << i);
```

---

## Pattern Recognition

- While checking a bit, always use `!= 0`, never `== 1`.
- While building an answer, don't build binary strings. Set bits directly:
  ```java
  ans |= (1 << i);
  ```
- If only the first/last set bit is needed, don't loop over all 32 bits.
  ```java
  Integer.numberOfTrailingZeros(n);              // Rightmost set bit position
  31 - Integer.numberOfLeadingZeros(n);          // Leftmost set bit position
  ```
- Remove lowest set bit:
  ```java
  n = n & (n - 1);
  ```
- Isolate lowest set bit:
  ```java
  n & -n
  ```
- Set lowest unset bit:
  ```java
  n = n | (n + 1);
  ```

---

## XOR (0 to N)

| `n % 4` | XOR(0...n) |
|---------|------------|
| 0 | `n` |
| 1 | `1` |
| 2 | `n + 1` |
| 3 | `0` |

---

## Quick Reference

- Check bit → `num & mask`
- Set bit → `num | mask`
- Clear bit → `num & ~mask`
- Toggle bit → `num ^ mask`
- Remove lowest set bit → `n & (n - 1)`
- Isolate lowest set bit → `n & -n`
- Lowest set bit index → `Integer.numberOfTrailingZeros(n)`
- Highest set bit index → `31 - Integer.numberOfLeadingZeros(n)`
- Build answer → `ans |= (1 << i)`
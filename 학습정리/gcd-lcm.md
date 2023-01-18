# 최대공약수, 최소공배수

- 최대공약수(Greatest Common Divisor, GCD)
- 최소공배수(Least Common Multiple, LCM)

---

# 최대공약수(GCD)
```java
    public int gcd(int a, int b) {
        int max, min, r;

        if (a>=b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        r= max%min;

        if (r == 0) {
            return min;
        }
        return gcd(min, r);
    }
```
두 수 a, b (`a>=b`)의 최대공약수를 `GCD(a,b)` 라고 할 때  
a%b = r 에 대하여
- `r == 0` 이면, `GCD(a,b)` = b
- `r != 0` 이면, `GCD(a,b)` = `GCD(b, r)`

---

# 최소공배수(LCM)
```java
    public int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
```
두 수 a, b의 최대 공약수를 `GCD(a,b)`, 최소공배수를 `LCM(a,b)` 라고 할 때  
`LCM(a,b)` = a * b / `GCD(a,b)`

---

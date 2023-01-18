# Programmers 120830 : 양꼬치
- 난이도 : Level 0
- 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는가
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120830)

---

## 풀이
```java
public class Solution {

    private static final int LAMB_PRICE = 12000;
    private static final int DRINK_PRICE = 2000;
    public int solution(int n, int k) {
        return calculateLambPrice(n) + calculateDrinkPrice(k) - calculateDiscountPrice(n);
    }

    private static int calculateLambPrice(int n) {
        return n * LAMB_PRICE;
    }

    private static int calculateDrinkPrice(int k) {
        return k * DRINK_PRICE;
    }

    private int calculateDiscountPrice(int n) {
        return (n/10) * DRINK_PRICE;
    }
}
```
- 양꼬치 가격과 음료 가격을 합산하고, 할인 가격을 차감한다.

---

# Programmers 120819 : 아이스 아메리카노
- 난이도 : Level 0
- 가지고 있는 돈 money가 매개변수로 주어질 때, 머쓱이가 최대로 마실 수 있는
아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120819)

---

## 풀이
```java
public class Solution {

    private static final int PRICE = 5500;

    public int[] solution(int money) {
        int count = money/PRICE;
        int change = money%PRICE;
        return new int[]{count, change};
    }
}
```
- count : 구입 가능한 최대 아이스 아메리카노의 수
- change : 남는 돈

---

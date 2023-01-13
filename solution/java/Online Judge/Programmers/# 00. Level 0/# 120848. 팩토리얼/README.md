# 문제
- 번호 : 120848
- 제목 : 팩토리얼
- 난이도 : Level 0
- 정수 n이 주어질 때 `i! <= n`을 만족하는 가장 큰 정수 i 구하기
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120848)

---

# 필요 알고리즘
- 반복문

---

# 풀이
```java
public class Solution {

    public int solution(int n) {
        int number = 1;
        int factorial = 1;

        while (factorial <= n) {
            number++;
            factorial *= number;
        }
        return number-1;
    }

}
```
- 조건을 만족시키면 number를 1 증가시켜서 다음 팩토리얼 값을 비교한다.
- while문 조건을 만족시키지 못 하면 탈출하고, number를 1 감소시켜 반환한다.

---

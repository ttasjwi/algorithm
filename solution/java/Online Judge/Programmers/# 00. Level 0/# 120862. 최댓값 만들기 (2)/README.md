# 문제
- 번호 : 120862
- 제목 : 최댓값 만들기 (2)
- 난이도 : Level 0
- numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120862)

---

# 필요 알고리즘
- 정렬

---

# 풀이
```java
import java.util.Arrays;

public class Solution {

    public int solution(int[] numbers) {
        Arrays.sort(numbers);

        int product1 = numbers[0] * numbers[1];
        int product2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

        return Math.max(product1, product2);
    }

}
```
- 배열을 정렬한다.
- 양 끝의 두 값의 곱들을 서로 비교하고 큰 값을 반환한다.

---

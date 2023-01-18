# 문제
- 번호 : 120847
- 제목 : 최댓값 만들기(1)
- 난이도 : Level 0
- numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120847)

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
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }
}
```
- 정렬하여, 제일 큰 수와 두번째로 큰 수를 곱하면 된다.

---

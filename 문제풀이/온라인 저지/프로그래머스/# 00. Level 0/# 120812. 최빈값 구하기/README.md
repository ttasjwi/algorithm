# Programmers 120812 : 최빈값 구하기
- 난이도 : Level 0
- 주어진 값들 중 가장 자주 나오는 값 구하기
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120812)

---

## 풀이
```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(int[] array) {
        Map<Integer, Integer> counter = counting(array);
        return getAnswer(counter);
    }

    private static Map<Integer, Integer> counting(int[] array) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int number : array) {
            counter.put(number, counter.getOrDefault(number, 0)+ 1);
        }
        return counter;
    }

    private static int getAnswer(Map<Integer, Integer> counter) {
        int answer = -1;
        int maxCount = -1;

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                answer = number;
            } else if (count == maxCount) {
                answer = -1;
            }
        }
        return answer;
    }
}
```
- Map으로 숫자들과, 그 숫자들의 등장 횟수를 카운팅한다.
- 카운터를 순회하면서, 중복해서 등장한 횟수가 나올 경우 answer를 -1로 갱신한다.
- -1로 갱신되지 않을 경우 그 숫자가 최빈값이다.

---

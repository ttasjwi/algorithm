# 문제
- 번호 : 120852
- 제목 : 소인수분해
- 난이도 : Level 0
- 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120852)

---

# 필요 알고리즘
- 에라토스테네스의 체

---

# 풀이
```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int n) {
        boolean[] isCompositeNumber = new boolean[n+1];
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i<= n; i++) {
            if (!isCompositeNumber[i]) {
                if (n%i == 0) {
                    primeNumbers.add(i);
                }
                for (int j = 2*i; j<= n; j+=i) {
                    if (!isCompositeNumber[j]) {
                        isCompositeNumber[j] = true;
                    }
                }
            }
        }

        return primeNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
```
- 에라토스테네스의 체를 사용하여 합성수 필터링
- 소수들을 순서대로 ArrayList에 삽입
- 최종적으로 ArrayList를 배열로 변환하여 반환

---

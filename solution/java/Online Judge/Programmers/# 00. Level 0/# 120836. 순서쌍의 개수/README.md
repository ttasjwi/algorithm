# Programmers 120836 : 순서쌍의 개수
- 난이도 : Level 0
- 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120836)

---

## 풀이
```java
public class Solution {

    public int solution(int n) {
        int answer = 0;

        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i == 0)  {
                if (n/i == i) {
                    answer += 1;
                } else {
                    answer += 2;
                }
            }
        }
        return answer;
    }
}
```
- 곱의 순서쌍을 구하는 문제인데, 거듭제곱근까지 순서대로 판별하면 된다.

---

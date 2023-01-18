# Programmers 012928 : 약수의 합

- 난이도 : Level 1
- n의 약수를 모두 더한 값을 리턴
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12928)

---

## 풀이
```java
public class Solution {

    public int solution(int n) {
        int answer = 0;
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                answer += i;
                if (i != n/i) {
                    answer += n/i;
                }
            }
        }
        return answer;
    }
}
```
- 1부터 n의 제곱근 이하까지 순회하면서 판별하면 된다.
- 나눴을 때 나누어 떨어지면, 몫 역시 약수가 된다.
- 이 때, 나눈 수와 몫이 같은 경우에는 중복되므로 몫을 더해선 안 된다.

---

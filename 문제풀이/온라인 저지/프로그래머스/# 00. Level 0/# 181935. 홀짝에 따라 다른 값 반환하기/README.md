# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181935
- 제목 : 홀짝에 따라 다른 값 반환하기
- 난이도 : Level 0
- 양의 정수 n이 매개변수로 주어질 때, n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고 n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181935" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```java
class Solution {
    public int solution(int n) {
        return (n % 2 == 1)
                ? (n + 1) / 2 * ((n + 1) / 2)
                : n * (n + 1) * (n + 2) / 6;
    }
}
```
- 등차수열의 합 공식 이
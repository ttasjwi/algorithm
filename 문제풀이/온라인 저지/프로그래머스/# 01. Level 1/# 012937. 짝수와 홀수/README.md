# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012937
- 제목 : 짝수와 홀수
- 난이도 : Level 1
- n의 약수를 모두 더한 값을 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12937" target="_blank">링크</a>

---

# 필요 지식
- 조건문

---

# 풀이
```python
def solution(num):
    return 'Odd' if (num % 2) else 'Even'
```
```java
class Solution {
    public String solution(int num) {
        return (num%2 ==0)
                ? "Even"
                : "Odd";
    }
}
```

---

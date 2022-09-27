# Programmers 12937 : 짝수와 홀수

- 난이도 : Level 1
- 짝수인지 홀수인지 판별하여 문자열 반환
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12937)

---

## 풀이
```python
def solution(num):
    return 'Even' if num % 2 == 0 else 'Odd'

```
- num을 2로 나눈 나머지가 0이면 짝수이므로 'Even', 아니면 홀수이므로 'Odd'

---

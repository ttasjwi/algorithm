# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.04
- 제목 : 피보나치 수열
- 피보나키 수열을 출력한다. (피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.)

---

# 필요 지식
- 리스트 처리
- 다이나믹 프로그래밍

---

# 풀이
```python
n = int(input())

answer = []
for i in range(n):
    if i == 0 or i == 1:
        answer.append(1)
    else:
        answer.append(answer[i-2] + answer[i-1])
print(*answer, end = '', sep=' ')
```
- 순서대로 리스트 구성

---

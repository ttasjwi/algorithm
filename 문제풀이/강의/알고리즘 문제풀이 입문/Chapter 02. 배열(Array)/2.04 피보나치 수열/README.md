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
result = [1, 1]

for i in range(2, n):
    result.append(result[i-1] + result[i-2])
print(' '.join(map(str, result)), end='')
```
- 순서대로 리스트 구성

---

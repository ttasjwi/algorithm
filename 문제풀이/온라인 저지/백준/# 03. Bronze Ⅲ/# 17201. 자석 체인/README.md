# 문제
- 플랫폼 : 백준
- 번호 : 17201
- 제목 : 자석 체인
- 난이도 : Bronze 3
- 문제 : <a href="https://www.acmicpc.net/problem/17201" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
input()
arr = list(input())
for i in range(1, len(arr)):
    if arr[i] == arr[i - 1]:
        print('No')
        exit(0)
print('Yes', end='')
```
- 글자를 쭉 읽으면서 이전 값이랑 달라지는 값이 발견되면 No 를, 발견된 것이 없으면 Yes 를 출력한다.

---

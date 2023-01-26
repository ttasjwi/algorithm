# 문제
- 플랫폼 : 백준
- 번호 : 02445
- 제목 : 별 찍기 - 8
- 난이도 : Bronze 3
- 주어진 예제를 보고 유추하여 별 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/2445" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = ['*' * i + ' ' * 2 * (n-i) + '*'*i for i in range(1, n+1)]
answer += answer[-2::-1]
answer = '\n'.join(answer)
print(answer, end='')
```
- n번째 라인까지 반복후, n-1번 라인부터 역으로 반복된다.
- 리스트 슬라이싱을 이용해 역순으로 덧붙인다.

---

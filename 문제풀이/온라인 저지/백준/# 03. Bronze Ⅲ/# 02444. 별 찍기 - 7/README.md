# 문제
- 플랫폼 : 백준
- 번호 : 02444
- 제목 : 별 찍기 - 7
- 난이도 : Bronze 3
- 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/2444" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n = int(input())
answer = [(n-i) * ' ' + (2 * i - 1) * '*' for i in range(1, n+1)]
answer += answer[-2::-1]
print('\n'.join(answer))
```
- 대칭라인까지의 별을 순서대로 찍는다.
- 리스트 슬라이싱을 이용해서 대칭점 이전 라인부터 역순의 라인들을 추가한다.
- 순서대로 출력한다.

---

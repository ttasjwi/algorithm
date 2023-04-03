# 문제
- 플랫폼 : 백준
- 번호 : 14652
- 제목 : 나는 행복합니다~
- 난이도 : Bronze 5
- 욱제의 잃어버린 자리를 찾아서, 잃어버린 자리의 좌표 (n, m)를 하나의 공백을 사이에 두고 숫자만 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14652" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
_, M, k = map(int, input().split())

n, m = divmod(k, M)
print(n, m)
```
- k를 M으로 나눈 몫이 행 번호이고, 나머지가 열 번호이다.

---


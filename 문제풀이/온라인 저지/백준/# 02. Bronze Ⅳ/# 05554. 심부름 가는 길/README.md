# 문제
- 플랫폼 : 백준
- 번호 : 05554
- 제목 : 심부름 가는 길
- 난이도 : Bronze 4
- 총 이동시간 x 분 y 초를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5554" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
total = sum([int(input()) for _ in range(4)])
x, y = total//60, total%60
print(x, y, sep='\n')
```
- 시간들의 합을 구하고 60 으로 나눈 몫, 나머지를 순서대로 출력하면 된다.

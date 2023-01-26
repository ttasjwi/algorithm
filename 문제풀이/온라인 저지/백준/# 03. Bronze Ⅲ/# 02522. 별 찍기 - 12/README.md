# 문제
- 플랫폼 : 백준
- 번호 : 02522
- 제목 : 별 찍기 - 12
- 난이도 : Bronze 3
- 주어진 예제를 보고 유추하여 별 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/2522" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = [' ' * (n - i) + '*' * i for i in range(1, n + 1)]
answer += answer[-2::-1]
answer = '\n'.join(answer)
print(answer, end='')
```
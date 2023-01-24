# 문제
- 플랫폼 : 백준
- 번호 : 03003
- 제목 : 킹, 퀸, 룩, 비숍, 나이트, 폰
- 난이도 : Bronze 5
- 발견한 흰색 피스의 개수가 주어졌을 때, 몇 개를 더하거나 빼야 올바른 세트가 되는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/3003" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
right_pieces = [1, 1, 2, 2, 2, 8]  # 킹, 퀸, 룩, 비숍, 나이트, 폰
my_pieces = map(int, input().split())
answer = ' '.join(str(a-b) for a, b in zip(right_pieces, my_pieces))

print(answer, end='')
```

---

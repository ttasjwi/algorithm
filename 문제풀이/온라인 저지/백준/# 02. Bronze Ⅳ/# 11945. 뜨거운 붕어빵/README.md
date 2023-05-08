# 문제
- 플랫폼 : 백준
- 번호 : 11945
- 제목 : 뜨거운 붕어빵
- 난이도 : Bronze 4
- 붕어빵이 좌우로 뒤집힌 모양을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11945" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n, _ = map(int, input().split())
print('\n'.join([''.join(list(input())[::-1]) for _ in range(n)]))
```
- 리스트 슬라이싱을 이용해 좌우 반전시키고 join으로 다시 결합한다. 그 후 이들을 join으로 개행단위로 결합한다.

---

# 문제
- 플랫폼 : 백준
- 번호 : 11943
- 제목 : 파일 옮기기
- 난이도 : Bronze 4
- 사과와 오렌지를 옮기는 최소 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11943" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
a, b = map(int, input().split())
c, d = map(int, input().split())

print(min(b + c, a + d))
```
- 첫번째를 사과 바구니로 할 경우, 오렌지 바구니로 할 경우 양쪽의 케이스를 분류한다.
- 둘 중 최솟값이 최소한으로 옮기는 횟수이다.

---

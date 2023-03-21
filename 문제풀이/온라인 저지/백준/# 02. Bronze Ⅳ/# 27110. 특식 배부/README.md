# 문제
- 플랫폼 : 백준
- 번호 : 27110
- 제목 : 특식 배부
- 난이도 : Bronze 4
- 본인이 가장 선호하는 종류의 치킨을 받을 수 있는 최대 인원수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/27110" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n = int(input())
a, b, c = map(int, input().split())
print(min(a, n) + min(n, b) + min(n, c))
```
- 선호하는 종류의 치킨을 받을 수 있는 인원을 최대로 하려면, 선호하는 치킨을 우선적으로 배포하며 된다.
- 그러나 치킨의 갯수는 한정되어 있기 때문에, 결국 n과 각 선호량 중 작은 값만큼까지만 배부할 수 있다.

---

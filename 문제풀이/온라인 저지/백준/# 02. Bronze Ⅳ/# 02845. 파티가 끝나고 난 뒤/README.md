# 문제
- 플랫폼 : 백준
- 번호 : 02845
- 제목 : 파티가 끝나고 난 뒤
- 난이도 : Bronze 4
- 상근이가 계산한 참가자의 수와  각 기사에 적혀있는 참가자의 수의 차이들을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2845" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
l, p = map(int, input().split())
total = l * p
answer = ' '.join(str(number - total) for number in map(int, input().split()))
print(answer, end = '')
```
- 상근이는 1m^2당 사람의 수를 알고 있으므로, 전체 면적을 통해 전체 사람 수를 구할 수 있다.
- 신문에서 보도된 참석자 수에서 전체 사람 수를 뺀 것들을 출력하면 된다.

---

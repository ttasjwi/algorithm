# 문제
- 플랫폼 : 백준
- 번호 : 20492
- 제목 : 세금
- 난이도 : Bronze 5
- 두 가지 상금 수령 방법에 따른 수령금을 각각 출력
  - 전체 상금의 22%를 제세공과금으로 납부하는 경우
  - 상금의 80%를 필요 경비로 인정받고, 나머지 금액 중 22%만을 제세공과금으로 납부하는 경우
- 문제 : <a href="https://www.acmicpc.net/problem/20492" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
n = int(input())
answer = ' '.join([str(n * 78 // 100), str(n * 956//1000)])
print(answer, end='')

```

---

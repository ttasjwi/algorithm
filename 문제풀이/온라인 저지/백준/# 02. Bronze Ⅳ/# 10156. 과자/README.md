# 문제
- 플랫폼 : 백준
- 번호 : 10156
- 제목 : 과자
- 난이도 : Bronze 4
- 동수가 부모님께 받아야 하는 돈의 액수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10156" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
k, n, m = map(int, input().split())
print(k * n - m if k * n > m else 0)
```
- 사려는 금액이 가진 돈보다 크면 돈을 빌리면 되지만, 그렇지 않을 경우에는 단 한푼의 금액도 빌릴 필요가 없다.

---

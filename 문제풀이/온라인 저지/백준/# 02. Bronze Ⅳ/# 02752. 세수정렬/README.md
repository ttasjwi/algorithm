# 문제
- 플랫폼 : 백준
- 번호 : 02752
- 제목 : 세수정렬
- 난이도 : Bronze 4
- 숫자 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2752" target="_blank">링크</a>

---

# 필요 알고리즘
- 파이썬 정렬 방법

---

# 풀이
```python
answer = ' '.join(sorted(input().split(), key=lambda x: int(x)))
print(answer, end='')
```

---

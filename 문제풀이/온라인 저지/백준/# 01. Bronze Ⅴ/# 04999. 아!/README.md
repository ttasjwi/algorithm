# 문제
- 플랫폼 : 백준
- 번호 : 04999
- 제목 : 아!
- 난이도 : Bronze 5
- 재환이가 낼 수 있는 "aah"의 길이와 의사가 요구하는 길이가 주어질 때, 그 병원에 가야하는지 말아야하는 지를 알아내는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/4999" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
answer = 'go' if len(input()) >= len(input()) else 'no'
print(answer, end='')
```
- 의사가 말한 ah보다 재환이가 말한 ah의 길이가 같거나 큰 지 여부를 판단한다.

---

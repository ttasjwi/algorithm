# 문제
- 플랫폼 : 백준
- 번호 : 10807
- 제목 : 개수 세기
- 난이도 : Bronze 5
- 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/10807" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
_ = input()
numbers = list(map(int, input().split()))
v = int(input())

answer = numbers.count(v)
print(answer, end='')
```
- 리스트의 count 메서드를 통해 지정 요소의 갯수를 구할 수 있음

---

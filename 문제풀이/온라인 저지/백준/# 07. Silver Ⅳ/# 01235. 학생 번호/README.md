# 문제
- 플랫폼 : 백준
- 번호 : 01235
- 제목 : 학생 번호
- 난이도 : Silver 4
- 모든 학생들의 학생 번호를 서로 다르게 만들 수 있는 최소의 k를 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1235" target="_blank">링크</a>

---

# 필요 지식
- 문자열
- set

---

# 풀이
```python
n = int(input())
nums = [input() for _ in range(n)]

for k in range(1, 101):
    s = set([num[:-1 - k:-1] for num in nums])
    if len(s) == n:
        print(k)
        exit(0)
```
- 자리수는 1자리부터 100자리까지 가능하므로 1, 100까지 반복한다.
- 1자리, 2자리, ... 순으로 각 경우마다 set을 생성한다.
- set의 크기가 같아지는 시점이 오면 그 시점의 k를 출력하고 프로그램을 종료한다.

---

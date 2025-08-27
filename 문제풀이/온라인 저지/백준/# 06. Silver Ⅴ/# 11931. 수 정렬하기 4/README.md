# 문제
- 플랫폼 : 백준
- 번호 : 11931
- 제목 : 수 정렬하기 4
- 난이도 : Silver 5
- 문제 : <a href="https://www.acmicpc.net/problem/11931" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```python
import sys

print = sys.stdout.write
input = sys.stdin.readline

n = int(input())
print('\n'.join(list(map(str, sorted([int(input()) for i in range(n)], reverse=True)))))
```
- 입력한거 그대로 역순으로 정렬해서 출력하면 됨

# BOJ 20492 : 세금
- 난이도 : Bronze 5
- 단순 사칙 연산
- 문제 : [링크](https://www.acmicpc.net/problem/20492)

---  

## 풀이
```python
import sys
n = int(sys.stdin.readline().rstrip())
answer1, answer2 = int(n * 0.78), int(n * 0.956)
print(answer1, answer2, sep=' ', end='')

```
- 입력, 계산, 출력

---

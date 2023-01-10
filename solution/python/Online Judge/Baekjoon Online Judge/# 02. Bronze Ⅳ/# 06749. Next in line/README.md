# BOJ 06749 : Next in line
- 난이도 : Bronze 4
- 세 사람의 나이차가 균등하고, 제일 어린 사람, 중간 어린 사람의 나이가 주어질 때 가장 나이 많은 사람의 나이 구하기
- 문제 : [링크](https://www.acmicpc.net/problem/6749)

---  

## 풀이
```python
import sys

input = lambda: sys.stdin.readline().rstrip()
y = int(input())
m = int(input())
answer = 2 * m - y
print(answer, end='')

```
- 둘째의 나이에서 막내의 나이를 뱀
- 그리고 둘째의 나이에 그 값을 더하면 첫째의 나이가 됨

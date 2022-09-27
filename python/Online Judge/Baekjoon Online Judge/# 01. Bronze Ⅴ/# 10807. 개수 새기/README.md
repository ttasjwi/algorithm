# BOJ 10807 : 개수 세기
- 난이도 : Bronze 5
- 개수 세기
- 문제 : [링크](https://www.acmicpc.net/problem/10807)

---  

## 풀이
```python
import sys

_, *numbers, v = map(int, sys.stdin.buffer.read().split())
answer = 0
for number in numbers:
    if number == v:
        answer += 1
print(answer, end='')

```
- 리스트에 숫자를 순서대로 저장하고, 각 인덱스마다 접근하여, 값이 일치하면 카운팅
- 카운트 출력

---

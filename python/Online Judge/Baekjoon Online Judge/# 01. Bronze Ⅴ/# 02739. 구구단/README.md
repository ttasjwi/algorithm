# BOJ 02739 : 구구단
- 난이도 : Bronze 5
- 반복문으로 구구단 출력
- 문제 : [링크](https://www.acmicpc.net/problem/2739)

---  

## 풀이
```python
n = int(input())
results = [f'{n} * {i} = {n * i}'
           for i in range(1, 10)
           ]
print(*results, sep='\n', end='')

```
- 리스트 컴프리헨션으로 결과물을 초기화
- 문자열을 모아서 출력

---

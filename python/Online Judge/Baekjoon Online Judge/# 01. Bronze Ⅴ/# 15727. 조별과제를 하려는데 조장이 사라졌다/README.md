# BOJ 15727 : 조별과제를 하려는데 조장이 사라졌다
- 난이도 : Bronze 5
- 속력, 거리가 주어졌을 때 소요 시간을 소숫점 첫째자리에서 올림
- 문제 : [링크](https://www.acmicpc.net/problem/15727)

---  

## 풀이
```python
l = int(input())

answer = (l // 5) if l % 5 == 0 else (l // 5 + 1)
print(answer, end='')

```
- 5로 나눈 나머지가 0인지의 여부에 따라 case 분류하면 된다.

---

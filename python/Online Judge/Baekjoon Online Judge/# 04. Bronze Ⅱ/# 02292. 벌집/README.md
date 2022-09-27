# BOJ 02292 : 벌집
- 난이도 : Bronze 2
- 목적하는 방까지 가는데 거치는 방의 개수
- 문제 : [링크](https://www.acmicpc.net/problem/2355)

---  

## 풀이
```python
n = int(input())

level = 1
level_end = 1
while n > level_end:
    level_end += 6 * level
    level += 1
print(level, end='')

```
- 거쳐야하는 방의 최소 갯수 그룹을 level로 구분하자.
- level 1 : 1
- level 2 : 2,3, ... 7 (+6)
- level 3 : 8,9, ... 19(+12)
- level 4 : 20, 21, ... , 37(+18)
- 레벨이 증가할 때마다, 마지막 방번호가 6의 배수만큼 증가하는 규칙성을 확인할 수 있다.
- 이 규칙에 맞게 n의 범위를 매 순간 확인하다보면 거쳐야하는 최소의 방의 갯수를 찾아낼 수 있다.

---

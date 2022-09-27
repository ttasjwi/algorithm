# BOJ 03003 : 킹, 퀸, 룩, 비숍, 나이트, 폰

- 난이도 : Bronze 5
- 피스의 갯수를 비교하여 얼마만큼 더해야하는지 빼야하는 지 반환하기
- 문제 : [링크](https://www.acmicpc.net/problem/3003)

---  

## 풀이
```python
right_pieces = 1, 1, 2, 2, 2, 8  # 킹, 퀸, 룩, 비숍, 나이트, 폰
my_pieces = list(map(int, input().split()))
result = [right_pieces[i] - my_pieces[i]
          for i in range(len(right_pieces))
          ]

print(' '.join(map(str, result)), end='')

```
- 리스트 컴프리헨션을 이용해서 리스트의 요소를 초기화했다.
- 결과물을 join 함수를 통해서 결합 후 순서대로 출력

---

# BOJ 10951 : A+B - 4
- 난이도 : Bronze 5
- 반복적으로 두 수 합 구해 출력
- 문제 : [링크](https://www.acmicpc.net/problem/10951)

---  

## 풀이
```python
import sys

for line in sys.stdin:
    print(sum(map(int, line.split())))

```
- 숫자들을 여러 라인에 걸쳐 입력받아 출력


---

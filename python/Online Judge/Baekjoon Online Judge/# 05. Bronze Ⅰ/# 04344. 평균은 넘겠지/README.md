# BOJ 04344 : 평균은 넘겠지
- 난이도 : Bronze 1
- 평균을 넘는 비율을 형식화해서 출력 
- 문제 : [링크](https://www.acmicpc.net/problem/4344)

---  

## 풀이
```python
import sys

_ = input()
for line in sys.stdin:
    total_count, *scores = map(int, line.split())
    avg = sum(scores) / total_count
    count = 0
    for score in scores:
        if score > avg:
            count += 1
    rate = count / total_count * 100
    print(f'{rate:.3f}%')

```
- 라인 단위로 입력받아서, 평균을 넘으면 카운팅
- 비율을 구하고 형식화

---

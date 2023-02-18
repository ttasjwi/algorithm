# 문제
- 플랫폼 : 백준
- 번호 : 18870
- 제목 : 좌표 압축
- 난이도 : Silver 2
- X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/18870" target="_blank">링크</a>

---

# 필요 알고리즘
- 정렬

---

# 풀이
```python
import sys

input = sys.stdin.readline

n = int(input())
nums = [*map(int, input().split())]
ranks = {num: idx for idx, num in enumerate(sorted(set(nums)))}
answer = ' '.join(str(ranks[num]) for num in nums)
print(answer)
```
- 숫자들을 순서대로 배열에 저장
- 배열을 기반으로 한 set을 정렬된 리스트로 만들어, 이를 기반으로 등수 딕셔너리를 만든다.
- nums배열의 요소를 순서대로 순회하면서 ranks에 있는 rank값을 순서대로 출력한다.

---

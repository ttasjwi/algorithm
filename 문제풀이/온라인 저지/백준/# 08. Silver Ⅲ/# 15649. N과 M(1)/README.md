# 문제
- 플랫폼 : 백준
- 번호 : 15649
- 제목 : N과 M(1)
- 난이도 : Silver 3
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열들을 사전식으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15649" target="_blank">링크</a>

---

# 필요 알고리즘
- 백트래킹
- 파이썬 permutations 함수

---

# 풀이
## 풀이1
```python
import sys

print = sys.stdout.write

n, m = map(int, input().split())
nums = [-1] * m
check = [False] * (n + 1)


def dfs(idx):
    if idx == m:
        print(' '.join(map(str, nums)))
        print('\n')
        return
    for num in range(1, n + 1):
        if not check[num]:
            check[num] = True
            nums[idx] = num
            dfs(idx + 1)
            check[num] = False


dfs(0)
```
- dfs를 통해 백트래킹을 구현했다.
- 함수의 idx는 말 그대로 nums의 인덱스이다. 해당 인덱스에 삽입할 값을 결정하고, 다음 인덱스의 값을 결정하기 위해 dfs를 재귀적으로 호출한다.
- 이미 사용된 값은 다시 사용하지 않도록 체크처리하고, 다음 반복에서는 사용할 수 있도록 체크처리를 해제한다.
- idx가 m과 같아지면 배열의 마지막 인덱스까지 모두 채운 상태이므로 그대로 출력한다.

## 풀이2
```python
import sys
from itertools import permutations

print = sys.stdout.write

n, m = map(int, input().split())
print('\n'.join(list(map(' '.join, permutations(map(str, range(1, n + 1)), m)))))
```
- 문제 상황은 서로 다른 n개의 요소 중 m개를 선택해 일렬로 세우는 상황이며, 이는 수학의 '순열'이다.
- python에는 itertools.permutations 라는 무시무시한 함수가 있고, 이를 사용하면 1234, 1243, ... 이 순서대로 순열을 만들어준다.

---

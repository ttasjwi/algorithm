# 문제
- 플랫폼 : 프로그래머스
- 번호 : 001845
- 제목 : 폰켓몬
- 난이도 : Level 1
- N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1845 target="_blank">링크</a>

---

# 필요 지식
- set
- counter

---

# 풀이

## 풀이1 : 내 삽질
```python
from collections import Counter


def solution(nums):
    count = 0

    for key, value in Counter(nums).items():
        if value > 0:
            count += 1

        if count == len(nums)//2:
            return count

    return count
```
- 카운터로 카운트를 수집 후 value가 0보다 큰 것들을 카운팅
- 만약 도중에 카운트가 배열 길이의 절반과 같으면 그대로 count 반환

## 풀이2
```python
def solution(nums):
    return min(len(nums)//2, len(set(nums)))
```
- 생각해보면 단순히 nums의 set 원소 수와, `len(nums)//2` 중 작은 것을 반환하면 된다.

---

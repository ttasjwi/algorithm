# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.01
- 제목 : 큰 수 출력하기
- 자신의 바로 앞 수보다 큰 수만 한 줄로 출력

---

# 필요 지식
- 리스트 처리

---

# 풀이
```python
n = int(input())
nums = [int(x) for x in input().split()]
answer = []
for i, num in enumerate(nums):
    if i == 0 or nums[i - 1] < nums[i]:
        answer.append(str(num))
print(' '.join(answer), end = '')
```
- 이전 인덱스와 비교하면서 더 크면 append

---

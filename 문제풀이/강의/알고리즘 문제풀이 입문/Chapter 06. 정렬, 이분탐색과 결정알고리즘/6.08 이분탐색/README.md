# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 6.8
- 제목 : 이분탐색
- 정렬 후, 몇 번째 위치에 해당 숫자가 있는 지 탐색하기

---

## 풀이
```python
n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))

lt = 0
rt = len(nums) - 1
mid = -1
while lt <= rt:
    mid = (lt + rt) >> 1
    if nums[mid] < m:
        lt = mid + 1
    elif nums[mid] > m:
        rt = mid - 1
    else:
        break
answer = mid + 1
print(answer, end = '')
```
- 이분탐색을 하기 위해서 정렬
- lt : 탐색 시작
- rt : 탐색의 끝
- mid : lt, rt의 평균값(가운데값). 찾고자하는 값으로 추정하는 값
- while문 돌림(lt가 rt보다 커질 때까지)
  - mid를 lt, rt의 평균값으로 갱신한다
  - 숫자의 mid 인덱스에 위치한 값이 m과 같으면 break한다.
  - 숫자의 mid 인덱스에 위치한 값이 m보다 작으면 lt를 mid + 1로 하여 더 뒷범위에서 탐색한다.
  - 숫자의 mid 인덱스에 위치한 값이 m보다 크면 rt를 mid-1로 하여 더 앞 범위에서 탐색한다.

---

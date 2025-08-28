# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.02
- 제목 : 보이는 학생
- 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

---

# 필요 지식
- 리스트 처리

---

## 풀이

## 풀이1: 이전 최댓값을 변수에 기록하면서 for문 쓰는 방식
```python
input()
nums = list(map(int, input().split()))
cnt = 1
before = nums[0]
for i in range(1, len(nums)):
    if before < nums[i]:
        cnt += 1
        before = nums[i]
print(cnt, end='')
```
- 값을 1번 인덱스부터 순서대로 비교하고, 이전 최댓값보다 클 때 cnt를 증가시키고 최댓값을 갱신한다.

## 풀이2: 투 포인터
```python
n = int(input())
nums = list(map(int, input().split()))
answer = 1
lt = 0
rt = 1

while rt < len(nums):
    if nums[lt] < nums[rt]:
        lt = rt
        rt = lt + 1
        answer += 1
    else:
        rt += 1
print(answer)
```
- 전체적인 흐름은 1과 같은데 while 문을 통해 처리하는 차이가 있음


### 참고
```python
input()
nums = list(map(int, input().split()))
answer = len([idx for idx, num in enumerate(nums) if idx == 0 or num > max(nums[:idx])])
print(answer, end='')
```
- 이렇게 하면 시간초과가 난다. 매번 앞의 최댓값을 계속 구해야하기 때문이다.
번거롭더라도 for문으로 매번 이전 최댓값을 갱신시켜가면서 효율을 최대화 시키자.

---

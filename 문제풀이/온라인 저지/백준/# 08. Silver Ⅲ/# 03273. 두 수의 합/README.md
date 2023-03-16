# 문제
- 플랫폼 : 백준
- 번호 : 03273
- 제목 : 두 수의 합
- 난이도 : Silver 3
- 자연수 x가 주어질 때 두 수의 합이 x가 되는 숫자 쌍의 갯수 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/3273" target="_blank">링크</a>

---

# 필요 알고리즘
- 투포인터
- 정렬
- 해시
- ...

---

# 풀이
```python
input()
arr = list(map(int, input().split()))
x = int(input())

nums = set()
cnt = 0
for num in arr:
    if x - num in nums:
        cnt += 1
    else:
        nums.add(num)
print(cnt)
```
- 배열을 순서대로 순회한다. 만약 자신의 짝이 set에 존재하면, cnt를 증가시킨다.
- 짝이 존재하지 않으면 set에 자기 자신을 삽입한다.

---

# 문제
- 플랫폼 : 백준
- 번호 : 01145
- 제목 : 적어도 대부분의 배수
- 난이도 : Bronze 1
- 문제 : <a href="https://www.acmicpc.net/problem/1145" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스

---

# 풀이
```python
nums = list(map(int, input().split()))
def gcd(a,b):
    if a < b:
        a, b = b, a
    r = a % b
    return b if r == 0 else gcd(b, r)

def lcm(a,b):
    return a * b // gcd(a,b)

answer = 1000000
for x in range(3):
    for y in range(x+1, 5):
        for z in range(y+1, 5):
            answer = min(answer, lcm(lcm(nums[x], nums[y]), nums[z]))
print(answer, end ='')
```
- 임의의 세개 수를 골라서, 최소공배수를 구하기를 반복하고 그 값들의 최솟값을 찾아서 출력하면 된다.
- 개인적 삽질
  - 가능한 범위의 수들(제일 큰 수 세개의 곱까지)을 각 숫자들의 배수들을 체크하면서 카운팅한다음, 카운트가 3을 넘어가는 제일 작은 수를 출력

---

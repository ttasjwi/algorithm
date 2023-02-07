# 문제
- 플랫폼 : 백준
- 번호 : 04673
- 제목 : 셀프 넘버
- 난이도 : Silver 5
- 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 할 때, n을 d(n)의 생성자라고 한다. 예를 들어
d(75) = 75 + 7 + 5 = 87 이고, 87의 생성자는 75이다. 생성자가 없는 숫자를 셀프 넘버라고 할 때, 10000보다 작거나 같은
셀프 넘버를 한 줄에 하나씩 출력하라.
- 문제 : <a href="https://www.acmicpc.net/problem/4673" target="_blank">링크</a>

---

# 필요 알고리즘
- 구현

---

# 풀이
```python
import sys

print = sys.stdout.write


def d(k):
    j = k
    while j > 0:
        k += j % 10
        j //= 10
    if k > 10000 or check[k]:
        return
    check[k] = True
    d(k)


check = [False] * 10001
for i in range(1, 10001):
    if not check[i]:
        d(i)
        print(str(i) + '\n')
```
- 1부터 순서대로 d(k)를 적용하여 연쇄적으로 다음 값들을 체크한다.
- 순서대로 순회할 때, 체크되지 않은 값들은 셀프넘버다. 이들은 순서대로 출력하고 d(k)를 적용해나간다.

---

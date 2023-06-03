# 문제
- 플랫폼 : 백준
- 번호 : 02501
- 제목 : 약수 구하기
- 난이도 : Bronze 3
- N의 약수들 중 K번째로 작은 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2501" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
import math

n, k = map(int, input().split())

aliquots = []

for i in range(1, int(math.sqrt(n)) + 1):
    if n % i == 0:
        aliquots.append(i)
        if i * i != n:
            aliquots.append(n // i)
aliquots.sort()
print(0 if k > len(aliquots) else aliquots[k - 1])
```
- 약수를 구할 떄는 거듭제곱근까지만 따져주면 된다. (예: 2가 6의 약수이면 6을 2로 나눈 3도 2의 약수이다.)
- 순서대로 약수를 구하고 수집하여, 정렬한뒤 결과를 출력하면 된다

---

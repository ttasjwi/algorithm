# 문제
- 플랫폼 : 백준
- 번호 : 01225
- 제목 : 이상한 곱셈
- 난이도 : Bronze 2
- 숫자 두개가 주어질 때 각 자리의 숫자에 대해, 가능한 모든 조합 (A가 n자리, B가 m자리 수라면 총 가능한 조합은 n×m개)을 더한 수 구하기 
- 문제 : <a href="https://www.acmicpc.net/problem/1225" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
## 풀이1
```python
n, m = map(lambda x: [int(ch) for ch in x], input().split())
if n[0] == 0 or m[0] == 0:
    print(0)
else:
    sum = 0
    for x in n:
        for y in m:
           sum += x * y
    print(sum)
```
- 정말 순수하게 모든 수의 조합을 곱했다. -> 시간초과

## 풀이2
```python
n, m = map(lambda x: [int(ch) for ch in x], input().split())
print(sum(n) * sum(m))
```
- 각 숫자들의 합을 구하고 곱했다.

---

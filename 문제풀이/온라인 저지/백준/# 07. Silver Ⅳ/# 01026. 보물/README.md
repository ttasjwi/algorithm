# 문제
- 플랫폼 : 백준
- 번호 : 01026
- 제목 : 보물
- 난이도 : Silver 4
- `S = A[0] × B[0] + ... + A[N-1] × B[N-1]`에 대해 S의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1026" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```python
input()
print(sum(x * y for x, y in zip(sorted([int(k) for k in input().split()], reverse=True),
                                sorted(int(k) for k in input().split()))))
```
- a는 내림차순 정렬
- b는 오름차순 정렬
- 순차적으로 곱하면 합이 최소가 된다.
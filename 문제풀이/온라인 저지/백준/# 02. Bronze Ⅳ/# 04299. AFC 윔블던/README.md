# 문제
- 플랫폼 : 백준
- 번호 : 04299
- 제목 : AFC 윔블던
- 난이도 : Bronze 4
- 첫째 줄에 두 팀의 경기 결과를 출력한다. 득점을 많이 한 쪽을 먼저 출력한다. 만약, 그러한 합과 차를 갖는 경기 결과가 없다면, -1을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4299" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
sum, diff = map(int, input().split())

if sum < diff or (sum - diff) % 2 or (sum + diff) % 2:
    answer = '-1'
else:
    a = (sum + diff) // 2
    b = (sum - diff) // 2
    answer = ' '.join([str(a), str(b)])
print(answer, end='')
```
- 우선 sum, diff가 음수인 경우는 입력 범위에 없다.
- `a >= b` 가정
- sum보다 diff가 크다거나, sum-diff가 2로 나누어 떨어지지 않는 경우, 또는 sum+diff 가 2로 나누어 떨어지지 않는 경우는 무조건 잘못 됐다.
- 그 외의 경우에는 자연스럽게 구할 수 있다.

---

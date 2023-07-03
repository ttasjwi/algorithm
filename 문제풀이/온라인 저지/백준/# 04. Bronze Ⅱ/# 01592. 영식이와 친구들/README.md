# 문제
- 플랫폼 : 백준
- 번호 : 01592
- 제목 : 영식이와 친구들
- 난이도 : Bronze 2
- 공을 몇 번 던지는지 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1592" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n, m, l = map(int, input().split())
pass_counts = [0] * n
total_counts = -1
i = 0
while True:
    pass_counts[i] += 1
    total_counts += 1
    if pass_counts[i] == m:
        break
    i = (i + l) % n if pass_counts[i] % 2 else (i - l) % n
print(total_counts)
```
- 처음에 공을 전달한 횟수를 -1로 취급하고 다음을 반복한다.
  - i번 사람의 공을 받은 횟수를 1 증가 시킨다.
  - 전체 공 전달 횟수를 1 증가시킨다.
  - 해당 사람의 공 전달 횟수가 m이면 반복을 탈출한다.
  - 해당 사람의 공 전달 횟수가 짝수이면 +l 시키고, % n 연산 시킨다.(오른쪽 패스)
  - 해당 사람의 공 전달 횟수가 홀수이면 -l 시키고, % n 연산 시킨다. (왼쪽 패스)
- 
# 문제
- 플랫폼 : 백준
- 번호 : 05597
- 제목 : 과제 안 내신분..?
- 난이도 : Bronze 3
- 문제 : <a href="https://www.acmicpc.net/problem/5597" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
check = [False] * 31
for _ in range(28):
    check[int(input())] = True

for i in range(1, 31):
    if not check[i]:
        print(i)
```
- 과제 제출자를 check 처리 하고, 전부 순회하면서 체크 안 된 사람을 찾아서 출력

---


# 문제
- 플랫폼 : 백준
- 번호 : 06246
- 제목 : 풍선 놀이
- 난이도 : Bronze 2
- 문제 : <a href="https://www.acmicpc.net/problem/6246" target="_blank">링크</a>

---

# 필요 지식
- 해시테이블

---

# 풀이
```python
n, q = map(int, input().split())
slot_set = {i+1 for i in range(n)}

for _ in range(q):
    l, i = map(int, input().split())
    for num in range(l, n+1, i):
        if num in slot_set:
            slot_set.remove(num)
print(len(slot_set), end ='')
```
- set 에 숫자들을 저장하고, 각 요청이 들어왔을 때마다 set에서 제거
- 최종적으로 set 의 크기를 반환

---

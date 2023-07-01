# 문제
- 플랫폼 : 백준
- 번호 : 01434
- 제목 : 책 정리
- 난이도 : Bronze 2
- 전체 박스의 낭비된 용량의 합을 출력 
- 문제 : <a href="https://www.acmicpc.net/problem/1434" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.readline
input()
boxes = list(map(int, input().split()))
books = list(map(int, input().split()))
answer = sum(boxes)
box_idx = 0
for book in books:
    if boxes[box_idx] - book < 0:
        box_idx += 1
    boxes[box_idx] -= book
    answer -= book
print(answer)
```
- book을 기준으로 반복하고, 현재 바라보는 box 위치를 box_idx로 잡는다.
- 현재 가리키는 박스의 용량보다 책의 용량이 작으면, 다음 박스를 가리키도록 box_idx를 1 증가시킨다.
- 박스에 책을 담는다. (전체 잔여 용량과, 박스의 용량을 책의 용량만큼 차감한다.)
- 최종적으로 전체 잔여용량을 출력한다.

---

# 문제
- 플랫폼 : 백준
- 번호 : 32651
- 제목 : 인간은 무엇인가
- 난이도 : Bronze 4
- 문제 : <a href="https://www.acmicpc.net/problem/32651" target="_blank">링크</a>

---

# 필요 지식
- 해시 테이블

---

# 풀이
```python
memory = set()
x = 2024
while x <= 100000:
    memory.add(x)
    x += 2024

n = int(input())
print('Yes' if n in memory else 'No', end = '')
```
- 100000 이하의 2024의 배수를 모두 메모리에 저장해두고, 입력이 들어왔을 때 메모리에 있는 지 확인한다.

---

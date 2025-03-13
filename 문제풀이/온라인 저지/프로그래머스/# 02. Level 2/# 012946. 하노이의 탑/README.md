# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012946
- 제목 : 하노이의 탑
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12946" target="_blank">링크</a>

---

# 필요 지식
- 재귀

---

# 풀이
```python
def solution(n):
    answer = []

    def hanoi(n, start, mid, end):
        if n == 1:
            answer.append([start, end])
            return
        hanoi(n - 1, start, end, mid) # 맨 아래를 제외 한 나머지를 중간 경유지로 옮김
        hanoi(1, start, mid, end) # 맨 아래 하나를 목적지로 옮김
        hanoi(n - 1, mid, start, end) # 나머지 중간경유지에 있던 것들을 목적지로 옮김

    hanoi(n, 1, 2, 3)
    return answer
```

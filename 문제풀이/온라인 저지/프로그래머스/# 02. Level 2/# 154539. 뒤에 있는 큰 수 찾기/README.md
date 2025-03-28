# 문제
- 플랫폼 : 프로그래머스
- 번호 : 154539
- 제목 : 뒤에 있는 큰 수 찾기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154539" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```python
def solution(numbers):
    stack = []
    result = [-1] * len(numbers)
    # 역방향 반복
    for i in range(len(numbers)-1, -1, -1):
        # 스택에 요소가 있고, 스택의 마지막 요소가 현재 값보다 작거나 같으면 가치가 없으므로 전부 버림
        while stack and stack[-1] <= numbers[i]:
            stack.pop()
            
        # 스택에 요소가 남아있다면, 스택에 남아있는 수는 가장 가까운 가장 큰 수가 됨
        if stack:
            result[i] = stack[-1]
        # 스택에 현재 값을 삽입
        stack.append(numbers[i])
    return result
```

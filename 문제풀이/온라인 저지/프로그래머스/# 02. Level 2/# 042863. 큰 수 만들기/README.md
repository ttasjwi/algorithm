# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042863
- 제목 : 큰 수 만들기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42863" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```python
def solution(number, k):
    stack = []
    for num in number:
        # 앞에서 작은 수가 있고, 삭제횟수가 있으면 가능한 지워야함
        while stack and k > 0 and num > stack[-1]:
            stack.pop()
            k -= 1
        stack.append(num)

    # 삭제횟수를 다 못 쓸 수 있음. 이 경우 뒤에 쌓이는 숫자들은 점점 갈 수록 숫자가 작아짐
    # 뒤의 숫자들을 차례로 제거해야함
    while k > 0:
        stack.pop()
        k -= 1
    return ''.join(stack)
```

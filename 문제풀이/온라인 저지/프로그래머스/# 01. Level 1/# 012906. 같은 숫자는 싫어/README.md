# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012906
- 제목 : 같은 숫자는 싫어
- 난이도 : Level 1
- 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12906" target="_blank">링크</a>

---

# 필요 지식
- 리스트 컴프리헨션
- Stack

---

# 풀이

## 풀이1 : 리스트 컴프리헨션
```python
def solution(arr):
    return [value for idx, value in enumerate(arr) if idx == 0 or value != arr[idx-1]]
```
- enumerate를 사용하면 배열의 인덱스, 값을 함께 순서대로 접근할 수 있다.
- idx가 0이거나, 이전 요소와 값이 같으면 value를 요소에 삽입하고, 아니면 삽입하지 않는다.

## 풀이2 : Stack 활용
```python
def solution(arr):
    stack = []
    for value in arr:
        if (not stack) or (stack[-1] != value):
            stack.append(value)

    return stack
```
- 빈 stack을 하나 만든다.
- stack이 비어있거나, 이전 요소와 현재 요소가 같지 않으면 stack에 요소를 삽입한다.
- stack을 그대로 반환한다.

---

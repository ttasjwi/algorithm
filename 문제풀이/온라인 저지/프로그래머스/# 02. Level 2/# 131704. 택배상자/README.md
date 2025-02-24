# 문제
- 플랫폼 : 프로그래머스
- 번호 : 131704
- 제목 : 택배상자
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131704" target="_blank">링크</a>

---

# 필요 지식
- 스택
- 큐

---

# 풀이

### 풀이1 : 큐, 스택 모두 활용
```python
from collections import deque


def solution(order):
    # 각 상자의 우선순위값을 큐에 순서대로 삽입.
    queue = init_queue(order)

    # 찾고자 하는 우선 순위
    target_priority = 0
    stack = []
    while True:
        # 스택 최상단에 찾고자 하는 우선순위의 상자가 있을 경우
        if stack and stack[-1] == target_priority:
            stack.pop()
            target_priority += 1

        elif queue:
            # 큐 최상단에 찾고자 하는 우선순위의 상자가 있을 경우
            if queue[0] == target_priority:
                queue.popleft()
                target_priority += 1
            # 없을 경우 스택에 큐 최상단 요소 삽입
            else:
                stack.append(queue.popleft())
        else:
            # 큐가 비어있으면 target_priority 값만큼 상자를 채웠음을 반환
            answer = target_priority
            return answer


def init_queue(order):
    # order[i]는 기존의 컨테이너 벨트에 order[i]번째 상자를 i+1번째로 트럭에 실어야 함
    # 즉 order 배열의 인덱스는 우선순위 / 해당 인덱스의 요소는 그 우선순위를 가진 상자

    # 일단 order_priorities 딕셔너리에, (상자번호, 우선순위) 를 삽입
    order_priorities = {o - 1: p for p, o in enumerate(order)}
    queue = deque()

    # 상자 번호 순으로 대응하는 우선순위 값을 삽입
    for o in range(len(order)):
        queue.append(order_priorities[o])
    return queue
```

### 풀이2: 스택 활용(성능 최적화)
```python
def solution(order):
    answer = 0
    stack = []

    # 벨트에는 번호순으로 상자가 위치함. 맨 앞 상자의 번호
    container_belt_head_box_number = 1

    # order 에는 순서대로 우선 찾고자 하는 상자번호가 위치함
    for find_box_number in order:
        # 컨테이너 벨트의 최상단 박스번호가, 지금 찾아야 하는 박스 번호보다 작거나 같은 경우
        if container_belt_head_box_number <= find_box_number:
            # 작은 동안 컨테이너벨트 맨앞 상자를 계속 스택에 옮김.
            while container_belt_head_box_number < find_box_number:
                stack.append(container_belt_head_box_number)
                container_belt_head_box_number += 1
            # 같은 경우, 컨테이너벨트 최상단 상자를 제거
            answer += 1
            container_belt_head_box_number += 1
        else:
            # 컨테이너 벨트 최상단 상자번호보다 찾고자 하는 상자번호가 클 경우, 이미 스택에 옮겨가져 있는 지 확인
            if stack and stack.pop() == find_box_number:
                answer += 1
            else:
                break
    return answer
```

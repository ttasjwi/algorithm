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

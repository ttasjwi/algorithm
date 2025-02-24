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

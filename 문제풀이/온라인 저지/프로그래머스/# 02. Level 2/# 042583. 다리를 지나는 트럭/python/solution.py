from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0 # 현재 시각
    bridge_queue = deque([0] * bridge_length) # 다리 위를 지나가는 차량의 상태를 큐로 표현
    current_bridge_weight = 0 # 다리 위에 놓인 무게 합
    truck_cursor = 0 # 통과해야할 트럭의 번호

    while True:
        time += 1
        first = bridge_queue.popleft() # 다리 맨 앞의 요소를 제거
        current_bridge_weight -= first

        # 트럭을 실었을 때 다리가 견딜 수 있으면
        if truck_cursor < len(truck_weights) and current_bridge_weight + truck_weights[truck_cursor] <= weight:
            current_bridge_weight += truck_weights[truck_cursor]
            bridge_queue.append(truck_weights[truck_cursor])
            truck_cursor += 1

        # 다리에 0만 삽입(공기만 지나감)
        else:
            bridge_queue.append(0)

        # 다리 위의 무게가 0이 됐을 때 (모든 트럭이 지나갔을 때) 종료
        if current_bridge_weight == 0:
            break
    return time

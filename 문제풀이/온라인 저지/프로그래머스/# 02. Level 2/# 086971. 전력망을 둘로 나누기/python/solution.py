from collections import deque


def solution(n, wires):
    # 각 노드에서 인접한 노드들
    graph = [[] for _ in range(n + 1)]
    for wire in wires:
        graph[wire[0]].append(wire[1])
        graph[wire[1]].append(wire[0])

    min_diff = 101
    for wire in wires:
        a, b = wire # wire 각각의 양 끝점
        a_size = get_tree_size(a, b, graph) # a 로 시작하고 b를 제거했을 때의 노드 갯수
        b_size = n - a_size # b 로 시작하고 a를 제거했을 때의 노드 갯수 (n에서 빼주면 됨)
        diff = abs(a_size - b_size) # 둘의 차이
        if diff < min_diff:
            min_diff = diff # 둘의 차이가 최소 차이보다 작으면 최소 차이 갱신
    return min_diff

# start 에서 시작하여 트리 탐색 후, 트리에 속한 노드의 갯수 구하기
# 이 때 ignore 은 무시한다.
def get_tree_size(start, ignore, nodes):
    visited = [False] * len(nodes)
    visited[start] = True
    visited[ignore] = True
    queue = deque([start])

    count = 1
    while queue:
        for _ in range(len(queue)):
            current_node = queue.popleft()

            for near_node in nodes[current_node]:
                if not visited[near_node]:
                    count += 1
                    visited[near_node] = True
                    queue.append(near_node)
    return count

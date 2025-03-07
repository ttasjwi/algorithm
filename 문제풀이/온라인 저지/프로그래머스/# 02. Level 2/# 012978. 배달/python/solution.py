import heapq

def solution(N, road, K):

    # 그래프(인접 리스트)
    graph = {i: [] for i in range(1, N + 1)}
    for a, b, c in road:
        graph[a].append((b, c))
        graph[b].append((a, c))
    heap = []

    # 힙에는 (각 노드별 도달 비용, 노드 번호) 를 삽입
    heapq.heappush(heap, (0, 1))

    # 각 노드별 도달 최소 비용
    costs = [20_000_000] * (N + 1)
    costs[1] = 0
    answer = 0

    while heap:
        # 그 시점에서 노드 도달비용이 제일 작을 경우 추출됨
        cost, start = heapq.heappop(heap)

        if costs[start] < cost:
            continue

        # 이 시점에 왔을 때 그 노드에 도달한 최소비용 확정

        if costs[start] <= K:
            answer += 1

        # 인접한 노드들을 확인하며 최소 도달 비용을 갱신시키는 가능성이 있는 지 확인
        # 가능성이 있다 판단되면 최소비용 갱신
        # 힙에 삽입 (노드 도달비용, 노드)
        for end, next_cost in graph[start]:
            alt = cost + next_cost
            if costs[end] > alt:
                costs[end] = alt
                heapq.heappush(heap, (alt, end))

    return answer

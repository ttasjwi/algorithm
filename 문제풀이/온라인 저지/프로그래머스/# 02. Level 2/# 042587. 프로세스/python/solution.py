from collections import deque
import heapq


def solution(priorities, location):
    queue = deque()
    heap = []
    for i, p in enumerate(priorities):
        queue.append((i, p))
        heapq.heappush(heap, -p)
    count = 0

    while queue:
        queue_item = queue.popleft()
        if queue_item[1] == -heap[0]:
            heapq.heappop(heap)
            count += 1
            if queue_item[0] == location:
                return count
        else:
            queue.append(queue_item)

from collections import deque

def solution(progresses, speeds):
    answer = []
    queue = deque()

    # 각 작업의 비용을 구하고, queue 에 순서대로 담기
    for progress, speed in zip(progresses, speeds):
        cost, remainder = divmod(100 - progress, speed)
        if remainder:
            cost += 1
        queue.append(cost)

    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 꺼낸 값을 경과 일로 삼음
        elapsed_day = queue.popleft()

        # 경과 일까지 한 작업의 수
        count = 1

        # 경과일보다 비용이 작거나 같은 작업들을 큐에서 모두 꺼내서 count 증가
        while queue and queue[0] <= elapsed_day:
            queue.popleft()
            count += 1

        # 경과일(배포일)까지 한 작업의 수를 answer에 담음
        answer.append(count)
    return answer

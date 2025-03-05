from collections import deque

def solution(players, m, k):
    servers = deque() # 존재하는 서버들
    answer = 0

    # 매 시간
    for hour in range(24):

        # 만료된 서버들 제거
        while servers:
            if servers[0] + k == hour:
                servers.popleft()
            else:
                break

        # 부족한 서버의 댓수
        require_server_count = players[hour] // m - len(servers)

        if require_server_count < 0:
            require_server_count = 0

        # 부족한 서버 수만큼 서버를 증설
        for _ in range(require_server_count):
            servers.append(hour)

        # 증설한 서버 댓수만큼 answer 증가
        answer += require_server_count
    return answer

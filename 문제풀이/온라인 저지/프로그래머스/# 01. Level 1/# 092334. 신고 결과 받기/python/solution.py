from typing import List


def solution(id_list:List[str], reports:List[str], k:int):
    # 각 유저가 신고 받은 횟수
    counter = {id: 0 for id in id_list}

    # 각 유저가 신고한 내역 초기화
    graph = {id: set() for id in id_list}
    for report in reports:
        a, b = report.split()
        if b not in graph[a]:
            graph[a].add(b)
            counter[b] += 1

    # 각 유저의 신고 내역을 다시 읽어가면서, 처리 결과 메일 갯수 정산
    answer = []
    for a in id_list:
        cnt = 0
        for b in graph[a]:
            if counter[b] >= k:
                cnt += 1
        answer.append(cnt)
    return answer


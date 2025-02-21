from collections import deque


def solution(msg):
    dic = {chr(ord('A') + n - 1): n for n in range(1, 27)} # A-Z 딕셔너리
    next_order = 27
    answer = []
    queue = deque(msg) # 전체 남은 입력

    w = '' # 초기 입력은 없음
    while queue:
        w += queue.popleft() # 입력을 맨 앞에서 한 자씩 추가

        # 다음 입력이 없으면
        if not queue:
            # 현재입력에 해당하는 색인 번호를 출력하고 종료
            answer.append(dic[w])
            break

        c = queue[0] # 다음 입력
        wc = w + c # 현재 입력 + 다음입력

        # 현재 입력 + 다음 입력이 사전에 없으면
        if wc not in dic:
            answer.append(dic[w]) # 현재 입력을 출력
            w = '' # 현재 입력을 초기화
            dic[wc] = next_order # 딕셔너리에 현재입력 + 다음입력 추가
            next_order += 1

    return answer

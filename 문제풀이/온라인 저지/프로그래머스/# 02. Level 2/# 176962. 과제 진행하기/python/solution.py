def solution(plans):
    plans = sorted(map(convert, plans), key=lambda x: x[1])
    stack = []
    answer = []
    for i, plan in enumerate(plans):
        stack.append(plan)
        if i == len(plans) - 1:
            break

        # 다음 작업까지 남은 시간
        usable_time = plans[i + 1][1] - plans[i][1]
        while stack and usable_time > 0:
            # 스택 최상단에 위치한 작업
            top = stack[-1]

            # 남은시간보다 작업의 잔여시간이 작거나 같으면
            if top[2] <= usable_time:
                stack.pop() # 추출
                answer.append(top[0]) # 작업명 추가
                usable_time -= top[2] # 잔여시간 차감
            else:
                stack[-1][2] -= usable_time # 작업의 잔여시간 감소
                usable_time = 0 # 잔여시간을 0으로 만들기

    # 스택에 작업이 남아있으면 순서대로 처리됨이 자명하므로, 순서대로 answer 에 작업명 추가
    while stack:
        cur_plan = stack.pop()
        answer.append(cur_plan[0])
    return answer

def convert(plan):
    hour, minute = plan[1].split(":")

    return [plan[0], int(hour) * 60 + int(minute), int(plan[2])]

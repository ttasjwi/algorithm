def solution(prices):
    answer = [0] * len(prices)  # 가격이 떨어지지 않은 기간

    stack = []
    for t, price in enumerate(prices):
        # <요구사항 분석>
        # 1. xxx 에는 매 초마다 그 시점의 (시간, 가격) 튜플을 저장해야한다
        # 2. xxx 에 저장한 튜플은 가격순으로 놓이게되며, 꺼낸 튜플은 그 xxx 에서 가장 가격이 비싸야함
        # 3. xxx 에 저장한 튜플을 꺼냈을 때 가격이 현재 가격보다 비싸면 계속 저장할 가치가 없음(가격이 떨어졌으므로)
        #   3-1. 이런 것들은, 전부 꺼내다가 answer 의 해당 시각 인덱스쪽에서, 몇 초만에 가격 하락이 있었는지 갱신해야함
        # 4. xxx 에 (시간, 가격) 튜플을 전부 저장해야함
        # 5. 마지막에 놓인 요소가, 가장 가격이 비싼 (시간, 튜플) 이 되어야하고, 매번 이를 먼저 꺼내는 구조가 편리
        # 6. xxx = 스택
        while stack and stack[-1][1] > price:
            start_t = stack.pop()[0]
            answer[start_t] = t - start_t
        stack.append((t, price))

    # 스택에 남아있으면 마지막까지 가격이 떨어지지 않은 것들
    while stack:
        start_t = stack.pop()[0]
        answer[start_t] = len(prices) - 1 - start_t
    return answer

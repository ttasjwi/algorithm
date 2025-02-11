def solution(want, number, discount):
    answer = 0
    want_counter = {} # 희망 구매 목록
    daily_counter = {} # 현재 수량

    # want-number 쌍을 순회하면서 목록 초기화
    for w, n in zip(want, number):
        want_counter[w] = n
        daily_counter[w] = 0

    # discount 를 순회하면서 목록 초기화
    for item in discount:
        if item not in want_counter:
            want_counter[item] = 0
        if item not in daily_counter:
            daily_counter[item] = 0

    # 날짜 경과하면서 그날 할인품목을 추가(첫날부터), 제거(10일차부터)
    # 그날 할인품목과 희망 할인품목 비교(9 일차부터)
    for day in range(len(discount)):
        daily_counter[discount[day]] += 1
        if day >= 10:
            daily_counter[discount[day - 10]] -= 1
        if day >= 9 and want_counter == daily_counter:
            answer += 1
    return answer

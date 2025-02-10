def solution(people, limit):
    # 몸무게 순으로 정렬
    people.sort()

    answer = 0
    lt = 0
    rt = len(people) - 1

    # 두 명 이상 구해야할 때
    while lt < rt:
        answer += 1
        # 몸무게가 작은 사람을 함께 태울 수 있으면 함께 태우기
        if limit - people[rt] >= people[lt]:
            lt += 1
        # 무거운 사람 태우기
        rt -= 1

    # 한 사람 남아있을 때
    if lt == rt:
        answer += 1
    return answer

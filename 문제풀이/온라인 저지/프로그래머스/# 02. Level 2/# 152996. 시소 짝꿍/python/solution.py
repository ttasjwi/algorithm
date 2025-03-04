def solution(weights):
    rates = {4/2, 4/3, 3/2, 2/4, 3/4, 2/3, 1}
    counter = dict()
    answer = 0
    for w in weights:
        for r in rates:
            nw = w * r # 자신의 무게에 대한 가능한 모든 배율 적용 곱들

            # 자신의 r배에 해당하는 무게가 존재하면
            if nw in counter:
                # 그 무게에 해당하는 갯수만큼 가능한 선택 가짓수 증가 (case : 나 자신 + 반대쪽 무게)
                answer += counter[nw]

        # 내 무게에 해당하는 counter 값 증가
        if w not in counter:
            counter[w] = 1
        else:
            counter[w] += 1
    return answer

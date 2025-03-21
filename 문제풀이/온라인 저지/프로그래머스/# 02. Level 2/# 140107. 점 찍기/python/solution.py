from math import sqrt
def solution(k, d):
    answer = 0

    # x 좌표를 x 라 할 때
    # y 값은 sqrt(d ** 2 - x ** 2) 보다 같거나 작아야한다. 정수 범위 내에서만 유효하므로 여기에 int 처리 (잘 모르겠으면 원 그려놓고 피타고라스 정리를 통해 구해보면 된다.)
    # 1~ max_y(위에서 구한 정수 y값) 사이에서, 가능한 점의 갯수는 이를 k 로 나눈 몫만큼이다.
    # 여기에 y = 0 일때 (x축 교차지점) 경우도 고려하여 1도 더함.
    for x in range(0, d + 1, k):
        answer += int(sqrt(d ** 2 - x ** 2))//k + 1
    return answer

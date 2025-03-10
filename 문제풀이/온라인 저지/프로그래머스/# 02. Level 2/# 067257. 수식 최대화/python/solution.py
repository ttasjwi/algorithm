from itertools import permutations
from collections import deque

# 각 연산자 별로 수행할 연산
dict = {
    '+': (lambda x, y: x + y),
    '-': (lambda x, y: x - y),
    '*': (lambda x, y: x * y),
}


def solution(expression):
    answer = 0
    split_list = split(expression) # 분해
    for perm in permutations(['+', '-', '*'], 3):
        dq = deque(split_list) # 데큐에 split_list 모두 삽입
        for priority_oper in perm:
            cursor = 0  # 덱에서 현재 몇 번 반복했는 지 기억하기 위한 인덱스
            size = len(dq)  # 기존 덱의 사이즈
            while cursor < size:
                item = dq.popleft()  # 덱에서 가장 앞의 요소를 추출
                if item == priority_oper:
                    # 현재 우선순위 기호일 경우
                    # 덱의 마지막에 위치한 값을 추출하고, 덱의 다음 맨 앞 값을 추출한 뒤 연산하고 다시 덱에 삽입
                    dq.append(dict[item](dq.pop(), dq.popleft()))
                    cursor += 2  # 다음 값도 추출했으므로 cursor 를 2단계 전진
                else:
                    # 그 외의 경우 덱에 다시 삽입
                    dq.append(item)
                    cursor += 1
        abs_value = abs(dq[0])  # 마지막에 남은 값
        if abs_value > answer:
            answer = abs_value  # 제일 절대값이 큰 값으로 갱신
    return answer  # answer 반환


# 기존 표현식을 읽어가면서 숫자는 숫자형태로 삽입하고, 연산자는 숫자값으로 변환
def split(expression):
    result = []
    v = 0
    for ch in expression:
        if ch in dict:
            result.append(v)
            result.append(ch)
            v = 0
        else:
            v *= 10
            v += ord(ch) - ord('0')
    result.append(v)
    return result

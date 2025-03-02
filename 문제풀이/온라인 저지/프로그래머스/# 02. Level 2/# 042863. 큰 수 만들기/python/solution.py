def solution(number, k):
    stack = []
    for num in number:
        # 앞에서 작은 수가 있고, 삭제횟수가 있으면 가능한 지워야함
        while stack and k > 0 and num > stack[-1]:
            stack.pop()
            k -= 1
        stack.append(num)

    # 삭제횟수를 다 못 쓸 수 있음. 이 경우 뒤에 쌓이는 숫자들은 점점 갈 수록 숫자가 작아짐
    # 뒤의 숫자들을 차례로 제거해야함
    while k > 0:
        stack.pop()
        k -= 1
    return ''.join(stack)

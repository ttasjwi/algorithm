def solution(s):
    answer = 0
    pairs = {'{': '}', '(': ')','[': ']'}

    for lt in range(len(s)):
        # 여는 괄호만 넣는 스택
        stack = []
        rt = lt
        is_wrong = False
        while True:
            # 여는 괄호이면 스택에 append
            if s[rt] in pairs:
                stack.append(s[rt])

            # 닫는 괄호이면
            else:
                # 스택이 비어있지 않고, 스택 최상단에 위치한 것이 현재 문자의 반대 괄호이면
                if stack and (stack[-1] in pairs) and (pairs[stack[-1]] == s[rt]):
                    stack.pop()
                # 위 경우에 해당하지 않으면 옳바르지 않은 문자열이므로 바로 반복 탈출
                else:
                    is_wrong = True
                    break

            # rt 를 전진시키고, 길이로 나눈 나머지로 재할당한다. (이러면 끝 인덱스를 넘어도 순회한다.)
            rt = (rt + 1) % len(s)

            # lt 와 rt 가 같아지면 순회가 끝난 것이다
            if lt == rt:
                break

        # 여태 올바르면서, stack 이 비어있지 않으면
        if not is_wrong and not stack:
            answer += 1
    return answer


def solution(word):
    answer = 0
    find = False
    chars = ['A', 'E', 'I', 'O', 'U']

    def dfs(idx, arr):
        nonlocal answer, find
        for i in range(5):
            if find:
                return
            answer += 1
            arr.append(chars[i])
            current_word = ''.join(arr)
            if word == current_word:
                find = True
                return
            if not find and idx + 1 <= 4:
                dfs(idx + 1, arr)
            arr.pop()
    dfs(0, [])
    return answer

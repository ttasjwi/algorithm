def solution(n, words):
    word_set = set()
    word_set.add(words[0])
    turn = 1
    cur = 1
    for i in range(1, len(words)):
        if words[i] in word_set or words[i-1][-1] != words[i][0]:
            return [cur + 1, turn]
        word_set.add(words[i])

        cur += 1
        if cur == n:
            turn += 1
            cur %= n
    return [0, 0]

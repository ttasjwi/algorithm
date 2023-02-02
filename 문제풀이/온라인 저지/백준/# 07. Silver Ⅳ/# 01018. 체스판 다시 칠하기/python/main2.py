import sys

input = sys.stdin.readline

n, m = map(int, input().split())
array = [[True if ch == 'W' else False for ch in input()] for _ in range(n)]
counter = [[0 for j in range(m + 1)] for _ in range(n + 1)]
answer = 32
for i in range(1, n + 1):
    flag = i % 2
    for j in range(1, m + 1):
        current = array[i - 1][j - 1]
        counter[i][j] = counter[i - 1][j] + counter[i][j - 1] - counter[i - 1][j - 1]
        if current != flag:
            counter[i][j] += 1
        flag = not flag

        if i >= 8 and j >= 8:
            area_sum = counter[i][j] - counter[i - 8][j] - counter[i][j - 8] + counter[i - 8][j - 8]
            if area_sum > 32:
                area_sum = 64 - area_sum
            if answer > area_sum:
                answer = area_sum
print(answer, end='')

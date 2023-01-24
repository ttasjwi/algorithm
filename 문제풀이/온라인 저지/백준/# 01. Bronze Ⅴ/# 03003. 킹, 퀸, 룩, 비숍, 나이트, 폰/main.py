right_pieces = [1, 1, 2, 2, 2, 8]  # 킹, 퀸, 룩, 비숍, 나이트, 폰
my_pieces = map(int, input().split())
answer = ' '.join(str(a-b) for a, b in zip(right_pieces, my_pieces))

print(answer, end='')

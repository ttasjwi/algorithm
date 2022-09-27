right_pieces = 1, 1, 2, 2, 2, 8  # 킹, 퀸, 룩, 비숍, 나이트, 폰
my_pieces = list(map(int, input().split()))
result = [right_pieces[i] - my_pieces[i]
          for i in range(len(right_pieces))
          ]

print(' '.join(map(str, result)), end='')

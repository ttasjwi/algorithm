d = 0
symbol = ['N', 'E', 'S', 'W']

for _ in range(10):
    cmd = input()
    # 우향우
    if cmd == '1':
        d = (d + 1) % 4
    # 뒤로 돌아
    elif cmd == '2':
        d = (d + 2) % 4
    # 좌향좌
    else:
        d = (d - 1) % 4
print(symbol[d], end = '')

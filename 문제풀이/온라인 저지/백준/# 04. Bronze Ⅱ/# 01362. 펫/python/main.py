# o : 적정 체중, w, 실제 체중
def print_status(o, w, count):
    if is_dead(w):
        print(f'{count} RIP')
    elif o * 0.5 < w < o * 2:
        print(f'{count} :-)')
    else:
        print(f'{count} :-(')


def is_dead(w):
    return w <= 0


count = 0
while True:
    o, w = map(int, input().split())
    if o == 0 and w == 0:
        exit(0)

    count += 1
    while True:
        command, n = input().split()
        n = int(n)
        if command == '#' and n == 0:
            print_status(o, w, count)
            break
        if is_dead(w):
            continue
        elif command == 'F':
            w += n
        else:
            w -= n

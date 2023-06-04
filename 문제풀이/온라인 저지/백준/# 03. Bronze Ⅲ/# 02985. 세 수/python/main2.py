operators = ['+', '-', '*', '/']
a, b, c = input().split()

for op in operators:
    if eval(f'{a}{op}{b}') == int(c):
        print(f'{a}{op}{b}={c}')
        exit(0)
    elif int(a) == eval(f'{b}{op}{c}'):
        print(f'{a}={b}{op}{c}')
        exit(0)

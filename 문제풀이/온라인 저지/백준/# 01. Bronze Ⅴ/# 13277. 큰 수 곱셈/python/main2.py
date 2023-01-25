from decimal import getcontext, Decimal

getcontext().prec = 600000
a, b = map(Decimal, input().split())
answer = a * b
print(answer, end='')

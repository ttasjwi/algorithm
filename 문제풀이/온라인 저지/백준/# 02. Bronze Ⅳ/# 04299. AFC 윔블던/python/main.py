sum, diff = map(int, input().split())

if sum < diff or (sum - diff) % 2 or (sum + diff) % 2:
    answer = '-1'
else:
    a = (sum + diff) // 2
    b = (sum - diff) // 2
    answer = ' '.join([str(a), str(b)])
print(answer, end='')

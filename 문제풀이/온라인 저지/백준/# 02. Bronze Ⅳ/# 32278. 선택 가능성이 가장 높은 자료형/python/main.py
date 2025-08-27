n = int(input())

if n > 2**31 -1 or n < - 2**31:
    answer = 'long long'
elif n > 2**15 -1 or n < -2 ** 15:
    answer = 'int'
else:
    answer = 'short'
print(answer, end ='')


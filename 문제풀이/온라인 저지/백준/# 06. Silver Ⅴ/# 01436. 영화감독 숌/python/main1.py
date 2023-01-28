n = int(input())

count = 0
number = 1
while True:
    if '666' in str(number):
        count += 1
        if count == n:
            break
    number += 1
print(number)

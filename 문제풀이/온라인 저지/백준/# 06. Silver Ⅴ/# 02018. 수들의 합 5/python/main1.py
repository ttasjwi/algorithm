n = int(input())

lt, rt = 1, 2
count = 1  # 자기 자신을 센 것

sum = 3
while lt < rt <= n:
    if sum < n:
        rt += 1
        sum += rt
    else:
        if sum == n:
            count += 1
        sum -= lt
        lt += 1
print(count, end='')

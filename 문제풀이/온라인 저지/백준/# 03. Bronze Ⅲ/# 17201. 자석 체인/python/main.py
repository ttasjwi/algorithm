input()
arr = list(input())
for i in range(1, len(arr)):
    if arr[i] == arr[i - 1]:
        print('No')
        exit(0)
print('Yes', end='')

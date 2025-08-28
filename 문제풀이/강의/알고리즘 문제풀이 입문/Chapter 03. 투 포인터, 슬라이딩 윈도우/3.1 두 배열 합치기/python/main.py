input()
arr1 = [int(x) for x in input().split()]
input()
arr2 = [int(x) for x in input().split()]

p1 = 0
p2 = 0
result = []
while p1 < len(arr1) and p2 < len(arr2):
    if arr1[p1] <= arr2[p2]:
        result.append(arr1[p1])
        p1 += 1
    else:
        result.append(arr2[p2])
        p2 += 1

while p1 < len(arr1):
    result.append(arr1[p1])
    p1 += 1
while p2 < len(arr2):
    result.append(arr2[p2])
    p2 += 1
print(*result, end = '')

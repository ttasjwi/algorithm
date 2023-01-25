n = int(input())

check = [False] * 1003002

for i in range(2, len(check)):
    if check[i]:
        continue

    if i >= n:
        string = str(i)
        if string == string[::-1]:
            print(string)

    for j in range(2 * i, len(check), i):
        check[j] = True


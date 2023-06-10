input()
print(sum(x * y for x, y in zip(sorted([int(k) for k in input().split()], reverse=True),
                                sorted(int(k) for k in input().split()))))

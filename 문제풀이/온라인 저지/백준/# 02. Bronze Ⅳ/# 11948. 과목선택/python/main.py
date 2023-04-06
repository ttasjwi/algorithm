science = sum(sorted([int(input()) for _ in range(4)], reverse=True)[0:3])
society = max(int(input()) for _ in range(2))
print(science + society)

result_set = ['D', 'C', 'B', 'A', 'E']
for _ in range(3):
    score = sum(map(int, input().split()))
    print(result_set[score])

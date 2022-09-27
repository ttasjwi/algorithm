import sys

_ = input()
for line in sys.stdin:
    total_count, *scores = map(int, line.split())
    avg = sum(scores) / total_count
    count = 0
    for score in scores:
        if score > avg:
            count += 1
    rate = count / total_count * 100
    print(f'{rate:.3f}%')

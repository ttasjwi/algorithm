import sys

print = sys.stdout.write
input = sys.stdin.readline


def main():
    t = int(input())
    answer = []
    while t > 0:
        _, m = map(int, input().split())
        q = []
        counter = [0] * 10
        for idx, value in enumerate(map(int, input().split())):
            q.append((idx, value))
            counter[value] += 1
        answer.append(solution(q, counter, m))
        t -= 1
    print('\n'.join(answer))


def solution(q, counter, m):
    count = 0
    for i in range(9, 0, -1):
        while counter[i] > 0:
            item = q.pop(0)
            if item[1] == i:
                counter[i] -= 1
                count += 1
                if item[0] == m:
                    return str(count)
            else:
                q.append(item)


if __name__ == '__main__':
    main()

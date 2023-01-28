import io, os, sys

print = sys.stdout.write
counts = [(1, 0), (0, 1)]


def main():
    nums = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:])
    answers = '\n'.join(solution(n) for n in nums)
    print(answers)


def solution(n):
    return ' '.join(map(str, calculate_count(n)))


def calculate_count(n):
    if len(counts) >= n + 1:
        return counts[n]
    a, b = calculate_count(n - 1), calculate_count(n - 2)
    count = (a[0] + b[0], a[1] + b[1])
    counts.append(count)
    return count


if __name__ == '__main__':
    main()

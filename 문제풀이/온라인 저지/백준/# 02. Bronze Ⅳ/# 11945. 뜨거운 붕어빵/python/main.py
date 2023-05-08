n, _ = map(int, input().split())
print('\n'.join([''.join(list(input())[::-1]) for _ in range(n)]))

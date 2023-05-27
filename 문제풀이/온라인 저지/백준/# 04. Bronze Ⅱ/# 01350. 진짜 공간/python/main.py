_ = input()
f = list(map(int, input().split()))
c = int(input())
print(sum([c * (x // c + 1) if x % c != 0 else x for x in f]))

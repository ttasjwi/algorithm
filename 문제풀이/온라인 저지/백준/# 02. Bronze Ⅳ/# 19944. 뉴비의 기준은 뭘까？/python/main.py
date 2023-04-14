n, m = map(int, input().split())
print('NEWBIE!' if m == 1 or m == 2 else 'OLDBIE!' if m <= n else 'TLE!')


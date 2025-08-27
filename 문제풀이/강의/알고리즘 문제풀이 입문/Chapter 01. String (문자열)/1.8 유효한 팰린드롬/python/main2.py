arr = [ch for ch in input().lower() if ch.isalpha()]
print('YES' if arr == arr[::-1] else 'NO', end='')

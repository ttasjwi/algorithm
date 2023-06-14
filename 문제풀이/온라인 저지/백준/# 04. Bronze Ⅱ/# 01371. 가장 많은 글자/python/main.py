import sys

counter = [0 for ch in range(26)]

max_count = 0

for ch in sys.stdin.read():
    idx = ord(ch) - 97
    if idx >= 0:
        counter[idx] += 1
        if max_count < counter[idx]:
            max_count = counter[idx]

for i in range(26):
    if counter[i] == max_count:
        sys.stdout.write(chr(i+97))

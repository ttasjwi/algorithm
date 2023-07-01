import sys

input = sys.stdin.readline
input()
boxes = list(map(int, input().split()))
books = list(map(int, input().split()))
answer = sum(boxes)
box_idx = 0
for book in books:
    if boxes[box_idx] - book < 0:
        box_idx += 1
    boxes[box_idx] -= book
    answer -= book
print(answer)

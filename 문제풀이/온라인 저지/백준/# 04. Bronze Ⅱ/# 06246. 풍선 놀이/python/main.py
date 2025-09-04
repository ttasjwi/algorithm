n, q = map(int, input().split())
slot_set = {i+1 for i in range(n)}

for _ in range(q):
    l, i = map(int, input().split())
    for num in range(l, n+1, i):
        if num in slot_set:
            slot_set.remove(num)
print(len(slot_set), end ='')

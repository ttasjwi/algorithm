answer = 0
counter = [0] * 9  # 0~8

for ch in input():
    require = int(ch)
    if require == 9:
        require = 6
    if counter[require] == 0:
        answer += 1
        counter = [num + 2 if idx == 6 else num + 1 for idx, num in enumerate(counter)]
    counter[require] -= 1
print(answer)

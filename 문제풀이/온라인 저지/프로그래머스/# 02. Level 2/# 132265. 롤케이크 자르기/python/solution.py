from collections import Counter

def solution(topping):
    counter_a = Counter({})
    counter_b = Counter(topping)

    answer = 0

    for item in topping:
        if item not in counter_a:
            counter_a[item] = 1
        else:
            counter_a[item] += 1

        if counter_b[item] == 1:
            counter_b.pop(item)
        else:
            counter_b[item] -= 1

        if len(counter_a) == len(counter_b):
            answer += 1

    return answer

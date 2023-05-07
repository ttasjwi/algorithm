n, a, b = map(int, input().split())
people = [i for i in range(1, n + 1)]


def solution():
    global people
    cnt = 0

    while len(people) > 1:
        cnt += 1
        new_people = []
        for i in range(0, len(people) // 2):
            if (a == people[2 * i] and b == people[2 * i + 1]) or (b == people[2 * i] and a == people[2 * i + 1]):
                return cnt
            else:
                if people[2 * i + 1] in [a, b]:
                    new_people.append(people[2 * i + 1])
                else:
                    new_people.append(people[2 * i])
        if len(people) % 2:
            new_people.append(people[-1])
        people = new_people
    return -1


print(solution())

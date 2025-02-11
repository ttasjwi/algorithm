def solution(n, a, b):
    answer = 0
    persons = [i + 1 for i in range(n)]

    while persons:
        answer += 1
        new_persons = []
        for i in range(0, len(persons), 2):
            if (persons[i] == a and persons[i + 1] == b) or (persons[i] == b and persons[i + 1] == a):
                return answer
            elif persons[i] == a or persons[i + 1] == a:
                new_persons.append(a)
            elif persons[i] == b or persons[i + 1] == b:
                new_persons.append(b)
            else:
                new_persons.append(persons[i])
        persons = new_persons
    return -1

def solution(s):
    result = []
    num_set = set()
    for num_list in sorted([list(map(int, x.split(','))) for x in s[2:-2].split('},{')], key=lambda x: len(x)):
        for i, num in enumerate(num_list):
            if num not in num_set:
                result.append(num)
                num_set.add(num)
                break

    return result

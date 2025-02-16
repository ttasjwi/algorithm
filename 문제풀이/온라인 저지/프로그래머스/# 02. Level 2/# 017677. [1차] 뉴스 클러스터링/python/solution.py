from collections import Counter


def solution(str1, str2):
    str1, str2 = str1.lower(), str2.lower()
    counter1 = Counter([str1[i:i + 2] for i in range(len(str1) - 1) if str1[i].isalpha() and str1[i + 1].isalpha()])
    counter2 = Counter([str2[i:i + 2] for i in range(len(str2) - 1) if str2[i].isalpha() and str2[i + 1].isalpha()])

    intersection_size = sum([v for v in (counter1 & counter2).values()])
    union_size = sum([v for v in (counter1 | counter2).values()])

    j = intersection_size / union_size if union_size else 1
    return int(j * 65536)

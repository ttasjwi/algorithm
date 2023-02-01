from collections import Counter


def solution(participant, completion):
    participant, completion = Counter(participant), Counter(completion)
    for key, value in participant.items():
        if key not in completion or completion[key] != value:
            return key


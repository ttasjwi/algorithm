import re


def solution(id: str):
    # 1단계
    id = id.lower()

    # 2단계
    id = re.sub(r'[^0-9a-z-_.]', '', id)

    # 3단계
    id = re.sub(r'\.{2,}', '.', id)

    # 4단계
    id = re.sub(r'^\.|\.$', '', id)

    # 5단계
    id = 'a' if id == '' else id

    # 6단계
    if len(id) < 16:
        pass
    else:
        id = id[:15]
        if id[-1] == '.':
            id = id[:-1]

    # 7단계
    if len(id) <= 2:
        end = id[-1]
        id += end * (3 - len(id))
    return id

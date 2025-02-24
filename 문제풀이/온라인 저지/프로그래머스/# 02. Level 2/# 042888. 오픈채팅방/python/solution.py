def solution(record):
    record = [r.split() for r in record]
    users = {}
    for r in record:
        if len(r) == 2:  # Leave
            continue
        command, uid, nickname = r
        users[uid] = nickname

    result = []
    for r in record:
        if len(r) == 2:
            command, uid = r
        else:
            command, uid, nickname = r

        if command == 'Enter':
            result.append(f'{users[uid]}님이 들어왔습니다.')
        elif command == 'Leave':
            result.append(f'{users[uid]}님이 나갔습니다.')
    return result

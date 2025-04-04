# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042888
- 제목 : 오픈채팅방
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42888" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 구현

---

# 풀이
```python
def solution(record):
    record = [r.split() for r in record]
    users = {}
    
    # 기록을 순서대로 순회하면서, 입력/닉네임변경 이력만 확인하면서 닉네임을 계속 갱신
    for r in record:
        if len(r) == 2:  # Leave
            continue
        command, uid, nickname = r
        users[uid] = nickname

    result = []
    
    # 이 시점에는 닉네임이 최신화되어있고, 이를 반영하여 result 배열 생성
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
```

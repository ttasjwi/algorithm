import sys

input = sys.stdin.readline
print = sys.stdout.write
sl = list(input().rstrip())  # 커서 기준 왼쪽
sr = []  # 커서 기준 오른쪽에 있는 것들. 전체 문자열로 치면 제일 뒤의 문자가 맨 앞에 위치한다

for _ in range(int(input())):
    line = input().rstrip().split()
    command = line[0]
    ch = None if len(line) == 1 else line[1]

    if command == 'L':
        # 커서 왼쪽 이동 -> 왼쪽 요소 맨 끝 문자가 오른쪽 맨 앞이 됨
        if sl:
            sr.append(sl.pop())
    elif command == 'D':
        # 커서 오른쪽 이동 -> 오른쪽 요소 맨 앞이 왼쪽요소 맨 뒤가 됨
        if sr:
            sl.append(sr.pop())
    elif command == 'B':
        # 커서 왼쪽 요소 삭제 -> 왼쪽요소 맨뒤 문자 제거
        if sl:
            sl.pop()
    elif command == 'P':
        # 커서 오른쪽에 문자 삽입 -> sl 뒤에 문자 추가
        sl.append(ch)

print(''.join(sl))
print(''.join(sr[::-1]))

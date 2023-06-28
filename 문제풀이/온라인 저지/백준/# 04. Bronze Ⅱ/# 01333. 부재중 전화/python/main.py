n, l, d = map(int, input().split())
# n : 노래의 갯수
# l : 노래의 길이
# d : 벨소리의 발생 주기

time = 0
for _ in range(n):
    time += l  # 음악을 틀어둔 시간 동안은 벨소리는 무시된다.
    for _ in range(0, 5):  # 공백 시간동안 1초씩 시간을 경과시켜가면서 벨소리가 들리는 타이밍을 찾아낸다.
        if time % d == 0:
            print(time)
            exit(0)
        time += 1  # 벨소리가 안 울렸다면 시간을 경과시킨다.
while time % d != 0:  # 음악이 더 이상 안 울리니 계속해서 시간을 경과시키면서 벨소리가 울리는 지 확인한다.
    time += 1
print(time)

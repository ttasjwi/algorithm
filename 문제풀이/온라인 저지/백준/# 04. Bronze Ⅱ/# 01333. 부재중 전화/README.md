# 문제
- 플랫폼 : 백준
- 번호 : 01333
- 제목 : 부재중 전화
- 난이도 : Bronze 2
- 첫째 줄에 강토가 전화벨을 들을 수 있는 가장 빠른 시간을 출력 
- 문제 : <a href="https://www.acmicpc.net/problem/1333" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
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
```
- 음악을 순서대로 재생시키는 것을 기준으로 반복을 돌린다.
  - 음악이 울리는 시간만큼은 time을 누적시킨다.
  - 음악 종료 후 5초의 공백동안 1초씩 시간을 증가시켜가면서 벨소리가 울리는지 확인한다. 벨소리가 울리는 시간은 현재 시간을 d로 나눈 나머지가 0일 때이다.
  - 벨소리가 안 울리면 시간을 1초씩 증가시킨다.
- 모든 노래를 종료하면, 시간을 1초씩 증가시켜가면서 벨소리가 울리는 타이밍을 잡아내고 time을 출력한다.

---

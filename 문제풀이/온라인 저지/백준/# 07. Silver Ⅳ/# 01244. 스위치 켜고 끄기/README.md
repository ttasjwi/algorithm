# 문제
- 플랫폼 : 백준
- 번호 : 01244
- 제목 : 스위치 켜고 끄기
- 난이도 : Silver 4
- 스위치들의 마지막 상태를 출력하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1244" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write
input()
switches = [0] + [True if ch == '1' else False for ch in input().split()]
for _ in range(int(input())):
    a, b = map(int, input().split())
    if a == 1:
        for i in range(b, len(switches), b):
            switches[i] = not switches[i]
    else:
        # 여자
        switches[b] = not switches[b]
        lt = b - 1
        rt = b + 1
        while 0 < lt and rt < len(switches):
            if switches[lt] == switches[rt]:
                switches[lt] = not switches[lt]
                switches[rt] = not switches[rt]
                lt -= 1
                rt += 1
            else:
                break

switches = ['1' if sw else '0' for sw in switches]

for i in range(1, len(switches)):
    print(switches[i])
    if i % 20 == 0:
        print('\n')
    else:
        print(' ')
```
- 스위치 상태 입력을 boolean으로 받는다(꼭 그럴 필요는 없긴 함)
- 남자의 경우 두번쨰 파라미터 배수의 스위치를 모두 뒤집는다
- 여자는 두번째 파라미터 기준 대칭으로 같지 않을 때 이전까지 모두 뒤집는다
- 최종 상태를 출력하기만 하면 된다.
  - 이때, 20의 배수 단위로 개행을 해줘야하는 것에 주의

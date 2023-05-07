# 문제
- 플랫폼 : 백준
- 번호 : 01057
- 제목 : 토너먼트
- 난이도 : Silver 4
- 첫째 줄에 김지민과 임한수가 대결하는 라운드 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1057" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이

## 풀이1 : 내 삽질
```python
n, a, b = map(int, input().split())
people = [i for i in range(1, n + 1)]


def solution():
    global people
    cnt = 0

    while len(people) > 1:
        cnt += 1
        new_people = []
        for i in range(0, len(people) // 2):
            if (a == people[2 * i] and b == people[2 * i + 1]) or (b == people[2 * i] and a == people[2 * i + 1]):
                return cnt
            else:
                if people[2 * i + 1] in [a, b]:
                    new_people.append(people[2 * i + 1])
                else:
                    new_people.append(people[2 * i])
        if len(people) % 2:
            new_people.append(people[-1])
        people = new_people
    return -1


print(solution())
```
- 실제로 짝수, 홀수 인덱스의 요소를 순서대로 비교해가면서, 기본적으로 앞의 요소를 올리되 뒤의 요소가 a 또는 b이면 올리도록 한다.
- 두 요소 모두 a, b 이면 거기서 중단시킨다.
- 2명씩 짝짓고 나머지가 있는 경우 다음번 참가자 리스트에 추가시킨다.
- 참가자 리스트를 다음번 참가자 리스트로 교체하길 반복한다.
- 참가자 리스트가 1보다 클 동안 반복하고, 여기까지 반복했음에도 찾지 못 했다면 -1을 반환한다.

---

## 풀이2
```python
n, a, b = map(int, input().split())

cnt = 0
while a != b:
    a = (a + 1) // 2
    b = (b + 1) // 2
    cnt += 1
print(cnt)
```
- 8번 참가자는 다음번 라운드에서 4번 참가자가 된다.
- 5번 참가자는 다음번 라운드에서 3번 참가자가 된다.
- 홀수번 참가자, 짝수번 참가자는 다음번에 `(자신 + 1)//2` 번 참가자가 된다.
- 이를 반복하다 보면 a, b가 같아지는 시점이 오는데 이는 이전 라운드에서 둘이 상대했기 때문에 발생한 충돌현상이다.
- 그 시점까지의 cnt가 총 라운드 횟수이다.

---

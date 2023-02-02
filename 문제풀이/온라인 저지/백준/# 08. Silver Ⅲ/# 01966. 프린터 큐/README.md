# 문제
- 플랫폼 : 백준
- 번호 : 01966
- 제목 : 프린터 큐
- 난이도 : Silver 3
- 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내기
- 문제 : <a href="https://www.acmicpc.net/problem/1966" target="_blank">링크</a>

---

# 필요 알고리즘
- 큐

---

# 풀이
```python
import sys

print = sys.stdout.write
input = sys.stdin.readline


def main():
    t = int(input())
    answer = []
    while t > 0:
        _, m = map(int, input().split())
        q = []
        counter = [0] * 10
        for idx, value in enumerate(map(int, input().split())):
            q.append((idx, value))
            counter[value] += 1
        answer.append(solution(q, counter, m))
        t -= 1
    print('\n'.join(answer))


def solution(q, counter, m):
    count = 0
    for i in range(9, 0, -1):
        while counter[i] > 0:
            item = q.pop(0)
            if item[1] == i:
                counter[i] -= 1
                count += 1
                if item[0] == m:
                    return str(count)
            else:
                q.append(item)


if __name__ == '__main__':
    main()
```
- 우선순위를 기록할 counter를 하나 만든다.
- 입력 순서대로 인덱스와 값을 묶어 튜플로 만들어 큐에 넣고, 카운터에 우선순위를 순서대로 기록한다.
- 우선순위 9번부터 1번까지, 순서대로 해당 카운터의 카운트가 0이 될때까지 반복
  - 큐의 맨 앞에서 item을 꺼낸다.
  - 우선순위가 같으면 counter의 해당 카운트를 1 감소 시키고 'count'를 증가시킨다.
  - 만약 해당 item의 index가 우리가 찾는 인덱스면 이 때의 count가 우리가 찾는 답이다.

---

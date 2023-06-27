# 문제
- 플랫폼 : 백준
- 번호 : 01362
- 제목 : 펫
- 난이도 : Bronze 2
- 각 시나리오에 대하여, 시나리오 번호와 모든 작용이 완료된 후 펫의 상태를 공백으로 구분하여 한 줄씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1362" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
# o : 적정 체중, w, 실제 체중
def print_status(o, w, count):
    if is_dead(w):
        print(f'{count} RIP')
    elif o * 0.5 < w < o * 2:
        print(f'{count} :-)')
    else:
        print(f'{count} :-(')


def is_dead(w):
    return w <= 0


count = 0
while True:
    o, w = map(int, input().split())
    if o == 0 and w == 0:
        exit(0)
    
    count += 1
    while True:
        command, n = input().split()
        n = int(n)
        if command == '#' and n == 0:
            print_status(o, w, count)
            break
        if is_dead(w):
            continue
        elif command == 'F':
            w += n
        else:
            w -= n
```

# 문제
- 플랫폼 : 프로그래머스
- 번호 : 017687
- 제목 : \[3차\] n진수 게임
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/17687" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 브루트 포스(완전 탐색)

---

# 풀이
```python
ch_arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F']

def solution(n, t, m, p):
    p -= 1 # (나머지 연산 편의를 위함. 0, 1, 2, ... m-1 순으로 따지기 쉽도록)
    cur_m = 0  # 현재 순서
    cur_t = 0  # 튜브가 몇 번째 말하는 지
    num = -1
    result = []
    while True:
        num += 1
        base_n_arr = get_base_n_arr(num, n)
        for ch in base_n_arr:
            if cur_m == p:
                cur_t += 1
                result.append(ch)
                if cur_t == t:
                    return ''.join(result)
            cur_m = (cur_m + 1) % m


def get_base_n_arr(num, n):
    if num == 0:
        return '0'
    result = []
    while num > 0:
        num, r = divmod(num, n)
        result.append(ch_arr[r])
    return ''.join(result[::-1])
```
- `get_base_n_arr` : n진수 문자열 배열로 변환
- num 을 0부터 시작하여, 위 함수를 적용해 n진수 문자열 배열로 변환
- p 는 튜브가 몇 번째 순서인지를 가리키는 값인데, 나머지 연산의 편의를 위해 1 차감한다.
- 문자열 앞부터 시작하여, 순서(cur_m)를 진행.
  - cur_m 이 p와 같은지 확인(튜브 차례인지)하고, 튜브 차례이면 cur_t 를 1 증가시킨 뒤, result 에 현재 ch 를 추가한다.
  - cur_t 가 t 와 같으면 작업을 종료하고 result 를 문자열로 join 하여 반환한다.
  - 순서는 매 순간 1씩 증가하다가, m 과 같거나 커지면 다시 0으로 돌리기 위해 나머지 m 을 처리하여 나머지로 변환한다.

---

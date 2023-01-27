# 문제
- 플랫폼 : 프로그래머스
- 번호 : 017682
- 제목 : [1차] 다트게임
- 난이도 : Level 1
- 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/17682" target="_blank">링크</a>

---

# 필요 지식
- set
- counter

---

# 풀이
## 풀이1 : 내 삽질
```python
def solution(dartResult: str):
    results = split_to_results(dartResult)
    scores = [0]

    for idx in range(len(results)):
        before = scores[idx]
        before, current = calculate_score(before, results[idx])
        scores[idx] = before
        scores.append(current)

    answer = sum(scores[1:])
    return answer


# 분리
def split_to_results(dartResult):
    results = []
    lt = 0
    rt = 1

    while lt < rt < len(dartResult):
        while rt < len(dartResult) - 1 and not dartResult[rt + 1].isnumeric():
            rt += 1
        results.append(dartResult[lt:rt + 1])
        lt = rt + 1
        rt = lt + 1

    return results


# 점수화
def calculate_score(before, result):
    current = 10 if result[0:2] == '10' else int(result[0])

    if 'D' in result:
        current **= 2
    elif 'T' in result:
        current **= 3

    if '*' in result:
        before *= 2
        current *= 2
    elif '#' in result:
        current *= -1

    return before, current
```
- 문자열을 각 점수 계산단위인 '숫자 + 보너스 + 옵션' 단위로 쪼개고, 쪼갠 문자열 단위로 계산해서 합산하는 식으로 처리했다.
- 처음 기본 점수 파싱에서 10 처리에서 고민을 좀 했다. 0번부터 1번 인덱스까지를 확인하여 '10'이면 10으로, 아니면 0번 인덱스만 파싱했다.

## 풀이2
```python
sdt = {'S': 1, 'D': 2, 'T': 3}


def solution(dartResult: str):
    units = split_to_units(dartResult)
    return calculate_sum(units)


def split_to_units(dartResult):
    return ['10' if ch == 'x' else ch for ch in dartResult.replace('10', 'x')]


def calculate_sum(units):
    scores = [0]
    for unit in units:
        if unit in sdt:
            scores[-1] **= sdt[unit]
        elif unit == '*':
            scores[-1] *= 2
            scores[-2] *= 2
        elif unit == '#':
            scores[-1] *= -1
        else:
            scores.append(int(unit))
    return sum(scores[1:])
```
- 풀이1로 풀고, 풀이2에 대한 아이디어를 다른 분들의 풀이에서 얻었다.
- 원래 있던 문자열에서 '10'을 찾으면 'k'로 변환하고, 각 문자를 하나하나 쪼개서 리스트로 저장한다.
  - 'k'가 발견되면 다시 '10'으로 저장한다.
- 이제 각 문자는 단위별로 쪼개졌다. 단위별로 순서대로 읽어가면서 값을 계산해나가면 된다.
- 이전 요소 처리, 현재 요소 처리는 배열을 이용했는데, 파이썬의 리스트는 가변 배열이기 때문에
마지막 요소 접근 시 -1로, 그 이전 요소 접근시 -2로 접근하면 된다. 이게 정말 편리하다.

---

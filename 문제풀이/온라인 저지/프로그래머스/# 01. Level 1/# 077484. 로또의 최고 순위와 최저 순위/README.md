# 문제
- 플랫폼 : 프로그래머스
- 번호 : 077484
- 제목 : 로또의 최고 순위와 최저 순위
- 난이도 : Level 1
- 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77484" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(lottos, win_nums):
    win_nums = set(win_nums)

    molu = 0
    win = 0

    for lotto in lottos:
        if lotto in win_nums:
            win += 1
        elif lotto == 0:
            molu += 1

    get_grade = lambda x: 7 - x if x >= 2 else 6
    return [get_grade(win + molu), get_grade(win)]
```
- win_nums에 접근할 때마다 O(1)로 접근할 수 있게 set으로 변환한다.
- molu : 0의 갯수 (몰?루)
- win : 당첨 갯수
- 로또 번호를 순회하며 molu와 win을 센다.
- get_grade : 입력값 x가 2 이상이면 7-x, 아니면 6을 반환한다.
- 반환 : win+molu가 최대 득점이고, win이 최저점수이므로 이를 get_grade를 통해 등수로 변환하여, 배열로 반환한다.

---

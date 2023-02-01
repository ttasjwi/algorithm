# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042862
- 제목 : 체육복
- 난이도 : Level 1
- 체육수업을 들을 수 있는 학생의 최댓값을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/042862" target="_blank">링크</a>

---

# 필요 지식
- Set
- 그리디 알고리즘

---

# 풀이
```python
def solution(n, lost, reserve):
    lost, reserve = set(lost), set(reserve)
    lost, reserve = lost - reserve, reserve - lost
    answer = 0
    for i in range(1, n + 1):
        if i not in lost:
            answer += 1
        else:
            if not reserve:
                continue
            if i - 1 in reserve:
                reserve.remove(i - 1)
                answer += 1
            elif i + 1 in reserve:
                reserve.remove(i + 1)
                answer += 1
    return answer
```
- 우선, lost와 reserve를 set으로 바꾼다. 이후 각 요소에 접근할 때 O(1)로 접근하기 위함이다.
- lost와 reserve의 교집합을 각각의 set에서 제거한다.(차집합)
- 1부터 n번째까지 순회하면서 카운팅한다.
  - lost에 없으면 answer 증가
  - lost에 있는데, reserve에 앞 번호가 있으면 reserve에서 해당 번호를 제거후 answer 증가
  - lost에 있는데, reserve에 뒷 번호가 있으면 reserve에서 해당 번호를 제거후 answer 증가

---

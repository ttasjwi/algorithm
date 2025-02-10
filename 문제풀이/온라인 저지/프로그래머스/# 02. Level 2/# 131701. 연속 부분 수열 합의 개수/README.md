# 문제
- 플랫폼 : 프로그래머스
- 번호 : 131701
- 제목 : 연속 부분 수열 합의 개수
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131701" target="_blank">링크</a>

---

# 필요 지식
- 브루트포스

---

# 풀이
```python
def solution(elements):
    sum_set = set()
    for lt in range(len(elements)):
        rt = lt
        sum = 0
        while True:
            sum += elements[rt]
            sum_set.add(sum)

            rt = (rt + 1)%len(elements)
            if lt == rt:
                break
    return len(sum_set)
```
- 시작점, 끝점을 0번 인덱스, 1번 인덱스, ... 마지막 인덱스에 두고
- 끝점를 하나씩 다음으로 이동시켜가다가 처음 지점으로 돌아올 때까지 합을 계속 set에 추가

---

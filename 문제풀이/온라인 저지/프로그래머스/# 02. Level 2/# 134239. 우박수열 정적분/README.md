# 문제
- 플랫폼 : 프로그래머스
- 번호 : 134239
- 제목 : 우박수열 정적분
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/134239" target="_blank">링크</a>

---

# 필요 지식
- 누적합
- 구현

---

# 풀이
```python
def solution(k, ranges):
    graph = [k] # 각 x 좌표에 대한 y 값
    areas = [0] # x=0에서 시작했을 때, 그 지점까지의 누적 넓이

    n = 0
    y = k
    while y > 1:
        n += 1
        if y % 2 == 0:
            y /= 2
        else:
            y *= 3
            y += 1
        graph.append(y)
        areas.append(areas[n - 1] + (graph[n - 1] + graph[n]) / 2)

    answer = []
    
    for range in ranges:
        start, end = range[0], n + range[1] # 시작, 종점
        if 0 <= start <= n and 0 <= end <= n and start <= end: # 유효한 시작/종점인지 확인
            area = areas[end] - areas[start] # 구간 넓이
            answer.append(area)
        else:
            answer.append(-1)
    return answer
```

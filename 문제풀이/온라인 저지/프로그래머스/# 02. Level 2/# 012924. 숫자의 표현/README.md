# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012924
- 제목 : 숫자의 표현
- 난이도 : Level 2
- 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12924" target="_blank">링크</a>

---

# 필요 지식
- 투 포인터

---

# 풀이
```python
def solution(n):
    lt = 1
    rt = 1
    answer = 0
    while lt <= rt <= n:
        sum = ((lt + rt) * (rt - lt + 1)) >> 1
        if sum < n:
            rt += 1
        elif sum == n:
            answer += 1
            lt += 1
            rt += 1
        else:
            lt += 1
    return answer
```
- 양 끝점을 lt, rt 로 한다.
- 숫자 합은 등차수열 합 공식을 사용하여, 연속된 수의 합을 구한다.
- 이 값이 n 보다 작다면, rt 값을 더 늘려서 합을 키운다.
- n 과 같으면 lt, rt 값을 둘 다 늘리고(합이 같아지는 것을 기대) answer 값을 증가시킨다.
- n 보다 크면, lt 값을 증가 시켜서 합을 줄인다.

---

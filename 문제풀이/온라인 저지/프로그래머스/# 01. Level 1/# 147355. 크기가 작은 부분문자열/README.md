# 문제
- 플랫폼 : 프로그래머스
- 번호 : 147335
- 제목 : 크기가 작은 부분문자열
- 난이도 : Level 1
- t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/132267" target="_blank">링크</a>

---

# 필요 지식
- 크기가 작은 부분 문자열

---

## 풀이1
```python
def solution(t: str, p: str):
    p_value, p_length = int(p), len(p)

    answer = 0
    for i in range(0, len(t) - p_length + 1):
        if int(t[i:i+p_length]) <= p_value:
            answer += 1

    return answer
```

## 풀이2
```python
def solution(t: str, p: str):
    p_length, p_value = len(p), int(p)
    return len([1 for i in range(0, len(t) - p_length + 1) if int(t[i:i + p_length]) <= p_value])

```
- 위와 구조적으로 동일하지만 좀 더 코드가 짧다.

---

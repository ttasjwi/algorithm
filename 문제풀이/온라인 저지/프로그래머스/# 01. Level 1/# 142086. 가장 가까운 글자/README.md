# 문제
- 플랫폼 : 프로그래머스
- 번호 : 142086
- 제목 : 가장 가까운 글자
- 난이도 : Level 1
- 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 각각의 결과를
리스트로 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/142086" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python

def solution(s):
    cache = {}
    results = []

    for i in range(0, len(s)):
        if s[i] not in cache:
            results.append(-1)
        else:
            results.append(i-cache[s[i]])
        cache[s[i]] = i
    return results
```
- 딕셔너리에 최근에 등장한 인덱스를 기록하면 이후 접근할 때마다 O(1)로 접근할 수 있어 효율적임을 이용

---

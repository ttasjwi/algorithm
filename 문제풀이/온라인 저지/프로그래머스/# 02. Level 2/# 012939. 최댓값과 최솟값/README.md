# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012939
- 제목 : 최댓값과 최솟값
- 난이도 : Level 2
- 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12939" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(s):
    nums = list(map(int, s.split()))
    return str(min(nums)) + ' ' + str(max(nums))
```
- 배열로 분리해서 받고, 이를 min, max로 최소/최대를 찾아 결합해 반환

---

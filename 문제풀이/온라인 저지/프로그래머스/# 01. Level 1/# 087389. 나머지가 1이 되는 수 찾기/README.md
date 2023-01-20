# 문제
- 플랫폼 : 프로그래머스
- 번호 : 087389
- 제목 : 나머지가 1이 되는 수 찾기
- 난이도 : Level 1
- n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/87389" target="_blank">링크</a>

---

# 필요 지식
- 나머지 연산

---

# 풀이
```python
def solution(n):
    x = 1
    while n%x !=1:
        x += 1
        
    return x
```
- 1부터 순서대로 증가시켜가며 나눠보고 나머지가 1이면 바로 반복을 탈출하여, x를 반환한다.

---

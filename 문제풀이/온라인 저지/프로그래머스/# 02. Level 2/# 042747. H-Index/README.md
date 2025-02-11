# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042747
- 제목 : H-Index
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42747" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```python
def solution(citations):
    citations.sort()
    l = len(citations)
    for i, citation in enumerate(citations):
        if citation >= l - i:
            return l - i
    return 0
```
| i | 피 인용횟수 | h (나보다 피 인용횟수가 같거나 많은 논문 수) |
|---|--------|-----------------------------|
| 0 | 0 | 5 (= l - i)                 |
| 1 | 1 | 4                           |
| 2 | 3 | 3                           |
| 3 | 5 | 2                           |
| 4 | 6 | 1                           |

- 정렬
- 매 인덱스에서 l - i 는 해당 논문 이상의 피인용수를 가지는 논문의 갯수이다.
- 이 값이 피 인용횟수보다 작거나 같음을 처음으로 만족할 때, 그 시점의 l-i 값이 h 가 된다.
- 만족하는 l-i 값이 없으면 h는 0 이 된다.

---

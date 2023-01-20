# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012919
- 제목 : 서울에서 김서방 찾기
- 난이도 : Level 1
- seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12919" target="_blank">링크</a>

---

# 필요 지식
- 리스트 처리

---

# 풀이
```python
from typing import List


def solution(seoul: List[str]):
    return f'김서방은 {seoul.index("Kim")}에 있다'
```
- index 메서드로 위치를 찾아 반환
- 문자열을 f문자열로 처리함

---

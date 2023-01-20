# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012943
- 제목 : 콜라츠 추측
- 난이도 : Level 1
- 문제에서 주어진 연산을 몇 번이나 반복해야 하는지 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12943" target="_blank">링크</a>

---

# 필요 지식
- 반복문

---

# 풀이
```python
def solution(num):
    count = 0

    while num != 1:
        if count == 500:
            return -1

        if num%2 == 0:
            num /= 2
        else:
            num = 3 * num + 1
        count += 1

    return count
```

---

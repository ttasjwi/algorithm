# 문제
- 플랫폼 : 프로그래머스
- 번호 : 082612
- 제목 : 부족한 금액 계산하기
- 난이도 : Level 1
- 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/82612" target="_blank">링크</a>

---

# 필요 지식
- 등차수열

---

# 풀이
```python
def solution(price, money, count):
    return max(0, price * (count + 1) * count // 2 - money)

```
- 부족한 금액이 0이거나 남는 경우에 대한 처리를 해야하는데 해당 케이스는 max 함수를 통해 0과 비교하여 큰 값을 반환하도록 처리하면 된다.

---

# 문제
- 플랫폼 : 프로그래머스
- 번호 : 150368
- 제목 : 이모티콘 할인행사
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150368" target="_blank">링크</a>

---

# 필요 지식
- DFS(중복순열)

---

# 풀이
```python
from itertools import product

def solution(users, emoticons):

    # 모든 가능한 가격 배치 (중복 순열)
    products = product([10, 20, 30, 40], repeat=len(emoticons))
    answer = [0, 0]

    for p in products:
        # 가격 배치를 p 로 했을 때, 가입자 수 / 판매액
        register_count = 0
        price_sum = 0

        for want_rate, limit_price in users:
            # 사용자 한 명이 희망 하는 비율 이상의 이모티콘을 구매했을 때의 가격 합
            user_price_sum = 0
            for price, rate in zip(emoticons, p):
                if rate >= want_rate:
                    user_price_sum += ((100 - rate) * price) // 100

            # 한도 이상일 경우, 그냥 가입하고, 아닐 경우 구매함
            if user_price_sum >= limit_price:
                register_count += 1
            else:
                price_sum += user_price_sum

        # 가입자수가 더 많아졌을 경우 가입자수/구매액을 갱신
        if register_count > answer[0]:
            answer[0] = register_count
            answer[1] = price_sum

        # 가입자수는 같은데, 구매액이 더 많아졌을 경우 갱신
        elif register_count == answer[0] and price_sum > answer[1]:
            answer[1] = price_sum

    return answer
```

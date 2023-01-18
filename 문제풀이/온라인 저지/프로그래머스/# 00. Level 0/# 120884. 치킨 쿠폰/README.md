# 문제
- 번호 : 120884
- 제목 : 치킨 쿠폰
- 난이도 : Level 0
- 시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120884)

---

# 필요 알고리즘
- 나머지 연산

---

# 풀이
```java
public class Solution {

    public int solution(int coupon) {
        int bonus;
        int bonusSum = 0;

        while ((bonus = coupon/10) > 0) {
            bonusSum += bonus;
            coupon = coupon%10 + bonus;
        }
        return bonusSum;
    }
}
```
- 최초 쿠폰량은 최초 치킨량과 같다. 일단 변수를 coupon으로 받는다.
- 반복
  - bonus 갱신 : bonus(보너스 치킨량)는 현재 보유 쿠폰량을 10으로 나눈 몫과 같다.
  - bonus 판별 : bonus가 0보다 크면 보너스 치킨 구매가 가능하므로 절차에 들어간다. 0이면 루프를 돌리지 않는다.
  - bonusSum 갱신 : bonusSum(누적 보너스 치킨량)에 bonus를 누적한다.
  - coupon 갱신 : 보너스 치킨을 획득했으므로, 사용하고 남은 보너스 쿠폰에, 보너스 갯수만큼 쿠폰을 다시 더한다.
- 이렇게 누적된 bonusSum을 반환한다.

---

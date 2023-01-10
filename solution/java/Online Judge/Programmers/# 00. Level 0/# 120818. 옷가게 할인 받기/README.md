# Programmers 120818 : 옷가게 할인 받기
- 난이도 : Level 0
- 구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120818)

---

## 풀이
```java
class Solution {
    public int solution(int price) {
        double discountPercent = getDiscountPercent(price);
        return (int) (price * (1- discountPercent));
    }

    private double getDiscountPercent(int price) {
        if (price >= 500000) return 0.2;
        else if (price >= 300000) return 0.1;
        else if (price >= 100000) return 0.05;
        else return 0;
    }
}
```
- `getDiscountPercent`를 통해 할인율을 구한다.
- 할인율을 1에서 차감하여, price에 곱해 최종 지불 금액을 반환한다.


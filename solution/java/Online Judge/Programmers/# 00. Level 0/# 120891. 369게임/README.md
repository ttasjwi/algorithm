# 문제
- 번호 : 120891
- 제목 : 369 게임
- 난이도 : Level 0
- 머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120891)

---

# 필요 알고리즘
- 나머지 연산
- 문자열 처리

---

# Python
```python
def solution(order):
    order = str(order)
    return sum(map(lambda x: order.count(x), ['3', '6', '9']))

```
- 우선 order값을 문자로 변환한다.
- map 함수를 통해 `['3', '6', '9']` 리스트의 요소들을 `order.count(...)` 로 변환한다.
- 이들의 합을 반환한다.

---

# Java

## 나머지 연산을 이용한 풀이
```java
public class Solution {

    public int solution(int order) {
        int answer = 0;

        int remainder;
        while(order>0) {
            remainder = order%10;
            if (remainder == 3 || remainder == 6 || remainder == 9) answer ++;
            order = order/10;
        }
        return answer;
    }
}
```
- 숫자를 계속해서 10으로 나누면서, 나머지를 기준으로 판단한다.
- 나머지가 3, 6, 9 중 하나면 answer를 증가

---

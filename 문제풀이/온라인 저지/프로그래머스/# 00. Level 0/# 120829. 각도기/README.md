# Programmers 120829 : 각도기
- 난이도 : Level 0
- angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120829)

---

## 풀이
```java
public class Solution {
    public int solution(int angle) {
        if (angle == 180) {
            return 4;
        } else if (angle > 90) {
            return 3;
        } else if (angle == 90) {
            return 2;
        } else {
            return 1;
        }
    }
}
```
- if, else if, else 를 통해 분기처리
- 개인적으로는 이렇게 쓰기보다 모든 조건을 명확히 명시하는 것을 좋아함.
  - else if, else 문을 읽을 때 위의 맥락을 읽어야하기 때문이다.
- 삼항 연산자를 써가면서 이 문제를 푼 사람도 있긴한데, 가독성이 매우 구려보인다.

---

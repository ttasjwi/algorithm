# 문제
- 번호 : 120871
- 제목 : 저주의 숫자 3
- 난이도 : Level 0
- 정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120871)

---

# 필요 알고리즘
- 각 자리 숫자의 합이 3의 배수이면 3의 배수이다.

---

# 풀이
```java
public class Solution {
    public int solution(int n) {
        int number = 1;

        while (n > 0) {
            if (isValidNumber(number)) {
                n --;
            }
            number ++;
        }
        return number - 1;
    }

    private boolean isValidNumber(int number) {
        int sum = 0;
        for (char ch : String.valueOf(number).toCharArray()) {
            if (ch == 51) {
                return false;
            }
            sum += ch - 48;
        }
        return (sum % 3 != 0);
    }

}
```
- 우선 숫자를 문자열로 변환한다.
- 하나의 문자라도 '3'이면 유요하지 않다.
- 숫자값을 모두 합산하여 3의 배수 여부를 판단한다.
  - 각 자리 숫자의 합이 3의 배수이면 그 숫자는 3의 배수이다.
  - 자릿수를 줄이면 약간의 시간 이득을 볼 수 있지 않을까 생각해서 이렇게 했다.

---

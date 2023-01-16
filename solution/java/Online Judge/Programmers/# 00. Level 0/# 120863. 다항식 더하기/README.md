# 문제
- 번호 : 120863
- 제목 : 다항식 더하기
- 난이도 : Level 0
- 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120863)

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```java
import java.util.StringTokenizer;

public class Solution {
    private int coefficient = 0;
    private int constantTerm = 0;

    public String solution(String polynomial) {
        calculate(polynomial);
        return makeResult();
    }

    private void calculate(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial, " + ");

        while(st.hasMoreTokens()) {
            calculateWord(st.nextToken());
        }
    }

    private void calculateWord(String word) {
        if (word.startsWith("x")) {
            coefficient += 1;
            return;
        }

        boolean isCoefficient = false;
        int value = 0;

        for (char ch : word.toCharArray()) {
            if (ch == 'x') {
                isCoefficient = true;
            } else {
                value = value * 10 + ch - 48;
            }
        }

        if (isCoefficient) {
            coefficient += value;
        } else {
            constantTerm += value;
        }
    }

    private String makeResult() {
        StringBuilder sb = new StringBuilder();

        if (coefficient != 0) {
            if (coefficient > 1) {
                sb.append(coefficient);
            }
            sb.append('x');
            if (constantTerm > 0) {
                sb.append(' ').append('+').append(' ').append(constantTerm);
            }
        } else {
            sb.append(constantTerm);
        }
        return sb.toString();
    }

}
```
- 문자열을 쪼갤 때 split보다 StringTokenizer로 쪼개는게 더 빠르다.
- 문자를 접했을 때 첫 문자가 x이면 계수가 1이라는 것이므로 바로 반환한다. (예외 케이스)
- 그 이외의 경우에는 문자를 순서대로 읽어가면서 계산한다.
- 1차항 계수, 상수항 계수 여부에 따라 분기처리를 해 가면서 결과 문자열을 만든다.

---

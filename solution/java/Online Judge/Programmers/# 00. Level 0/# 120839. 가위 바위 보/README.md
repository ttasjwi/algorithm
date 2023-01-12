# Programmers 120839 : 가위 바위 보
- 난이도 : Level 0
- 가위는 2 바위는 0 보는 5로 표현합니다.  rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 구하세요.
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120839)

---

## 풀이
```java
public class Solution {

    private static final char SCISSORS = '2';
    private static final char ROCK = '0';
    private static final char PAPER = '5';

    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for (char ch : rsp.toCharArray()) {
            switch (ch) {
                case SCISSORS -> sb.append(ROCK);
                case ROCK -> sb.append(PAPER);
                case PAPER -> sb.append(SCISSORS);
            }
        }
        return sb.toString();
    }
}
```
- switch/case문 사용

---

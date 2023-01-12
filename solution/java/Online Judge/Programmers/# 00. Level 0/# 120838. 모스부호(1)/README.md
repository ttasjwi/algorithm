# Programmers 120838 : 모스부호(1)
- 난이도 : Level 0
- 문자열 letter가 매개변수로 주어질 때, letter를 영어 소문자로 바꾼 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120838)

---

## 풀이
```java
public class Solution {

    private final Map<String, Character> morseMap = new HashMap<>(){{
            put(".-", 'a');
            put("-...", 'b');
            put("-.-.", 'c');
            put("-..", 'd');
            put(".", 'e');
            put("..-.", 'f');
            put("--.", 'g');
            put("....", 'h');
            put("..", 'i');
            put(".---", 'j');
            put("-.-", 'k');
            put(".-..", 'l');
            put("--", 'm');
            put("-.", 'n');
            put("---", 'o');
            put(".--.", 'p');
            put("--.-", 'q');
            put(".-.", 'r');
            put("...", 's');
            put("-", 't');
            put("..-", 'u');
            put("...-", 'v');
            put(".--", 'w');
            put("-..-", 'x');
            put("-.--", 'y');
            put("--..", 'z');
        }};

    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        for (String morse : letter.split(" ")) {
            sb.append(morseMap.get(morse));
        }
        return sb.toString();
    }
}
```
- 풀이는 쉬운데 Map 초기화하려고 일일이 하드코딩한게 너무 짜증났다.
- 이 문제 낸 사람 너무 미워

---

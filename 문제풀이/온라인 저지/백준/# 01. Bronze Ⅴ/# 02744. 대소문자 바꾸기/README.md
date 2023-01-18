
# \[BOJ 02744\] 대소문자 바꾸기

- 난이도 : Bronze5
- 문자열 입력받고 대소문자를 바꾸기
- 문제: <a href="https://www.acmicpc.net/problem/2744" target="_blank"> [링크]</a>

---

## 풀이
```java
public static String solution(String word) {
    StringBuffer sb = new StringBuffer();
    for (int i=0; i<word.length(); i++) {
        char ch = word.charAt(i);
        if (Character.isLowerCase(ch)) {
            sb.append(Character.toUpperCase(ch));
        } else {
            sb.append(Character.toLowerCase(ch));
        }
    }
    return sb.toString();
}
```
- 방법 1 : isLowerCase, isUpperCase 확인 후 분기처리(대 -> 소, 소 -> 대)
- 방법 2 : 아스키코드 값 활용
    - 대문자 : 65~90
    - 소문자 : 97~122

---
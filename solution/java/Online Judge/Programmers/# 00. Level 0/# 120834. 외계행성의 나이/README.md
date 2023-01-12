# Programmers 120834 : 외계행성의 나이
- 난이도 : Level 0
- 나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120834)

---

## 풀이1
```java
public class Solution1 {
    public String solution(int age) {
        char[] chars = String.valueOf(age).toCharArray();

        for (int i=0; i<chars.length; i++) {
            chars[i] = (char)(chars[i]+49);
        }

        return String.valueOf(chars);
    }
}
```
- 숫자 0은 아스키코드 48
- 소문자 a는 아스키코드 97
- 49만큼 더하여 문자로 변환하면 된다.


## 풀이2 : Stream
```java
import java.util.stream.Collectors;

public class Solution2 {
    public String solution(int age) {
        return String.valueOf(age)
                .chars()
                .mapToObj(ch -> String.valueOf((char)(ch + 49)))
                .collect(Collectors.joining());
    }
}

```

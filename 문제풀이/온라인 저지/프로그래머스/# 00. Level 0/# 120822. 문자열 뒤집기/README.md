# Programmers 120822 : 문자열 뒤집기
- 난이도 : Level 0
- my_string을 거꾸로 뒤집은 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120822)

---

## 풀이1 : StringBuilder 이용
```java
public class Solution1 {

    public String solution(String my_string) {
        return new StringBuilder(my_string)
                .reverse()
                .toString();
    }
}
```

---

## 풀이2 : 대칭 인덱스의 문자 swap
```java
public class Solution2 {

    public String solution(String my_string) {
        char[] chars = my_string.toCharArray();

        int lt = 0;
        int rt = chars.length - 1;
        char tmp;

        while (lt < rt) {
            tmp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = tmp;

            lt ++;
            rt --;
        }
        return String.valueOf(chars);
    }
}
```

---

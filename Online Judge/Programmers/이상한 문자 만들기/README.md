
# 프로그래머스 - 이상한 문자 만들기

https://programmers.co.kr/learn/courses/30/lessons/12930

---

# 풀이1 : 내 풀이

```
import java.util.StringTokenizer;

public class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();

        int index = 0;

        for (char ch : chars) {
            if (ch == ' ') {
                index = 0;
                sb.append(' ');
            } else if (index++%2 == 0) {
                if (97<=ch&& ch<=122) { // 소문자이면 대문자화
                    sb.append((char)(ch-32));
                } else {
                    sb.append(ch);
                }
            } else {
                if (65 <= ch && ch <= 90) {
                     sb.append((char)(ch+32));
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

}
```

- 문자단위로 읽어서, 공백을 발견하면 index를 0으로 초기화 및 StringBuilder에 ' ' append
- index값이 짝수이면 대문자화 (ascii code값 가산, 감산 활용) 후 append
- index값이 홀수이면 소문자화 (ascii code값 가산, 감산 활용) 후 append

---
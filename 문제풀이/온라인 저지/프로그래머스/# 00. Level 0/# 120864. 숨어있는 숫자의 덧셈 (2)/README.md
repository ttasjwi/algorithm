# 문제
- 번호 : 120864
- 제목 : 숨어있는 숫자의 덧셈 (2)
- 난이도 : Level 0
- my_string안의 자연수들의 합을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120864)

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```java
public class Solution1 {

    private int answer;

    public int solution(String my_string) {
        char[] chars = my_string.toCharArray();
        int index = 0;
        while (index < chars.length) {
            index = calculate(chars, index);
        }
        return answer;
    }

    public int calculate(char[] chars, int startIndex) {
        int value = 0;
        int index = startIndex;
        char current;

        while (index < chars.length) {
            current = chars[index];
            if (48 <= current && current < 58) {
                value = value * 10 + current - 48;
                index ++;
            } else {
                index ++;
                break;
            }
        }
        answer += value;
        return index;
    }

}
```
- 인덱스 단위로 문자열을 제어하는 연습 관점에서는 이 풀이가 좀 더 좋다. 속도도 더 빠르다.
- 속도 : 0.02ms ~ 0.04ms

---

## 풀이2
```java
public class Solution2 {

    public int solution(String my_string) {
        String[] words = my_string
                .replaceAll("[a-zA-Z]", " ")
                .split(" ");

        int sum = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                sum += Integer.parseInt(word);
            }
        }

        return sum;
    }

}
```
- replaceAll을 써서 숫자가 아닌 값들을 제거하고 파싱해도 되긴 한다. 하지만 문자열을 교체하는 비용, 숫자 파싱 비용 등에서 더 비싸다.
- 속도 : 0.10ms ~ 0.33ms

---

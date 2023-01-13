# 문제
- 번호 : 120850
- 제목 : 모음 제거
- 난이도 : Level 0
- my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120849)

---

# 필요 알고리즘
- 문자열 처리
- ASCII에서, '0'은 48, '9'는 57이다. 즉 '0'에서 48을 차감하면 0이 된다.

---

# 풀이1
```java
import java.util.Arrays;

public class Solution1 {
    public int[] solution(String my_string) {
        char[] chars = my_string.replaceAll("[a-zA-Z]", "").toCharArray();
        int[] numbers = new int[chars.length];

        for (int i=0; i<chars.length; i++) {
            numbers[i] = chars[i] - 48;
        }
        Arrays.sort(numbers);
        return numbers;
    }
}
```
- 정규표현식 필터를 이용하여 영문자를 제거하고 문자 배열로 변환한다.
- 같은 길이의 숫자 배열을 생성한다.
- 영문자를 숫자로 환산하여 숫자 배열에 저장한다. (48 차감)
- 정렬 후 반환한다.

---

# 풀이2
```java
public class Solution2 {
    public int[] solution(String my_string) {
        return my_string.chars()
                .filter(ch -> 48 <= ch && ch < 58)
                .map(ch -> ch - 48)
                .sorted()
                .toArray();
    }
}
```
- Stream을 사용
- 물론 시간복잡도, 공간복잡도 면에서 손해다.

---

# 문제
- 번호 : 120888
- 제목 : 중복된 문자 제거
- 난이도 : Level 0
- my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120888)

---

# 필요 알고리즘
- 문자의 아스키코드 값

---

# 풀이1
```java
public class Solution1 {
    public String solution(String my_string) {
        boolean spaceIncluded = false;
        boolean[] lowerChecked = new boolean[26];
        boolean[] upperChecked = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for (char ch : my_string.toCharArray()) {
            if (ch == ' ') {
                if (!spaceIncluded) {
                    sb.append(ch);
                    spaceIncluded = true;
                }
                continue;
            }

            if (65 <= ch && ch <= 90) {
                if (!upperChecked[ch-65]) {
                    sb.append(ch);
                    upperChecked[ch-65] = true;
                }
                continue;
            }

            if (97 <= ch && ch <= 122) {
                if (!lowerChecked[ch-97]) {
                    sb.append(ch);
                    lowerChecked[ch-97] = true;
                }
            }
        }
        return sb.toString();
    }
}
```
- 공백 체크 변수, 대소문자 체크배열을 각각 선언
- 체크되지 않은 문자는 StringBuilder에 append하고, 체크한다.
- 이 방식을 사용하면 Set을 사용하지 않아도 되고 빠르다. 한 테스트 케이스를 실행할 때마다 0.02ms ~ 0.07ms 정도 걸린다.
  - 다만 코드가 엄청 길어진다...
  - 아스키 코드 값을 따져줘야한다.

---

# 풀이2
```java
import java.util.stream.Collectors;

public class Solution2 {
    public String solution(String my_string) {
        return my_string.chars()
                .distinct()
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }
}
```
- Stream 사용
- 내부적으로 모든 문자를 Character로 박싱하고, 이들을 중복처리한 뒤, 다시 각각을 문자열로 변환하고,
조인하는 과정에서 객체 생성 비용이 비쌀 것이다.
- 실제로 한 테스트 케이스를 실행할 때마다 3ms정도 걸린다.

---

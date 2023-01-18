# 문제
- 번호 : 120893
- 제목 : 대문자와 소문자
- 난이도 : Level 0
- 대문자는 소문자로 소문자는 대문자로 변환한 문자열 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120893)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
def solution(my_string: str):
    return my_string.swapcase()

```
- `swapcase()` : 문자열의 대소문자를 반대로 뒤집는다.

---

# Java
```java
public class Solution {

    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();

        for (int ch : my_string.toCharArray()) {
            if (97 <= ch && ch <= 122) {
                sb.append((char) (ch - 32));
            } else {
                sb.append((char) (ch + 32));
            }
        }
        return sb.toString();
    }
}
```
- 97 ~ 122 : a-z
- 65 ~ 90 : A-Z
- 해당 값들의 차이는 32이므로 이를 기준으로 값들을 변환하여 StringBuilder에 append한다.

---

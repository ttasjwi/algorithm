# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120911
- 제목 : 문자열 정렬하기 (2)
- 난이도 : Level 0
- my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120911)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
def solution(my_string: str):
    return ''.join(sorted(my_string.lower()))

```
- 소문자화 -> 정렬 -> join

---

# Java
```java
import java.util.Arrays;

public class Solution {
    public String solution(String my_string) {
        char[] chars = my_string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
```
- 소문자화 -> 배열로 변경 -> 정렬 -> 문자열로 만들기

---

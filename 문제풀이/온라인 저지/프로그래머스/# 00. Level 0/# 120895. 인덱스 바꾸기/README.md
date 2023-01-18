# 문제
- 번호 : 120895
- 제목 : 인덱스 바꾸기
- 난이도 : Level 0
- 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120895)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
def solution(my_string, num1, num2):
    chars = list(my_string)
    chars[num1], chars[num2] = chars[num2], chars[num1]
    return ''.join(chars)
```
- 문자열을 리스트로 변환하고 이를 chars라 하자.
- 튜플을 이용해 두 인덱스의 요소를 swap한다.
- 다시 문자열로 결합한다.

---

# Java
```java
public class Solution {

    public String solution(String my_string, int num1, int num2) {
        char[] chars = my_string.toCharArray();
        chars[num1] = my_string.charAt(num2);
        chars[num2] = my_string.charAt(num1);
        return String.valueOf(chars);
    }
}
```
- toCharArray 를 통해 문자열 배열을 반환받는다.
- 두 요소를 서로 바꾼다.
- 배열을 다시 문자열로 만들어 반환한다.

---

# 문제
- 번호 : 120892
- 제목 : 암호 해독
- 난이도 : Level 0
- cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120892)

---

# 필요 알고리즘
- 문자열 처리

---

# Python

```python
def solution(cipher, code):
    return cipher[code-1::code]


```
- Python의 문자열 슬라이싱을 활용
  - `[시작점:끝(포함x):증가량]`

---

# Java
```java
public class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        for (int i = code - 1; i < cipher.length(); i += code) {
            sb.append(cipher.charAt(i));
        }
        return sb.toString();
    }
}
```
- 반복문을 통해 code의 배수만큼 인덱스를 증가시켜가며 StringBuilder에 append
- 최종 결과물을 문자열로 반환한다.

---

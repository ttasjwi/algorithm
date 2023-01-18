# 문제
- 번호 : 120885
- 제목 : 이진수 더하기
- 난이도 : Level 0
- 두 이진수 문자열의 합을 이진수 문자열로 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120885)

---

# 필요 알고리즘
- 나머지 연산

---

# 풀이
```java
public class Solution {
    public String solution(String bin1, String bin2) {
        return Integer.toBinaryString(
                Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2)
        );
    }
}
```
- 순수 java 메서드 만으로 빠르게 답을 구할 수 있다.
- 이걸 순수하게 수작업으로 구현하는 것에 대해서는 '디지털 논리회로' 과목을 학습할 필요가 있을 듯 하다.

---

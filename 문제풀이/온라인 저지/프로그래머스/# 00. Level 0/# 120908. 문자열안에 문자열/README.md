# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120908
- 제목 : 문자열 안에 문자열
- 난이도 : Level 0
- str1 안에 str2가 있다면 1을 없다면 2를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120908)

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```python
def solution(str1, str2):
    return 1 if str2 in str1 else 2

```
```java
public class Solution {

    public int solution(String str1, String str2) {
        return (str1.contains(str2))
                ? 1
                : 2;
    }

}
```
- Python은 in 연산자, Java는 contains 메서드를 이용하여 판단하면 된다.

---

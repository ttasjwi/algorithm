# 문제
- 번호 : 120853
- 제목 : 컨트롤 제트
- 난이도 : Level 0
- 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120853)

---

# 필요 알고리즘
- 스택
- 문자열 처리

---

# 풀이
```java
public class Solution {
    public int solution(String s) {

        int before = 0;
        int answer = 0;

        for (String word : s.split(" ")) {
            if (word.equals("Z")) {
                answer -= before;
            } else {
                before = Integer.parseInt(word);
                answer += before;
            }
        }
        return answer;
    }
}
```
- 굳이 Stack을 안 써도 변수 하나를 추가로 선언해서 처리하면 충분하다.

---

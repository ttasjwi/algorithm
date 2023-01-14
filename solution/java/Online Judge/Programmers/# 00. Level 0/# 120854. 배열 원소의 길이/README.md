# 문제
- 번호 : 120854
- 제목 : 배열 원소의 길이
- 난이도 : Level 0
- strlist 각 원소의 길이를 담은 배열을 retrun
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120854)

---

# 필요 알고리즘
- 문자열

---

# 풀이
```java
public class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for (int i=0; i<strlist.length; i++) {
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}
```

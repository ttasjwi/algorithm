# 문제
- 번호 : 120869
- 제목 : 외계어 사전
- 난이도 : Level 0
- spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120869)

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```java
public class Solution {
    public int solution(String[] spells, String[] dic) {
        int count;
        
        for (String word : dic) {
            count = spells.length;
            for (String spell : spells) {
                if (word.contains(spell)) {
                    count--;
                }
            }
            if (count == 0) {
                return 1;
            }
        }
        return 2;
    }

}
```
- 각 단어별로 순회
- count : 전체 spells 요소의 갯수
- 각 word가 각 spell을 포함하고 있는 지 순서대로 판단하여, count를 차감한다.
- count가 0이 되면 모두 포함한 단어이므로 1을 바로 반환한다.
- 끝까지 순회해도 count가 0인 경우를 못 찾으면 2를 반환한다.

---

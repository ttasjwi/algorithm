# 문제
- 번호 : 120886
- 제목 : A로 B 만들기
- 난이도 : Level 0
- before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120886)

---

# 필요 알고리즘
- 카운터 배열을 통한 카운팅

---

# 풀이
```java
public class Solution {

    public int solution(String before, String after) {
        int[] counter = new int[26];

        for (char ch : before.toCharArray()) {
            counter[ch-97]++;
        }
        for (char ch : after.toCharArray()) {
            if (counter[ch-97] == 0) {
                return 0;
            } else {
                counter[ch-97] --;
            }
        }

        return 1;
    }

}
```
- before의 각 문자에 순서대로 접근해서 카운터에 갯수 누적
- after의 각 문자에 순서대로 접근해서 카운터에서 갯수 차감
  - 차감하기 전에, 카운트가 0인 경우, 갯수가 안 맞거나 존재하지 않는 문자인 경우이므로 0을 return한다.
- 마지막까지 순회에 성공하면 갯수가 맞으므로 1을 return

---

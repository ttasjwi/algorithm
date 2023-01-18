# 문제
- 번호 : 120887
- 제목 : k의 개수
- 난이도 : Level 0
- i부터 j까지 k가 몇 번 등장하는지 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120887)

---

# 필요 알고리즘
- 나머지 연산

---

# 풀이
```java
public class Solution {

    public int solution(int i, int j, int k) {
        int answer = 0;

        int number;
        for (int n = i; n<= j; n++) {

            number = n;

            while (number > 0) {
                if (number%10 == k) {
                    answer ++;
                }
                number = number/10;
            }
        }

        return answer;
    }

}
```
- 순회하는 숫자마다 10으로 계속 나눠서, 그 나눈 나머지를 기준으로 숫자의 등장 횟수를 카운팅한다.

---

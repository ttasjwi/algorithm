# 문제
- 번호 : 120868
- 제목 : 삼각형의 완성조건 (2)
- 난이도 : Level 0
- 두 변의 길이가 담긴 배열 sides이 매개변수로 주어질 때, 나머지 한 변이 될 수 있는 정수의 개수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120868)

---

# 필요 알고리즘
- 없음

---

# 풀이
```java
public class Solution {

    public int solution(int[] sides) {
        int otherMax = (sides[0] >= sides[1]) ? sides[0] : sides[1];

        int number = 1;
        int sum = sides[0] + sides[1] + 1;
        int max = (number >= otherMax) ? number : otherMax;

        int answer = 0;

        // 조건 : max < sum - max

        while (true) {
            if (max < sum - max) {
                answer ++;
            } else if (max == number){
                break;
            }
            number ++;
            sum++;
            max = (number >= otherMax) ? number : otherMax;
        }

        return answer;
    }

}
```
- 제일 긴 변의 길이를 max라고 하고, 모든 변의 길이의 합을 sum이라고 하자.
- 결국 조건은 `max < sum - max`를 만족시키면 answer를 증가시키고, 그렇지 않으면서 max == number를 만족하면 break한다.
- number를 증가시키고, sum, max를 갱신한다.

---

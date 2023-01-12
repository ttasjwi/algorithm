# Programmers 120837 : 개미 군단
- 난이도 : Level 0
- 사냥감의 체력 hp가 매개변수로 주어질 때, 사냥감의 체력에 딱 맞게 최소한의 병력을 구성하려면 몇 마리의 개미가 필요한지
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120837)

---

## 풀이
```java
public class Solution {

    private static final int[] attacks = new int[]{5, 3, 1};

    public int solution(int hp) {
        int answer = 0;

        for (int attack : attacks) {
            answer += hp / attack;
            hp = hp % attack;

            if (hp == 0) {
                break;
            }
        }
        return answer;
    }
}
```
- 아주 전형적인 그리디 알고리즘의 문제이다.
- 공격력이 강력한 개미로 최대한의 HP를 제거하고, 그 다음 강한 개미들로 남은 HP를 나머지에 맞게 제거할 수 있다.

---

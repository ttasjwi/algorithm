# Programmers 120841 : 점의 위치 구하기
- 난이도 : Level 0
- 좌표 dot이 사분면 중 어디에 속하는지 1, 2, 3, 4 중 하나를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120841)

---

## 풀이
```java
public class Solution {

    public int solution(int[] dot) {
        int x = dot[0];
        int y = dot[1];

        if (x>0 && y>0) return 1;
        else if (x<0 && y>0) return 2;
        else if (x<0 && y<0) return 3;
        else return 4;
    }
}

```
- if문/else 문으로 분기치면 표현식을 몇 개 덜 적어도 되긴 하는데, 가독성 면에서 차라리 이렇게 명시적으로 표기하는게 더 좋은 것 같다.
- 트레이드 오프에서, 가독성을 선택했다.

---

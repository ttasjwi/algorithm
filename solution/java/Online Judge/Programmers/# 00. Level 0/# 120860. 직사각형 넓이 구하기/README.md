# 문제
- 번호 : 120860
- 제목 : 직사각형 넓이 구하기
- 난이도 : Level 0
- 배열 dots가 매개변수로 주어질 때, 직사각형의 넓이를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120860)

---

# 필요 알고리즘
- 기하

---

# 풀이
```java
public class Solution {

    public int solution(int[][] dots) {
        return calculateWidth(dots) * calculateHeight(dots);
    }

    private int calculateWidth(int[][] dots) {
        int xDiff1 = Math.abs(dots[0][0] - dots[1][0]);
        int xDiff2 = Math.abs(dots[2][0] - dots[1][0]);
        return Math.max(xDiff1, xDiff2);
    }

    private int calculateHeight(int[][] dots) {
        int yDiff1 = Math.abs(dots[0][1] - dots[1][1]);
        int yDiff2 = Math.abs(dots[2][1] - dots[1][1]);
        return Math.max(yDiff1, yDiff2);
    }
}

```
- width 계산 : 두 이웃한 변들 각각의 x 좌표 차를 비교하여, 큰 쪽이 가로 길이
- height 계산 : 두 이웃한 변들 각각의 y 좌표 차를 비교하여, 큰 쪽이 세로 길이

---

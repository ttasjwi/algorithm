# 문제
- 번호 : 120861
- 제목 : 캐릭터의 좌표
- 난이도 : Level 0
- 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 `[x, y]`를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120861)

---

# 필요 알고리즘
- 방향배열 사용

---

# 풀이
```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<String, int[]> DIRECTIONS = new HashMap<>() {{
        put("up", new int[]{0, 1});
        put("down", new int[]{0, -1});
        put("left", new int[]{-1, 0});
        put("right", new int[]{1, 0});
    }};

    public int[] solution(String[] keyInputs, int[] board) {
        int xMax = board[0] / 2;
        int xMin = -xMax;
        int yMax = board[1] / 2;
        int yMin = -yMax;

        int[] answer = new int[2];

        for (String keyInput : keyInputs) {
            int[] direction = DIRECTIONS.get(keyInput);

            int nextX = answer[0] + direction[0];
            int nextY = answer[1] + direction[1];

            if (xMin <= nextX && nextX <= xMax && yMin <= nextY && nextY <= yMax) {
                answer[0] = nextX;
                answer[1] = nextY;
            }
        }
        return answer;
    }
}
```
- nextX : 다음 x좌표 후보
- nextY : 다음 y좌표 후보
- 후보가 유효성에 적합하면 후보를 다음 좌표로 변경한다.

---

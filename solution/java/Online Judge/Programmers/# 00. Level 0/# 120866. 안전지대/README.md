# 문제
- 번호 : 120866
- 제목 : 안전지대
- 난이도 : Level 0
- board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120866)

---

# 필요 알고리즘

## 인접 방향 배열
![direction.jpg](imgs/direction.jpg)

- 어떤 한 좌표를 기준으로 인접한 방향의 인덱스와의 좌표차(행, 열) 배열로 선언하면 편리한 경우가 많다.
  - 배열을 문제의 경우 row, column을 사용하는 것이 편리하고,
  수학적인 좌표평면 문제의 경우 x, y를 기준으로 방향으로의 좌표차를 지정하는 것이 좋다.
- 인접 방향 배열을 만들어두면 각 방향으로 접근할 때 반복문을 통해 순회할 수 있기 때문에 각 방향 접근의 중복코드를
제거할 수 있다.
- 주의 : **인접한 방향의 인덱스로 접근하기 전에 인덱스 범위를 벗어나진 않는지 체크할 필요가 있다.**

---

# 풀이
```java
public class Solution {

    private static final int[] DIRECTION_ROW = {0, 1, 1, 1, 0, -1, -1, -1}; // 동 동남 남 남서 서 북서 북 북동
    private static final int[] DIRECTION_COLUMN = {1, 1, 0, -1, -1, -1, 0, 1}; // 동 동남 남 남서 서 북서 북 북동

    public int solution(int[][] board) {
        int rowLength = board.length;
        int columnLength = board[0].length;

        int nearRow;
        int nearColumn;
        int warningCount = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (board[i][j] == 1) {
                    warningCount++;
                    board[i][j] = 2;

                    for (int k = 0; k < 8; k++) {
                        nearRow = i + DIRECTION_ROW[k];
                        nearColumn = j + DIRECTION_COLUMN[k];

                        if (0 <= nearRow && nearRow < rowLength && 0 <= nearColumn && nearColumn < columnLength) {
                            if (board[nearRow][nearColumn] == 0) {
                                warningCount++;
                                board[nearRow][nearColumn] = 2;
                            }
                        }
                    }
                }
            }
        }

        return rowLength * columnLength - warningCount;
    }

}
```
- 8방 방향배열을 선언한다.
- 이차원 배열을 순회하면서 1을 만나면 해당 좌표가 지뢰라는 뜻이다.
  - 해당 좌표를 2로 갱신하고, 위험 카운트를 증가시킨다.
  - 인접한 8방을 순회하면서 0인 지점을 2로 갱신하고 전부 위험 체크한다.
- 이를 배열 끝까지 반복하면 위험한 지역의 갯수가 모두 카운팅되므로, 배열의 전체 인덱스 갯수에서 위험 카운트를 제하면 구하는 답이다.

---

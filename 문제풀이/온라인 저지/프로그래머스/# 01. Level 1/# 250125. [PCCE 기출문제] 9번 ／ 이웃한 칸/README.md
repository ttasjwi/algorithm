# 문제
- 플랫폼 : 프로그래머스
- 번호 : 250125
- 제목 : \[PCCE 기출문제\] 9번 / 이웃한 칸
- 난이도 : Level 1
- 이웃한 칸들 중 같은 색으로 칠해져 있는 칸의 개수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/250125" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```java
class Solution {

    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(String[][] board, int h, int w) {
        int maxHeight = board.length;
        int maxWidth = board[0].length;

        int[][] counter = new int[maxHeight][maxWidth];

        int nr;
        int nc;
        for (int r = 0; r < maxHeight; r++) {
            for (int c = 0; c < maxWidth; c++) {
                for (int k = 0; k < 4; k++) {
                    nr = r + directions[k][0];
                    nc = c + directions[k][1];

                    if ((0 <= nr && nr < maxHeight) && (0 <= nc && nc < maxWidth) && board[nr][nc].equals(board[r][c])) {
                        counter[r][c]++;
                    }
                }
            }
        }
        return counter[h][w];
    }
}
```
- 각 행, 열 별로 좌우상하 동등한 요소의 갯수를 구하면 됨

---

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

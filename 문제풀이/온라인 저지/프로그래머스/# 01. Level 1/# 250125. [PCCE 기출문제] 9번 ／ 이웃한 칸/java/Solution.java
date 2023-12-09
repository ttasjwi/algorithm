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

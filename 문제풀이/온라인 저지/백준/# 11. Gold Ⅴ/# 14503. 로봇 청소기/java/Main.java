import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int n = readInt();
        int m = readInt();
        int r = readInt();
        int c = readInt();
        int d = readInt();

        int[][] board = new int[n][m];

        for (int i = 0; i<n; i++) {
            for (int j =0; j<m; j++) {
                board[i][j] = readInt();
            }
        }

        int answer = 0;

        int cnt, nd, nr, nc;

        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
                answer ++;
            }
            cnt = 4;
            nd = d;

            while (cnt > 0) {
                nd = (nd + 3) % 4;
                nr = r + DIRECTIONS[nd][0];
                nc = c + DIRECTIONS[nd][1];

                if ((0 <= nr && nr < n) && (0<= nc && nc < m) && board[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    d = nd;
                    break;
                }
                cnt --;
            }

            if (cnt == 0) {
                nd = (d + 2) % 4;
                nr = r + DIRECTIONS[nd][0];
                nc = c + DIRECTIONS[nd][1];

                if ((0 <= nr && nr < n) && (0<= nc && nc < m) && board[nr][nc] != 1) {
                    r = nr;
                    c = nc;
                } else {
                    break;
                }
            }
        }
        System.out.print(answer);
    }

    private static int readInt() throws IOException {
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

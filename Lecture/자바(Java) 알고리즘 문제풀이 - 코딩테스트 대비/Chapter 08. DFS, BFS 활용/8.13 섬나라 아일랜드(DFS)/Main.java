import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DIRECTION_X = {1, 1, 0, -1, -1, -1, 0, 1}; // 동, 남동, 남, 남서, 서, 북서, 북, 북동
    private static final int[] DIRECTION_Y = {0, 1, 1, 1, 0, -1, -1, -1}; // 동, 남동, 남, 남서, 서, 북서, 북, 북동

    private static int n; // 격자판의 가로 세로
    private static int[][] board; // 격자판 정보

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }

    private static void solution() {
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (board[y][x] == 1) {
                    answer++;
                    dfs(x, y); // 섬을 찾으면 깊이 탐색을 하여 전부 방문처리한다
                }
            }
        }
    }

    private static void dfs(int startX, int startY) {
        board[startY][startX] = 0; // 방문 처리

        int nextX, nextY;
        for (int i = 0; i < 8; i++) {
            nextX = startX + DIRECTION_X[i];
            nextY = startY + DIRECTION_Y[i];

            if (isValidPosition(nextX, nextY) && board[nextY][nextX] == 1) {
                dfs(nextX, nextY);
            }
        }
    }

    private static boolean isValidPosition(int x, int y) {
        return (1 <= x && x <= n) && (1 <= y && y <= n);
    }

}

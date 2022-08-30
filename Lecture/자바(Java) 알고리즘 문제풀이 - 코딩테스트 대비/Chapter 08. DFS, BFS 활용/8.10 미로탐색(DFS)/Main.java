import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동 남 서 북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1}; // 동 남 서 북
    private static int[][] grid = new int[8][8]; // 2 : 지나간 경로다 1 : 막혀있다. 0 : 지나갈 수 있다.
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        dfs(1, 1);
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 7; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }

    private static void dfs(int row, int column) {
        if (row == 7 && column == 7) { // 도착지점이면 answer 증가
            answer++;
            return;
        }
        grid[row][column] = 2; // 현재 방문한 위치는 방문했으므로 2로 체크한다.
        int nearRow, nearColumn;
        for (int i = 0; i < 4; i++) {
            nearRow = row + DIRECTION_Y[i];
            nearColumn = column + DIRECTION_X[i];
            if (isValidPosition(nearRow, nearColumn) && grid[nearRow][nearColumn] == 0) {
                dfs(nearRow, nearColumn); // 방문한다
            }
        }
        grid[row][column] = 0; // 이 지점은 탐색이 완료됐으므로 0으로 되돌린다.
    }

    private static boolean isValidPosition(int column, int row) {
        return (1 <= column && column <= 7) && (1 <= row && row <= 7);
    }

}

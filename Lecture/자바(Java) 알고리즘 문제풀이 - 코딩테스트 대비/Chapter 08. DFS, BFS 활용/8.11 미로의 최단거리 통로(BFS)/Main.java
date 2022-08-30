import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동 남 서 북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1}; // 동 남 서 북
    private static int[][] grid = new int[8][8];
    private static int[][] dis = new int[8][8];

    public static void main(String[] args) throws IOException {
        input();
        int answer = bfs();
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

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        dis[1][1] = 0;
        grid[1][1] = 2; // 방문
        queue.offer(new Point(1, 1));

        Point current;
        int nearX, nearY;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int j = 0; j < 4; j++) {
                nearX = current.x + DIRECTION_X[j];
                nearY = current.y + DIRECTION_Y[j];
                if (nearY == 7 && nearX == 7) return dis[current.y][current.x] + 1;
                if (isValidPosition(nearX, nearY) && grid[nearY][nearX] == 0) {
                    grid[nearY][nearX] = 2;
                    dis[nearY][nearX] = dis[current.y][current.x] + 1;
                    queue.offer(new Point(nearX, nearY));
                }
            }
        }
        return -1;
    }

    private static boolean isValidPosition(int column, int row) {
        return (1 <= column && column <= 7) && (1 <= row && row <= 7);
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

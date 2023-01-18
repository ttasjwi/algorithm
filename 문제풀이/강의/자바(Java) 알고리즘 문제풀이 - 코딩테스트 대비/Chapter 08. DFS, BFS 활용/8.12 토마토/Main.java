import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동 남 서 북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1}; // 동 남 서 북

    private static int m; // 가로
    private static int n; // 세로
    private static int[][] store; // 토마토 저장 상태

    public static void main(String[] args) throws IOException {
        input();
        int answer = bfs();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        store = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                store[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (store[i][j] == 1) {
                    queue.offer(new Point(j, i));
                }
            }
        }

        Point current;
        int nearX, nearY;
        while(!queue.isEmpty()) {
            current = queue.poll();
            for (int j=0; j<4; j++) {
                nearX = current.x + DIRECTION_X[j];
                nearY = current.y + DIRECTION_Y[j];
                if (isValidPosition(nearX, nearY) && store[nearY][nearX] == 0) {
                    store[nearY][nearX] = store[current.y][current.x] + 1;
                    queue.offer(new Point(nearX, nearY));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (store[i][j] > max) {
                    max = store[i][j];
                }
                if (store[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max -1; // 모두 익었을 경우. 최댓값-1이 모두 숙성하는데 소요되는 날짜
    }

    private static boolean isValidPosition(int x, int y) {
        return (0 <= x && x < m) && (0 <= y && y < n);
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

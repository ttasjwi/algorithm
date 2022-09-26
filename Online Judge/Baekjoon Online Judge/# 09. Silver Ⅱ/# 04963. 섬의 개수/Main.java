import java.io.IOException;

public class Main {

    private static int w;
    private static int h;

    private static final int[] DX = {1, 1, 0, -1, -1, -1, 0, 1}; // 동, 동남, 남, 남서, 서, 북서, 북, 북동
    private static final int[] DY = {0, 1, 1, 1, 0, -1, -1, -1}; // 동, 동남, 남, 남서, 서, 북서, 북, 북동

    private static int[][] graph;
    private static StringBuilder sb = new StringBuilder();
    private static int count;

    public static void main(String[] args) throws IOException {

        while (true) {
            w = readInt();
            h = readInt();

            if (w == 0 && h ==0) {
                break;
            }
            graph = new int[h][w];
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    graph[y][x] = readInt();
                }
            }
            process();
        }
        System.out.print(sb);
    }

    private static void process() {
        count = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (graph[y][x] == 1) {
                    count++;
                    graph[y][x] = 0;
                    dfs(x, y);
                }
            }
        }
        sb.append(count).append('\n');
    }

    private static void dfs(int x, int y) {
        int nx, ny;
        for (int i = 0; i < 8; i++) {
            nx = x + DX[i];
            ny = y + DY[i];

            if ((0 <= nx && nx < w) && (0 <= ny && ny < h) && graph[ny][nx] == 1) {
                graph[ny][nx] = 0;
                dfs(nx, ny);
            }
        }
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return value;
            } else {
                value = value * 10 + input - 48;
            }
        }
    }
}

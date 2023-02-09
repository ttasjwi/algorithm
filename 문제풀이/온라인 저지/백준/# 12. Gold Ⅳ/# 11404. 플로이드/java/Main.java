import java.io.IOException;

public class Main {

    private static final int inf = 10_000_000;
    private static int n, m, a, b, c, alt;

    private static int[][] dis;

    public static void main(String[] args) throws IOException {
        n = readInt();
        m = readInt();
        dis = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = i == j ? 0 : inf;
            }
        }

        for (int i = 0; i < m; i++) {
            a = readInt() - 1;
            b = readInt() - 1;
            c = readInt();

            if (dis[a][b] > c) {
                dis[a][b] = c;
            }
        }

        for (int m = 0; m < n; m++) {
            for (int s = 0; s < n; s++) {
                if ((s == m) || dis[s][m] == inf) {
                    continue;
                }
                for (int e = 0; e < n; e++) {
                    if ((s == e) || (m == e) || dis[m][e] == inf) {
                        continue;
                    }
                    alt = dis[s][m] + dis[m][e];
                    if (dis[s][e] > alt) {
                        dis[s][e] = alt;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] line : dis) {
            for (int n : line) {
                if (n == inf) {
                    sb.append('0').append(' ');
                } else {
                    sb.append(n).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

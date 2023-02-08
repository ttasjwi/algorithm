import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static final int INF = 25_000_000;
    private static int n, m, w, alt;
    private static boolean updated;
    private static ArrayList<Edge> edges;
    private static int[] dis;

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        int tc = readInt();
        for (int i = 0; i < tc; i++) {
            n = readInt();
            m = readInt();
            w = readInt();

            dis = new int[n + 1];
            edges = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                dis[j] = INF;
            }
            int s, e, t;
            for (int j = 0; j < m + w; j++) {
                s = readInt();
                e = readInt();
                t = readInt();

                if (j < m) {
                    edges.add(new Edge(s, e, t));
                    edges.add(new Edge(e, s, t));
                } else {
                    edges.add(new Edge(s, e, -t));
                }
            }
            bf(answer);
        }
        System.out.print(answer);
    }

    private static void bf(StringBuilder sb) {
        for (int i = 0; i < n; i++) {
            updated = false;
            for (Edge edge : edges) {
                alt = dis[edge.s] + edge.t;
                if (dis[edge.e] > alt) {
                    updated = true;
                    dis[edge.e] = alt;
                    if (i == n - 1) {
                        sb.append("YES").append("\n");
                        return;
                    }
                }
            }
            if (!updated) {
                sb.append("NO").append("\n");
                return;
            }
        }
    }

    private static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    private static class Edge {
        int s;
        int e;
        int t;

        public Edge(int s, int e, int t) {
            this.s = s;
            this.e = e;
            this.t = t;
        }
    }
}

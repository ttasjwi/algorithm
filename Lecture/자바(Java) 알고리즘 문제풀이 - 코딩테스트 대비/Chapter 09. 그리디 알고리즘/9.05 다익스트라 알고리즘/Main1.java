import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 느린 다익스트라
 */
public class Main1 {

    private static int n; // 노드 수
    private static int m; // 간선 수

    private static int[] dis;
    private static boolean[] checked;
    private static final ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        String answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        checked = new boolean[n+1];
        dis = new int[n+1];
        Arrays.fill(dis, INF);

        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());

        int start, end, cost;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, cost));
        }
        br.close();
    }

    private static String solution() {
        slowDijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=n; i++) {
            sb.append(i).append(" : ");
            if (dis[i] < INF) {
                sb.append(dis[i]);
            } else {
                sb.append("impossible");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private static void slowDijkstra() {
        dis[1] = 0;
        for (int i=1; i<=n-1; i++) {
            int minNode = findUncheckedMinimumNode(); // 체크하지 않은 방문비용이 최소인 노드를 찾음
            checked[minNode] = true;
            for (Edge edge : graph.get(minNode)) {
                if (dis[edge.end] > dis[minNode] + edge.cost) {
                    dis[edge.end] = dis[minNode] + edge.cost;
                }
            }
        }
    }

    private static int findUncheckedMinimumNode() {
        int min = INF;
        int minIndex = 0; // 기본적으로 사용하지 않는 0번 인덱스를 기본값으로 한다.
        for (int j=1; j<=n; j++) {
            if (!checked[j] && dis[j] < min) {
                min = dis[j];
                minIndex = j;
            }
        }
        return minIndex;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 느린 다익스트라
 */
public class Main2 {

    private static int n; // 노드 수
    private static int m; // 간선 수

    private static int[] dis;
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
        fastDijkstra();
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

    private static void fastDijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[1] = 0;
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if (dis[current.pos] < current.cost) {
                // dis 배열 저장값이 더 작다는 것은 이미 앞에서 더 좋은 방문 방법이 반영됐다는 것이므로 계산하지 않는다.
                continue;
            }
            // 여기까지 통과하면 current 노드의 최소방문비용은 확정된다.

            for (Edge edge : graph.get(current.pos)) {
                if (dis[edge.end] > dis[current.pos] + edge.cost) {
                    dis[edge.end] = dis[current.pos] + edge.cost;
                    pq.offer(new Node(edge.end, dis[edge.end]));
                }
            }
        }
    }

}

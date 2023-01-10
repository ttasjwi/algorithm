import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int v;
    private static int e;

    private static ArrayList<ArrayList<Edge>> graph;

    private static boolean[] checked; // 방문 배열

    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i=0; i<=v; i++) graph.add(new ArrayList<>());

        checked = new boolean[v+1];

        int node1, node2, cost;
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(node1).add(new Edge(node2, cost));
            graph.get(node2).add(new Edge(node1, cost));
        }
        br.close();
    }

    private static int solution() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        int answer = 0;
        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if (checked[current.end]) continue;

            checked[current.end] = true; // 방문 처리
            answer += current.cost;

            for (Edge edge : graph.get(current.end)) {
                if (!checked[edge.end]) pq.offer(edge);
            }
        }
        return answer;
    }

}

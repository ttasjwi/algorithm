import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int v; // 도시 수

    private static int e; // 도로의 갯수

    private static Edge[] edges; // 간선들

    private static int[] parent; // 부모

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

        edges = new Edge[e];
        parent = new int[v+1];
        for (int i=1;i<=v; i++) parent[i] = i;

        int node1, node2, cost;
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(node1, node2, cost);
        }
        br.close();
    }

    private static int solution() {
        Arrays.sort(edges); // 비용을 기준으로 오름차순 정렬

        int answer = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (findParent(edge.node1) != findParent(edge.node2)) {
                unionParent(edge.node1, edge.node2);
                answer += edge.cost;
                cnt ++; // 계산 완료된 간선의 갯수를 센다.
                if (cnt == v-1) break; // 간선의 갯수가 v-1개이면 모든 도시가 연결된 상황
            }
        }
        return answer;
    }

    private static int findParent(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else if (rootA > rootB) {
            parent[rootA] = rootB;
        }
    }


}

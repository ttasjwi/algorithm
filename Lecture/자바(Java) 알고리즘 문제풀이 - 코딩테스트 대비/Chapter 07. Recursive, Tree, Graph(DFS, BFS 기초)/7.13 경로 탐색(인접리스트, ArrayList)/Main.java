import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static int n;
    private static ArrayList<ArrayList<Integer>> graph;

    private static boolean[] visited;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        n = readInt(); // 정점의 개수
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];

        int m = readInt();
        int p1, p2;
        for (int i=0; i<m; i++) {
            p1 = readInt();
            p2 = readInt();
            graph.get(p1).add(p2);
        }
        solution();
        System.out.print(answer);
    }

    private static void solution() {
        visited[1] = true;
        DFS(1);
    }

    private static void DFS(int v) {
        if (v == n) {
            answer ++;
            return;
        }
        for (int nv : graph.get(v)) {
            if (!visited[nv]) {
                visited[nv] = true;
                DFS(nv);
                visited[nv] = false;
            }
        }
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + input - 48;
            }
        }
    }

}

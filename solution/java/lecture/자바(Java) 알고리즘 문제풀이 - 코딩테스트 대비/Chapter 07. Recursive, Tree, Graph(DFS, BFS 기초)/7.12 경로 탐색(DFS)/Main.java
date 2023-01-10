import java.io.IOException;

public class Main {

    private static int n;
    private static boolean[][] graph; // 인접행렬

    private static boolean[] visited;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        n = readInt(); // 정점의 개수
        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        int m = readInt();
        int p1, p2;
        for (int i=0; i<m; i++) {
            p1 = readInt();
            p2 = readInt();
            graph[p1][p2] = true;
        }
        solution();
        System.out.print(answer);
    }

    private static void solution() {
        visited[1] = true;
        DFS(1);
    }

    private static void DFS(int i) {
        if (i == n) {
            answer ++;
            return;
        }
        for (int j=1; j<=n; j++) {
            if (!visited[j] && graph[i][j]) {
                visited[j] = true;
                DFS(j);
                visited[j] = false;
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

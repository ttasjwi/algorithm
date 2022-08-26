import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int n; // 정점의 갯수
    private static ArrayList<ArrayList<Integer>> graph; // 인접 리스트
    private static boolean[] checked; // 방문 배열

    private static int[] dis; // 거리 배열

    public static void main(String[] args) throws IOException {
        n = readInt(); // 정점의 개수
        graph = new ArrayList<>();
        dis = new int[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        checked = new boolean[n + 1];

        int m = readInt();
        int p1, p2;
        for (int i = 0; i < m; i++) {
            p1 = readInt();
            p2 = readInt();
            graph.get(p1).add(p2);
        }
        String answer = solution();
        System.out.print(answer);
    }

    private static String solution() {
        BFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(dis[i]).append(' ');
        }
        return sb.toString();
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        dis[v] = 0;
        checked[v] = true;
        queue.offer(v);

        int current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int next : graph.get(current)) { // 인접한 요소들을 탐색한다.
                if (!checked[next]) {
                    checked[next] = true;
                    dis[next] = dis[current] + 1;
                    queue.offer(next);
                }
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

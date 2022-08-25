import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DIRECTION = new int[]{-1, 1, 5};
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 10000;
    private static final boolean[] visited = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = BFS(s,e);
        System.out.print(answer);
    }

    private static int BFS(int s, int e) {
        int level = 0;
        if (s == e) return 0;
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int size;
        int current, next;
        while(!queue.isEmpty()) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                current = queue.poll();
                for (int j=0; j<3; j++) {
                    next = current + DIRECTION[j];
                    if (next == e) return level +1;
                    if (RANGE_MIN <= next && next <= RANGE_MAX && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

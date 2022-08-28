import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    private static int n; // 동전의 종류 갯수
    private static int m; // 거슬러 줄 금액
    private static Integer[] units; // 각 동전의 금액단위
    private static boolean checked[]; // 체크여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        units = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            units[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(units, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());
        checked = new boolean[m+1];
        br.close();
        int answer = bfs();
        System.out.print(answer);
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int next;
        for (int unit : units) {
            next = m - unit;
            if (next == 0) return 1;
            if (next > 0) {
                checked[next] = true;
                queue.offer(next);
            }
        }
        int count = 1; // 화폐 수
        int size;
        while(!queue.isEmpty()) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                int current = queue.poll();
                for (int unit : units) {
                    next = current - unit;
                    if (next == 0) return count +1;
                    if (next > 0 && !checked[next]) {
                        checked[next] = true;
                        queue.offer(next);
                    }
                }
            }
            count ++;
        }
        return -1;
    }

}

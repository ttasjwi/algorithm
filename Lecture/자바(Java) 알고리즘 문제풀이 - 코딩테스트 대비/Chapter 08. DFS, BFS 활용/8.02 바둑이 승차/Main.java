import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 바둑이 수
    private static int c; // 무게 제한
    private static int[] weights; // 무게들
    private static int answer = Integer.MIN_VALUE; // 무게 제한을 넘지 않는 최대 무게

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        weights = new int[n];

        for (int i=0; i<n; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        dfs(0, 0);
        System.out.print(answer);
    }

    private static void dfs(int index, int sum) {
        if (sum > c) return; // 초과하면 더 따져봤자 조건에 부합할 가능성이 없다.
        if (index == n) {
            if (sum > answer) answer = sum;
            return;
        }
        dfs(index + 1, sum+ weights[index]); // 현재 index에 대응하는 바둑이를 포함하는 경우
        dfs(index + 1, sum); // 현재 index에 대응하는 바둑이를 포함하지 않는 경우
    }

}

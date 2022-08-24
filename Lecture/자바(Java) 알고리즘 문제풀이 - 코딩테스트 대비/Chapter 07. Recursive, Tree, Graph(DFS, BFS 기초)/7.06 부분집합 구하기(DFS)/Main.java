import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder answer = solution();
        System.out.print(answer);
    }
    private static StringBuilder solution() {
        used = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        dfs(1, sb);
        return sb;
    }

    private static StringBuilder dfs(int i, StringBuilder sb) {
        if (i > n) { // n보다 큰 숫자는 포함 대상이 아니다.
            boolean emptySet = true;
            for (int j=1; j<=n; j++) {
                if (used[j]) {
                    emptySet = false;
                    sb.append(j).append(' ');
                }
            }
            if (!emptySet) sb.append('\n');
            return sb;
        }
        used[i] = true; // 자기 자신을 포함한 상황
        dfs(i+1, sb);
        used[i] = false; // 자기 자신을 포함하지 않은 상황
        dfs(i+1, sb);
        return sb;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 동전의 종류 갯수
    private static int m; // 거슬러줄 금액
    private static int coins[]; // 동전의 단위
    private static int dp[]; // i원을 만드는데 드는  최소 동전의 갯수

    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coins = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        br.close();
    }

    private static int solution() {
        dp = new int[m+1];
        for (int i=1; i<=m; i++) dp[i] = 501;

        for (int coin : coins) {
            for (int i=coin; i<=m; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return dp[m];
    }

}

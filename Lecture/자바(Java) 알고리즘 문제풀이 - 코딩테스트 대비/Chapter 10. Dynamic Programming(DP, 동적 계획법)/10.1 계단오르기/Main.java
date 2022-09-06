import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
        int answer = solution();
        System.out.print(answer);
    }

    private static int solution() {
        dp = new int[n+1];
        return dp(n);
    }

    private static int dp(int k) {
        if (dp[k] > 0) {
            return dp[k];
        }
        if (k==1) {
            return dp[k] = 1;
        }
        if (k==2) {
            return dp[k] = 2;
        }
        return dp[k] = dp(k-2) + dp(k-1);
    }
}

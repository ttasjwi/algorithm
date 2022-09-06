import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int answer = solution(n);
        System.out.print(answer);
    }

    private static int solution(int n) {
        int[] dp = new int[n+2];
        return dp(n+1, dp);
    }

    private static int dp(int k, int[] dp) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=k; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[k];
    }
}

import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static int n;
    private static final int[] dp;

    static {
        dp = new int[100001];
        Arrays.fill(dp, -1);
    }

    public static void main(String[] args) throws IOException {
        n = readInt();
        int k = readInt();
        System.out.println(dp(k));
    }

    private static int dp(int k) {
        if (dp[k] >= 0) return dp[k];
        if (n >= k) return dp[k] = n - k;
        if (k == 1) return dp[k] = 1;
        if (k % 2 == 0) return Math.min(k - n, dp(k / 2) + 1);
        return dp[k] = Math.min(dp(k - 1), dp(k + 1)) + 1;
    }

    private static int readInt() throws IOException {
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }


}

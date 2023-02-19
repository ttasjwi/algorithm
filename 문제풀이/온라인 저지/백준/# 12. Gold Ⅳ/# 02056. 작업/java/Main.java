import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] dp = new int[n + 1];
        int answer = 0;
        int t, s, p, max;
        for (int i = 0; i < n; i++) {
            t = readInt();
            s = readInt();
            if (s == 0) {
                dp[i + 1] = t;
            } else {
                max = 0;
                for (int j = 0; j < s; j++) {
                    p = readInt();
                    max = Math.max(dp[p], max);
                }
                dp[i + 1] = max + t;
            }
            answer = Math.max(answer, dp[i + 1]);
        }
        System.out.print(answer);
    }

    private static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

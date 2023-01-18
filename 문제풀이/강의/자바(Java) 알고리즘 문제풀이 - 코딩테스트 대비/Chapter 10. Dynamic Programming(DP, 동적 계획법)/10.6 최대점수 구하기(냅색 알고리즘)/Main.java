import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 문제 갯수
        int m = Integer.parseInt(st.nextToken()); // 최대 시간

        int[] dp = new int[m+1]; // t분이 주어졌을 때 얻을 수 있는 최대 점수

        int problemScore, probleTime;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            problemScore = Integer.parseInt(st.nextToken());
            probleTime = Integer.parseInt(st.nextToken());

            for (int t=m; t>=probleTime; t--) { // 거꾸로 돌아야 중복을 회피할 수 있다.
                dp[t] = Math.max(dp[t], dp[t-probleTime] + problemScore);
            }
        }
        int answer = dp[m];
        System.out.print(answer);
    }

}

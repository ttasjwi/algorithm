import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n; // n개의 자연수
    private static int[] numbers; // 숫자들

    private static int[] dp; // dp 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int answer = solution();
        System.out.print(answer);
    }

    private static int solution() {
        dp[0] = 1;
        int max;
        int answer = Integer.MIN_VALUE;
        for (int i=1; i<n; i++) {
            max = 0; // 앞의 dp 값 중 최댓값
            for (int j=0; j<i; j++) {
                if (numbers[j] < numbers[i] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1; // dp[i]는 앞 dp 최댓값 + 1이다.
            answer = Math.max(answer, dp[i]); // 모든 dp[i] 값 중 최댓값이 정답
        }
        return answer;
    }
}

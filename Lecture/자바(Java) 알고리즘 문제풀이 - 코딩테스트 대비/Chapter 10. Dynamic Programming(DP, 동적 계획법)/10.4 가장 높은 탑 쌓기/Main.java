import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 벽돌의 수
    private static Brick[] bricks; // 벽돌들

    private static int[] dp; // i번째 벽돌을 맨 밑의 요소로 했을 때의 최대 높이

    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bricks = new Brick[n];
        dp = new int[n];

        StringTokenizer st;
        int area, height, weight;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            area = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            bricks[i] = new Brick(area, height, weight);
        }
        br.close();
    }

    private static int solution() {
        Arrays.sort(bricks);

        int maxHeight; // 그 위에 놓을 수 있는 최대 높이
        int answer = 0;
        for (int i=0; i<n; i++) {
            maxHeight = 0;
            for (int j=0; j<i; j++) {
                if (bricks[j].weight < bricks[i].weight && maxHeight < dp[j]) {
                    maxHeight = dp[j];
                }
            }
            dp[i] = maxHeight + bricks[i].height; // 그 벽돌을 제일 위에 뒀을 때의 최대 높이
            answer = Math.max(answer, dp[i]); // 최대 높이
        }
        return answer;
    }

}

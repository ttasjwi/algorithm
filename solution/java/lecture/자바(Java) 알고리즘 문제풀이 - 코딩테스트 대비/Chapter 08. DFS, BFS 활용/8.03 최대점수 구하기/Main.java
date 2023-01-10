import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 문제 수
    private static int m; // 제한 시간
    private static int[] scores; // 점수들
    private static int[] times; // 소요 시간들
    private static int answer = Integer.MIN_VALUE; // 제한 시간 내에 얻을 수 있는 최대 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        scores = new int[n];
        times = new int[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            scores[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dfs(0, 0, 0);
        System.out.print(answer);
    }

    private static void dfs(int index, int scoreSum, int timeSum) {
        if (timeSum > m) return; // 초과하면 더 따져봤자 조건에 부합할 가능성이 없다.
        if (index == n) {
            answer = Math.max(answer, scoreSum);
            return;
        }
        dfs(index + 1, scoreSum + scores[index], timeSum + times[index]); // 현재 index에 대응하는 문제를 풀 경우
        dfs(index + 1, scoreSum, timeSum); // 현재 index에 대응하는 문제를 풀지 않을 경우
    }

}

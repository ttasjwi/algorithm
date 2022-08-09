import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 숫자의 수
        int m = Integer.parseInt(st.nextToken()); // 특정 숫자

        int[] sums = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i=1; i<=n; i++) {
            int input = Integer.parseInt(st.nextToken());
            sums[i] = sums[i-1] + input; // 누적합
        }
        int answer = solution(sums, n, m);
        System.out.print(answer);
    }

    private static int solution(int[] sums, int n, int m) {
        int start = 1;

        int count = 0; // 조건에 부합하는 부분수열의 갯수
        int rangeSum = 0; // 범위 합

        for (int end = 1; end<=n; end ++) {
            rangeSum = sums[end] - sums[start-1];

            if (rangeSum == m) {
                count++;
            }
            while (rangeSum >=m) {
                rangeSum = sums[end] - sums[(++start) - 1];
                if (rangeSum == m) {
                    count ++;
                }
            }
        }
        return count;
    }
}

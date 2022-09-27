import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 숫자의 수
        int m = Integer.parseInt(st.nextToken()); // 특정 숫자

        int[] sums = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=1; i<=n; i++) {
            int input = Integer.parseInt(st.nextToken());
            sums[i] = sums[i-1] + input; // 누적합
        }
        int answer = solution(sums, n, m);
        System.out.print(answer);
    }

    private static int solution(int[] sums, int n, int m) {
        int start = 1;
        int end = 1;

        int count = 0; // 조건에 부합하는 부분수열의 갯수
        int rangeSum = 0; // 범위 합

        while (start <=n) {
            if (end >n) {
                start++;
                end = start;
                continue;
            }
            rangeSum = sums[end] - sums[start-1];
            if (rangeSum == m) { // 범위 합이 일치하면
                count ++;
                start ++; // 그 이상의 범위는 계속 더 해봐야 더 클 수밖에 없다
                end = start;
            } else if (rangeSum > m) { // 값이 더 크면 해당 범위에서 계속 찾아봐야 답이 안 나온다.
                start ++; // 윈도우를 다음 범위로 이동
                end = start;
            } else {
                end ++; // 값이 부족하므로 윈도우의 길이를 늘려본다.
            }
        }
        return count;
    }
}

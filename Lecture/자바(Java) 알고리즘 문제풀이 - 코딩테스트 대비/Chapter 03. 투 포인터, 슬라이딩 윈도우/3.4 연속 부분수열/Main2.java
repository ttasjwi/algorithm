import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 숫자의 수
        int m = Integer.parseInt(st.nextToken()); // 특정 숫자

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(arr, n, m);
        System.out.print(answer);
    }

    private static int solution(int[] arr, int n, int m) {
        int count = 0;
        int sum = 0;
        int start = 0;
        for (int end=0; end<n; end ++) {
            sum += arr[end];
            if (sum == m) {
                count ++;
            }
            while (sum >= m) {
                sum -= arr[start++];
                if (sum == m) {
                    count ++;
                }
            }
        }
        return count;
    }
}

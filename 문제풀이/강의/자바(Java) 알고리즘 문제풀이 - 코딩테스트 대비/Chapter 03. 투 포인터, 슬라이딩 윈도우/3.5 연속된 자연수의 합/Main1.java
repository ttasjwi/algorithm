import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int answer = solution(n);
        System.out.print(answer);
    }

    private static int solution(int n) {
        int m = n / 2 + 1;
        int[] numbers = new int[m];
        for (int i = 0; i < m; i++) {
            numbers[i] = i + 1;
        }

        int count = 0;
        int start = 0;
        int sum = numbers[start];
        for (int end = 1; end<m; end ++) {
            sum += numbers[end];
            if (sum == n) {
                count++;
                sum -= numbers[start++];
            }
            while (sum >=n) {
                sum -= numbers[start++];
                if (sum == n) {
                    count ++;
                }
            }
        }

        return count;
    }
}

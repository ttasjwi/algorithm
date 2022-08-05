import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int answer = solution(N);
        System.out.print(answer);
    }

    private static int solution(int n) {
        int count = 1; // 2는 소수
        for (int i=3; i<=n; i++) {
            if (isPrimeNumber(i)) {
                count ++;
            }
        }
        return count;
    }

    private static boolean isPrimeNumber(int i) {
        for (int j = 2; j<=Math.sqrt(i); j++) {
            if (i %j == 0) {
                return false;
            }
        }
        return true;
    }
}

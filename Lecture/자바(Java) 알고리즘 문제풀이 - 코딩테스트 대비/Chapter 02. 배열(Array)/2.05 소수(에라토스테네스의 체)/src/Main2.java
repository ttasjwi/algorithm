import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int answer = solution(N);
        System.out.print(answer);
    }

    private static int solution(int n) {
        boolean[] isCompositeNumber = new boolean[n+1];

        for (int i=2; i<=n; i++) {
            if (!isCompositeNumber[i]) { // 소수이면
                for (int j= i*2; j<=n; j += i) {
                    isCompositeNumber[j] = true;
                }
            }
        }
        int count = 0;
        for (int i=2; i<=n; i++) {
            if (!isCompositeNumber[i]) {
                count ++;
            }
        }
        return count;
    }
}

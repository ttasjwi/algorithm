import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 32;

        int[][] counter = new int[n + 1][m + 1];

        String line;
        boolean flag;
        boolean current;
        int sum;
        int i, j;
        for (i = 1; i <= n; i++) {
            line = br.readLine();
            flag = i % 2 != 0;
            for (j = 1; j <= m; j++) {
                current = line.charAt(j - 1) == 'W';
                counter[i][j] = counter[i - 1][j] + counter[i][j - 1] - counter[i - 1][j - 1];
                if (flag != current) {
                    counter[i][j] += 1;
                }
                flag = !flag;

                if (i >= 8 && j >= 8) {
                    sum = counter[i][j] - counter[i - 8][j] - counter[i][j - 8] + counter[i - 8][j - 8];
                    if (sum > 32) sum = 64 - sum;
                    if (answer > sum) answer = sum;
                }
            }
        }
        System.out.print(answer);
    }

}

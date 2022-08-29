import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] combinations;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        combinations = new int[n+1][n+1];

        int answer = combination(n, r);
        System.out.print(answer);
    }

    private static int combination(int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == n || r == 0) {
            return combinations[n][r] = combinations[n][0] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][r] = combinations[n][n-r] = n;
        }
        return combinations[n][r] = combinations[n][n-r] = combination(n-1, r-1) + combination(n-1, r);
    }
}

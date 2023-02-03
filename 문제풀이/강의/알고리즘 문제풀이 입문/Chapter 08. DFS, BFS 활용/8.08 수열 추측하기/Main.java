import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n; // 제일 큰 수
    private static int f; // 찾는 수
    private static int[][] combinations;
    private static int[] selectedNumbers; // 선택된 숫자들

    private static boolean[] checked;

    private static boolean found;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        combinations = new int[n][n];
        checked = new boolean[n+1];
        selectedNumbers = new int[n];
        String answer = solution();
        System.out.print(answer);
    }

    private static String solution() {
        sb = new StringBuilder();
        dfs(0, 0);
        return sb.toString();
    }

    public static void dfs(int index, int sum) {
        if (found) return;
        if (sum > f) {
            return;
        }
        if (index == n) {
            if (sum == f) {
                found = true;
                for (int selectedNumber : selectedNumbers) {
                    sb.append(selectedNumber).append(' ');
                }
                return;
            }
            return;
        }
        for (int number=1; number<=n; number++) {
            if (!checked[number]) {
                checked[number] = true;
                selectedNumbers[index] = number;
                dfs(index+1, sum + number * combination(n-1,index));
                checked[number] = false;
            }
        }
    }

    private static int combination (int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == n || r == 0) {
            return combinations[n][r] = combinations[n][n-r] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][r] = combinations[n][n-r] = n;
        }
        return combinations[n][r] = combinations[n][n-r] = combination(n-1, r-1) + combination(n-1, r);
    }
}

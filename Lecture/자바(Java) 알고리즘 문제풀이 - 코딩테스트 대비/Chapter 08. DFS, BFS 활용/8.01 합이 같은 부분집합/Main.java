import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] numbers;
    private static int totalSum = 0;
    private static boolean yesFlag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            totalSum += numbers[i];
        }
        dfs(0, 0);
        String answer = (yesFlag) ? "YES" : "NO";
        System.out.print(answer);
    }

    private static void dfs(int index, int sum) {
        if (yesFlag) return; // 더 탐색할 필요 없이 무조건 YES다.
        if (sum > totalSum) return; // 초과하면 더 구해봤자 정답이 아니다.
        if (index == n) {
            if (totalSum == 2 * sum) {
                yesFlag =  true; // YES가 되는 조건을 찾았다.
                return;
            }
            return;
        }
        dfs(index + 1, sum+ numbers[index]); // 현재 index에 저장된 값을 포함하는 경우
        dfs(index + 1, sum); // 현재 index에 저장된 값을 포함하지 않는 경우
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 숫자의 갯수
    private static int m; // 몇개 뽑니
    private static int[] numbers; // 숫자들
    private static int[] selectedNumbers; // 선택된 숫자들
    private static boolean[] checked; // 체크 여부

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        checked = new boolean[n];

        m = Integer.parseInt(st.nextToken());
        selectedNumbers = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        String answer = solution();
        System.out.print(answer);
    }

    private static String solution() {
        sb = new StringBuilder();
        dfs(0);
        return sb.toString();
    }

    private static void dfs(int index) {
        if (index == m) {
            for (int selectedNumber : selectedNumbers) {
                sb.append(selectedNumber).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i=0; i<n; i++) {
            if (!checked[i]) { // 선택되지 않았다면
                checked[i] = true;
                selectedNumbers[index] = numbers[i]; // 선택
                dfs(index + 1);
                checked[i] = false;
            }
        }
    }
}

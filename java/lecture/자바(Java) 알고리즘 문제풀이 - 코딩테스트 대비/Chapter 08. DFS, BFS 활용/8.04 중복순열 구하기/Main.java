import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 1~n까지
    private static int m; // m개

    private static StringBuilder sb;

    private static int[] numbers; // 숫자들을 순서대로 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String answer = solution();
        System.out.print(answer);
    }

    private static String solution() {
        numbers = new int[m]; // m개의 자리를 마련함
        sb = new StringBuilder();
        dfs(0);
        return sb.toString();
    }

    private static void dfs(int index) {
        if (index == m) {
            for (int number : numbers) sb.append(number).append(' ');
            sb.append('\n');
            return;
        }
        for (int i=1; i<=n; i++) {
            numbers[index] = i;
            dfs(index + 1);
        }
    }

}

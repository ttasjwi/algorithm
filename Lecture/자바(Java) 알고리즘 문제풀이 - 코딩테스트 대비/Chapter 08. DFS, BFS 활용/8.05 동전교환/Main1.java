import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1 {

    private static int n; // 동전의 종류 갯수
    private static int m; // 거슬러 줄 금액
    private static Integer[] units; // 각 동전의 금액단위
    private static int answer = Integer.MAX_VALUE; // 거슬러 줄 동전의 최소 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        units = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            units[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(units, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());
        br.close();

        dfs(m, 0);
        System.out.print(answer);
    }

    private static void dfs(int money, int count) {
        if (money < 0) return;
        if (count >= answer) return;
        if (money == 0) {
            answer = count;
            return;
        }
        for (int i=0; i<n; i++) {
            dfs(money-units[i], count + 1);
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 가위 1, 바위 2, 보 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] b = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        String answer = solution(a, b);
        System.out.print(answer);
    }

    private static String solution(int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; i++) {

            if (a[i] == b[i]) {
                // 비길 때
                sb.append('D').append('\n');
            } else if (a[i] == 1 && b[i] == 3) {
                // 가위 보 -> A가 이길 때
                sb.append('A').append('\n');
            } else if (a[i] == 2 && b[i] == 1) {
                // 바위 가위 -> A가 이길 때
                sb.append('A').append('\n');
            } else if (a[i] == 3 && b[i] == 2) {
                // 보 바위 -> A가 이길 때
                sb.append('A').append('\n');
            } else {
                // B가 이길 때
                sb.append('B').append('\n');
            }
        }
        return sb.toString();
    }

}

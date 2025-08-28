import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] numbers1 = new int[n];
        for(int i=0; i<n; i++) {
            numbers1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        int[] numbers2 = new int[m];
        for(int i=0; i<m; i++) {
            numbers2[i] = Integer.parseInt(st.nextToken());
        }
        String answer = solution(numbers1, n, numbers2, m);
        System.out.print(answer);
    }

    private static String solution(int[] numbers1, int n, int[] numbers2, int m) {
        StringBuilder sb = new StringBuilder();
        int p1=0; //numbers1의 포인터
        int p2=0; //numbers2의 포인터

        while(p1 < n || p2 < m) {
            if (p1 == n) {
                sb.append(numbers2[p2++]).append(' ');
                continue;
            }
            if (p2 == m) {
                sb.append(numbers1[p1++]).append(' ');
                continue;
            }
            if (numbers1[p1] <= numbers2[p2]) {
                sb.append(numbers1[p1++]).append(' ');
            } else {
                sb.append(numbers2[p2++]).append(' ');
            }
        }
        return sb.toString();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            numbers1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] numbers2 = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++) {
            numbers2[i] = Integer.parseInt(st.nextToken());
        }

        String answer = solution(numbers1, numbers2, n, m);
        System.out.print(answer);
    }

    private static String solution(int[] numbers1, int[] numbers2, int n, int m) {
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(numbers1);
        Arrays.sort(numbers2);

        StringBuilder sb = new StringBuilder();

        while (p1<n && p2 <m) {
            if (numbers1[p1] == numbers2[p2]) {
                sb.append(numbers1[p1]).append(' ');
                p1 ++;
                p2 ++;
            } else if (numbers1[p1] < numbers2[p2]) {
                p1 ++;
            } else {
                p2 ++;
            }
        }
        return sb.toString();
    }
}

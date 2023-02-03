import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 캐시의 크기
        int[] numbers = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i=1; i<=n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        String answer = solution(numbers, n);
        System.out.print(answer);
    }

    private static String solution(int[] numbers, int n) {
        int[] copy = numbers.clone();
        Arrays.sort(copy);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            if (numbers[i] != copy[i]) {
                sb.append(i).append(' ');
            }
        }
        return sb.toString();
    }
}

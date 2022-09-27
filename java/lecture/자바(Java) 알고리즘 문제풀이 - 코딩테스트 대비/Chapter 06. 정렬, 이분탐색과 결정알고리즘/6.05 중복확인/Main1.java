import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 캐시의 크기
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        String answer = solution(numbers, n);
        System.out.print(answer);
    }

    private static String solution(int[] numbers, int n) {
        Arrays.sort(numbers);
        for (int i=0; i<n-1; i++) {
            if (numbers[i] == numbers[i+1]) {
                return "D";
            }
        }
        return "U";
    }

}

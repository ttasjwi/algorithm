import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        String answer = solution(N);
        System.out.print(answer);
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[n];
        numbers[0] = 1;
        numbers[1] = 1;

        sb.append(numbers[0]).append(' ').append(numbers[1]).append(' ');

        for (int i=2; i<numbers.length; i++) {
            numbers[i] = numbers[i-2] + numbers[i-1];
            sb.append(numbers[i]).append(' ');
        }
        return sb.toString();
    }
}

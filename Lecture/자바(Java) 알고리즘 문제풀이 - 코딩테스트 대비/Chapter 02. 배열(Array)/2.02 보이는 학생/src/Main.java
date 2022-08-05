import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(numbers);
        System.out.print(answer);
    }

    private static int solution(int[] numbers) {
        int count = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > maxValue) {
                count ++;
                maxValue = number;
            }
        }
        return count;
    }
}

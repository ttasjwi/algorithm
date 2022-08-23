import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder answer = solution(n);
        System.out.print(answer);
    }

    private static StringBuilder solution(int n) {
        numbers = new int[n+1];
        recursive(n);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            sb.append(numbers[i]).append(' ');
        }
        return sb;
    }

    private static int recursive(int i) {
        if (numbers[i] > 0) {
            return numbers[i];
        }
        if (i ==  1 || i == 2) {
            return numbers[i] = 1;
        }
        return numbers[i] = recursive(i-2) + recursive(i-1);
    }

}

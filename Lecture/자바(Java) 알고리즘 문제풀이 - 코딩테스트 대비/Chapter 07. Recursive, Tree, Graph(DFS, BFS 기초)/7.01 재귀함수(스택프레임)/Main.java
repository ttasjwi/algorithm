import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        String answer = solution(n);
        System.out.print(answer);
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        return recursive(n, sb).toString();
    }

    private static StringBuilder recursive(int n, StringBuilder sb) {
        if (n > 1) {
            recursive(n-1, sb);
        }
        sb.append(n).append(' ');
        return sb;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder answer = solution(n);
        System.out.print(answer);
    }

    private static StringBuilder solution(int n) {
        StringBuilder sb = new StringBuilder();
        return recursive(n, sb);
    }

    private static StringBuilder recursive(int n, StringBuilder sb) {
        if (n==0) {
            return sb;
        }
        recursive(n/2, sb);
        sb.append(n%2);
        return sb;
    }

}

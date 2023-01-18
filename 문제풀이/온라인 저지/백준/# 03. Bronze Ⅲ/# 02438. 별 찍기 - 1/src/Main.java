import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=N; i++) {
            for (int j=0; j<i; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

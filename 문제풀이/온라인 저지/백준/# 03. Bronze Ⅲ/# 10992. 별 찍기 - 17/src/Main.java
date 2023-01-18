import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int line = 1;

        StringBuilder sb = new StringBuilder()
                .append(" ".repeat(N-line))
                .append('*')
                .append('\n');
        line ++;

        while (line <N) {
            if (line == N) {
                sb.append("*".repeat(2*N-1));
                break;
            }
            sb.append(" ".repeat(N-line))
                    .append("*")
                    .append(" ".repeat(2*(line)-3))
                    .append("*")
                    .append("\n");
            line ++;
        }
        System.out.print(sb);
    }
}

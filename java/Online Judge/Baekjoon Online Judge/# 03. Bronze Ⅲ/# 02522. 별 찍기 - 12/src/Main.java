import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int starCount = 1;

        while(starCount < N) {
            sb.append(" ".repeat(N-starCount))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount++; // 별의 갯수 증가
        }
        while(starCount > 0) {
            sb.append(" ".repeat(N-starCount))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount--; // 별의 갯수 감소
        }

        System.out.print(sb);


    }
}

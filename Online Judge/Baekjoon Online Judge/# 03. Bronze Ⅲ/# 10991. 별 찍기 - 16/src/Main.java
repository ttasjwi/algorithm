import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int frontSpace = N-1;

        while(frontSpace >=0) {
            sb.append(" ".repeat(frontSpace))
                    .append("* ".repeat(N-frontSpace))
                    .append('\n');
            frontSpace--; // 앞의 공백 제거
        }

        System.out.print(sb);


    }
}

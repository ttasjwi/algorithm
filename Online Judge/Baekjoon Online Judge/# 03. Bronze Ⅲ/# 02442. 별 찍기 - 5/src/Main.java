import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int spaceCount = N-1;

        while(spaceCount>=0) {
            sb.append(" ".repeat(spaceCount))
                    .append("*".repeat(2*(N-spaceCount)-1))
                    .append('\n');
            spaceCount--;
        }
        System.out.print(sb);
    }
}

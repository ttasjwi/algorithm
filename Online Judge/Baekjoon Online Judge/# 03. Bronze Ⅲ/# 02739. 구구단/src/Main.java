import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.readLine().charAt(0) - '0';
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=9; i++) {
            sb.append(n).append(" * ").append(i).append(" = ").append(n*i).append('\n');
        }
        System.out.println(sb);
    }
}

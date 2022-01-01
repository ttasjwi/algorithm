import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        while (N>0) {
            for (int i=0; i<N; i++) {
                sb.append('*');
            }
            sb.append('\n');
            N --;
        }

        System.out.print(sb);

    }
}

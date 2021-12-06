import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int L = Integer.parseInt(br.readLine());
        br.close();

        final int t = (L%5==0)? L/5 : L/5 + 1;

        System.out.println(t);
    }
}

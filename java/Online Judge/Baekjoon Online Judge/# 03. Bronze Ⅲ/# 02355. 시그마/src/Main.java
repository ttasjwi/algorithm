import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        if (a>b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        long result = ((a+b) * (b-a+1))/ 2;
        System.out.println(result);
    }
}
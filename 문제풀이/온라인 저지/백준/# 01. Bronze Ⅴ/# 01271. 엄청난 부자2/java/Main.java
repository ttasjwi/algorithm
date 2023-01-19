import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger answer1 = n.divide(m);
        BigInteger answer2 = n.mod(m);

        StringBuilder sb = new StringBuilder();
        sb.append(answer1).append('\n').append(answer2);
        System.out.print(sb);
    }

}

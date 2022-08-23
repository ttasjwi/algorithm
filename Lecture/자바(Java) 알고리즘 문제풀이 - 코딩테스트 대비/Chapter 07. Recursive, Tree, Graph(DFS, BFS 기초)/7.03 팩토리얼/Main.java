import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        BigInteger answer = recursive(n);
        System.out.print(answer);
    }

    private static BigInteger recursive(int n) {
        if (n==0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(recursive(n-1));
    }

}

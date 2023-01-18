import java.math.BigInteger;

public class Solution3 {

    private BigInteger[] factorials;

    public int solution(int balls, int share) {
        factorials = new BigInteger[balls+1];
        return combination(balls, share);
    }

    private int combination(int n, int r) {
        return factorial(n)
                .divide(factorial(n-r))
                .divide(factorial(r))
                .intValue();
    }

    private BigInteger factorial(int n) {
        if (factorials[n] != null) {
            return factorials[n];
        }
        if (n == 0 || n == 1) {
            return factorials[n] = BigInteger.ONE;
        }
        return factorials[n] = BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}

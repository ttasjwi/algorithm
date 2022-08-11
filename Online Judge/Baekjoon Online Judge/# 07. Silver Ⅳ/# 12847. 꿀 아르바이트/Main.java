import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        int[] numbers = new int[n];

        long sum = 0;
        for (int i=0; i<n; i++) {
            numbers[i] = readInt();
        }
        for (int i=0; i<m; i++) {
            sum += numbers[i];
        }
        long maxSum = sum;

        for (int i=m; i<n; i++) {
            sum -= numbers[i-m];
            sum += numbers[i];

            maxSum = Math.max(maxSum, sum);
        }
        System.out.print(maxSum);
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

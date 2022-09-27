import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        System.out.print(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int readInt() throws IOException {
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

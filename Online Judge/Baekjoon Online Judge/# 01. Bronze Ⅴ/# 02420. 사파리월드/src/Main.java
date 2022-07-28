
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        long n = readInt();
        long m = readInt();
        long result = n-m;

        if (result < 0) {
            result = -result;
        }
        System.out.print(result);
    }

    public static int readInt() throws IOException {
        int value = 0;
        boolean negative = false;
        int input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return (negative) ? -value : value;
            } else if (input == '-') {
                negative = true;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }

}

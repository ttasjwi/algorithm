import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int original, number;
        original = number = readInt();

        int count = 0;

        do {
            count++;
            number = (number % 10 * 10) + (number / 10 + number % 10) % 10;

        } while (number != original);
        System.out.print(count);
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

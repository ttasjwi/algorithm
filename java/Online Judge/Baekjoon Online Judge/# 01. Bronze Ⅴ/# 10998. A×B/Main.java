import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int number = readInt();
        number *= readInt();
        System.out.print(number);
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + input - 48;
            }
        }
    }

}

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int sum = 0;

        int number;
        for (int i=0; i<5; i++) {
            number = readInt();
            sum += (number * number);

        }
        System.out.print(sum%10);
    }

    public static int readInt() throws IOException {
        int value = 0;
        int input;

        while(true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

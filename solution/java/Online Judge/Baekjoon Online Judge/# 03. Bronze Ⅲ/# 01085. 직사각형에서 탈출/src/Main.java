import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int x = readInt();
        int y = readInt();
        int w = readInt();
        int h = readInt();

        int min = Math.min(Math.min(Math.min(x, y), h - y), w - x);
        System.out.print(min);
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

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int h = readInt();
        int m = readInt();
        StringBuilder sb = new StringBuilder();

        m -= 45;
        if (m < 0) {
            m += 60;
            h -= 1;

            if (h < 0) {
                h += 24;
            }
        }
        sb.append(h).append(' ').append(m);
        System.out.print(sb);
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

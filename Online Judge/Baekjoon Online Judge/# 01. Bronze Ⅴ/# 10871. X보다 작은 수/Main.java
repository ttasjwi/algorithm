import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int x = readInt();
        StringBuilder sb = new StringBuilder();
        int input;
        for (int i=0; i<n; i++) {
            input = readInt();
            if (input < x) {
                sb.append(input).append(' ');
            }
        }
        System.out.print(sb);
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

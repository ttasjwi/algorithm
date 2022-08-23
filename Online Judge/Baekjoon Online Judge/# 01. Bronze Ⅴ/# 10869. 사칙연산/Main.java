import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = readInt();
        int b = readInt();

        StringBuilder sb = new StringBuilder();
        sb.append(a+b).append('\n')
                .append(a-b).append('\n')
                .append(a*b).append('\n')
                .append(a/b).append('\n')
                .append(a%b);
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
                value = value * 10 + (input - 48);
            }
        }
    }
}

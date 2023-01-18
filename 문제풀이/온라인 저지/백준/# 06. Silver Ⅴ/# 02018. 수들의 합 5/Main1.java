import java.io.IOException;

public class Main1 {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int answer = 0;
        int cnt = 1;

        do {
            if (n % cnt == 0) {
                answer++;
            }
            n -= cnt++;
        } while (n > 0);
        System.out.print(answer);
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

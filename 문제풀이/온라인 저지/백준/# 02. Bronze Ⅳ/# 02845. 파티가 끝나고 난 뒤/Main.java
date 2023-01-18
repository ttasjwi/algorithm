import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int L = readInt();
        int C = readInt();
        int count = L * C;

        StringBuilder sb = new StringBuilder();
        int diff;
        for (int i=0; i<5; i++) {
            diff = readInt() - count;
            sb.append(diff).append(' ');
        }
        System.out.print(sb);
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while(true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

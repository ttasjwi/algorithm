import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int value = readInt();
            maxValue = Math.max(value, maxValue);
            minValue = Math.min(value, minValue);
        }
        int answer = minValue * maxValue;
        System.out.print(answer);
    }

    public static int readInt() throws IOException {
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

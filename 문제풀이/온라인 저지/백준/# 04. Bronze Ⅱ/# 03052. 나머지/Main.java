import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] counter = new int[42];
        for (int i = 0; i < 10; i++) {
            counter[readInt()%42] ++;
        }
        int answer = 0;
        for (int i : counter) {
            if (i > 0) {
                answer ++;
            }
        }
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

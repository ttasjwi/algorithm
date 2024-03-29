import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int number = readInt();
        number *= readInt();
        number *= readInt();

        int[] counter = new int[10];
        while (number > 0) {
            counter[number%10] ++;
            number /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : counter) {
            sb.append(i).append('\n');
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

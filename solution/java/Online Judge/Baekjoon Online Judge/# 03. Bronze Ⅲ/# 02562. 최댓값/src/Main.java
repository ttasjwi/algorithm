import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int maxValue = 0;
        int maxValueOrder = -1;

        for (int i = 0; i < 9; i++) {
            int value = readInt();
            if (value > maxValue) {
                maxValue = value;
                maxValueOrder = i + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append('\n').append(maxValueOrder);

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
                value = value * 10 + input - 48;
            }
        }

    }
}

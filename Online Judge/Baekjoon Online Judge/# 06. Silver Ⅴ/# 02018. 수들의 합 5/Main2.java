import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int lt = 1;
        int rt = 1;
        int sum = 0;
        int answer = 0;

        while (lt <= n && rt <= n) {
            sum += rt;
            if (sum == n) {
                answer++;
                sum -= lt;
                lt++;
            }
            while (sum >= n) {
                sum -= lt;
                lt++;
                if (sum == n) {
                    answer++;
                }
            }
            rt++;
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

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] numbers = new int[N+1];

        for (int i=1; i<=N; i++) {
            numbers[i] = readInt();
        }
        String answer = solution(numbers);
        System.out.print(answer);
    }

    private static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<numbers.length; i++) {
            if (numbers[i-1] < numbers[i]) {
                sb.append(numbers[i]).append(' ');
            }
        }
        return sb.toString();
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while(true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return value;
            } else {
                value = value * 10 + input - 48;
            }
        }
    }
}

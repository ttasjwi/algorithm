import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int m = readInt(); // 시작 범위
        int n = readInt(); // 끝 범위

        boolean[] isCompositeNumber = new boolean[1_000_001];
        isCompositeNumber[1] = true;

        for (int i = 2; i <= n; i++) {
            if (!isCompositeNumber[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isCompositeNumber[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!isCompositeNumber[i]) {
                sb.append(i).append('\n');
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
                value = value * 10 + (input - 48);
            }
        }
    }
}

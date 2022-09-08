import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int k = readInt(); // 가진 랜선의 갯수 (1<=k<=10000)
        int n = readInt(); // 만들어야하는 랜선의 갯수 (1<=n<=10000000)

        int[] lengths = new int[k]; // 가진 랜선의 길이들

        long lt = 1;
        long rt = 0;
        for (int i=0; i<k; i++) {
            lengths[i] = readInt();
            rt = Math.max(rt, lengths[i]);
        }
        long answer = 0;

        long mid;
        long count;
        boolean success;
        while (lt<=rt) {
            mid = (lt +rt) >> 1; // 탐색 대상 : 랜선의 길이
            success = false;
            count = 0;
            for (int length : lengths) {
                count += length/mid;
                if (count >= n) {
                    success = true;
                    break;
                }
            }

            if (success) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid -1;
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

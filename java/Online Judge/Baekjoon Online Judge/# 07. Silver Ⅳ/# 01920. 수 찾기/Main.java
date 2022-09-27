import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = readInt();
        }
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        int m = readInt();
        int input;
        for (int i = 0; i < m; i++) {
            input = readInt();
            binarySearch(numbers, n, input, sb);
        }
        System.out.print(sb);
    }

    private static void binarySearch(int[] numbers, int n, int search, StringBuilder sb) {
        int lt;
        int rt;
        int mid;
        lt = 0;
        rt = n - 1;

        while (lt <= rt) {
            mid = (lt + rt) /2;
            if (numbers[mid] == search) {
                sb.append('1').append('\n');
                return;
            } else if (numbers[mid] > search) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        sb.append('0').append('\n');
    }

    private static int readInt() throws IOException {
        int value = 0;
        boolean negative = false;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (negative) ? -value : value;
            } else if (input == '-') {
                negative = true;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

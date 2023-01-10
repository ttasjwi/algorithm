import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(numbers, n, m);
        System.out.print(answer);
    }

    private static int solution(int[] numbers, int n, int m) {
        Arrays.sort(numbers);
        int lt = 0;
        int rt = n-1;
        int mid = -1;
        while (lt<=rt) {
            mid = (lt+rt)/2;
            if (numbers[mid] == m) {
                break;
            } else if (numbers[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return mid + 1;
    }

}

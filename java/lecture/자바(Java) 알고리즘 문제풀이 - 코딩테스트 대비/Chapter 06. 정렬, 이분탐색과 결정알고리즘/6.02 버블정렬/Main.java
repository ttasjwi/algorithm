import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        String answer = solution(numbers, n);
        System.out.print(answer);
    }

    /**
     * 버블정렬 (오름차순 기준, 시간복잡도 O(N^2))
     *
     * 1. 0번 인덱스부터 n-1번 인덱스까지 연속된 두 데이터를 비교하여 큰 것을 뒤로 스와핑하기를 반복한다.
     * 2. 이렇게 하면 n-1 인덱스에는 최댓값이 자리잡는다.
     * 3. 0번 인덱스부터 n-2 인덱스까지 연속된 두 데이터를 비교하여 큰 것을 뒤로 스와핑하기를 반복한다.
     * 4. 이렇게 하면 n-2 인덱스에는 두번째 최댓값이 자리잡는다.
     * 5. 마찬가지의 방법으로 총 n-1번 반복하면 정렬이 완료된다.
     */

    private static String solution(int[] numbers, int n) {
        int tmp;
        for (int i=0; i<n-1; i++) { // n-1번 뒷값을 결정한다.
            for (int j=1; j< n-i; j++) {
                if (numbers[j-1] > numbers[j]) {
                    tmp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(' ');
        }
        return sb.toString();
    }
}

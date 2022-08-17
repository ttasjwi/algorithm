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
     * 선택정렬(오름차순 기준)
     * 시간 복잡도 : O(N^2)
     * 1. 주어진 숫자 목록에서 최솟값을 찾아서 0번 인덱스에 둔다.
     * 2. 0번 인덱스를 제외한 나머지 목록에서 최솟값을 찾아서 1번 인덱스에 둔다.
     * 3. 마찬가지의 방법으로 나머지 모든 목록들을 정렬한다.
     */

    private static String solution(int[] numbers, int n) {
        StringBuilder sb = new StringBuilder();
        int idx;
        int tmp;
        for (int i=0; i<n; i++) {
            // i번 인덱스의 값을 정함
            idx = i;
            for (int j=i+1; j<n; j++) {
                if (numbers[idx] > numbers[j]) {
                    idx = j;
                }
            }
            tmp = numbers[i];
            numbers[i] = numbers[idx];
            numbers[idx] = tmp;

            sb.append(numbers[i]).append(' ');
        }
        return sb.toString();
    }
}

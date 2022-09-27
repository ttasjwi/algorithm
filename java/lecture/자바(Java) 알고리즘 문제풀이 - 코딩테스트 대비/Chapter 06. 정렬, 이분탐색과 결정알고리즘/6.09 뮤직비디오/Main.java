import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 노래 갯수
        int m = Integer.parseInt(st.nextToken()); // 허용되는 DVD 갯수

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(numbers, n, m);
        System.out.print(answer);
    }

    private static int solution(int[] numbers, int n, int m) {
        int answer = 0;
        int lt = Arrays.stream(numbers).max().getAsInt();
        int rt = Arrays.stream(numbers).sum();
        int count;
        int mid;

        while (lt <= rt) {
            mid = (lt + rt) / 2; // 값을 정해둔다
            count = getCount(numbers, mid);

            if (count <= m) { // 조건에 부합하는 상황이면 일단 rt의 범위를 좀 더 줄여본다.
                answer = mid;
                rt = mid - 1;
            } else { // 조건에 부합하지 않는 상황이면  lt를 mid보다 크게 한다.
                lt = mid + 1;
            }
        }
        return answer;
    }

    private static int getCount(int[] numbers, int capacity) {
        int cnt = 1, sum = 0;
        for (int number : numbers) {
            // 여태 누적한 sum과 비교했을 때
            if (sum + number > capacity) { // 용량을 초과한다면
                cnt ++;
                sum = number;
            } else {
                sum += number;
            }
        }
        return cnt;
    }

}

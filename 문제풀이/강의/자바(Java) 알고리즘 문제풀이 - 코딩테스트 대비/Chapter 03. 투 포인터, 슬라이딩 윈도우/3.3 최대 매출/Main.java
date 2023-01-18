import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(arr, n, k);
        System.out.print(answer);
    }

    private static int solution(int[] arr, int n, int k) {
        int maxSum;
        int sum = 0;
        for (int i=0; i<k; i++) { // 맨 처음 윈도우의 크기인 k만큼 합을 구해놓는다.
            sum += arr[i];
        }
        maxSum = sum;

        for (int i=k; i<n; i++) {// 윈도우를 한칸씩 민다.
            sum += arr[i]; // 영역에 들어온 값을 더한다.
            sum -= arr[i-k]; // 영역 밖으로 벗어난 값을 뺀다.
            maxSum = Math.max(maxSum, sum); // 최댓값을 갱신한다.
        }
        return maxSum;
    }
}

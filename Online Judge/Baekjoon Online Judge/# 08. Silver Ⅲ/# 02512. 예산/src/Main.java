import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] budgets = new int[N]; // 예산들

        for(int i=0; i<N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets); // 오름차순 정렬

        int M = Integer.parseInt(br.readLine()); // 예산 총액
        while (sum(budgets) > M) { // 예산총액보다 합계가 클 때
            budgets[N-1] --; // 최댓값을 1 줄인다.
            for (int i=0; i<N; i++) {
                if (budgets[i] > budgets[N-1]) { // 각각의 값이 최댓값보다 클 경우
                    budgets[i] --;
                }
            }
        }
        System.out.print(budgets[N-1]);
    }

    private static int sum(int[] budgets) {
        int sum = 0;
        for (int budget : budgets) {
            sum += budget;
        }
        return sum;
    }
}

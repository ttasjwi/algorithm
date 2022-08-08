import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n][n];

        StringTokenizer st;


        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int answer = solution(numbers);
        System.out.print(answer);
    }

    private static int solution(int[][] numbers) {
        int answer = 0;
        int leftCrossSum = 0;
        int rightCrossSum = 0;

        int verticalSum, horizontalSum;

        for (int i=0; i<numbers.length; i++) {
            verticalSum = horizontalSum = 0;
            for (int j=0; j<numbers.length; j++) {
                if (i==j) {
                    leftCrossSum += numbers[i][j];
                }
                if (i+j == numbers.length-1) {
                    rightCrossSum += numbers[i][j];
                }
                horizontalSum += numbers[i][j]; // 가로합
                verticalSum += numbers[j][i]; // 세로합
            }
            answer = Math.max(answer, verticalSum);
            answer = Math.max(answer, horizontalSum);
        }
        answer = Math.max(answer, leftCrossSum);
        answer = Math.max(answer, rightCrossSum);
        return answer;
    }
}

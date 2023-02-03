import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

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
        int answer = solution(numbers);
        System.out.print(answer);
    }

    private static int solution(int[][] numbers) {
        int leftCrossSum = 0;
        int rightCrossSum = 0;

        int[] verticalSums = new int[numbers.length];
        int[] horizontalSums = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            for (int j=0; j<numbers.length; j++) {
                if (i==j) {
                    leftCrossSum += numbers[i][j];
                }
                if (i+j == numbers.length-1) {
                    rightCrossSum += numbers[i][j];
                }
                verticalSums[j] += numbers[i][j];
                horizontalSums[i] += numbers[i][j];
            }
        }

        int max = Math.max(leftCrossSum, rightCrossSum);

        for (int verticalSum : verticalSums) {
            max = Math.max(max, verticalSum);
        }
        for (int horizontalSum : horizontalSums) {
            max = Math.max(max, horizontalSum);
        }
        return max;
    }
}

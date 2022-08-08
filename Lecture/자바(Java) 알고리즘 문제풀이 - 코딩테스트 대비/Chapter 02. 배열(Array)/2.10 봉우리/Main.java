import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동남서북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n + 2][n + 2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = solution(numbers, n);
        System.out.print(answer);
    }

    private static int solution(int[][] numbers, int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isMountainTop = true;
                for (int k = 0; k<4; k++) {
                    int nx = j + DIRECTION_X[k];
                    int ny = i + DIRECTION_Y[k];
                    if (numbers[i][j] <= numbers[ny][nx]) {
                        isMountainTop = false;
                        break;
                    }
                }
                if (isMountainTop) count ++;
            }
        }
        return count;
    }
}

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int n = readInt(); // 학생수
        int[][] bans = new int[n+1][6]; // 관리의 편의를 위해 1칸씩 크게 해서 입력

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=5; j++) {
                bans[i][j] = readInt();
            }
        }

        int answer = solution(bans, n);
        System.out.print(answer);
    }

    private static int solution(int[][] bans, int n) {
        int maxIndex = 0;

        int maxCount = Integer.MIN_VALUE;
        int count;

        for (int i=1; i<=n; i++) {
            count = 0;
            for (int j=1; j<=n; j++) { // 다른 학생
                for (int k=1; k<=5; k++) { // 1~5학년
                    if (bans[i][k] == bans[j][k]) { // k학년 때 i학생, j학생의 반이 같으면
                        count ++; // count 증가
                        break; // 그 이후 학년은 고려 안 함
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

import java.io.IOException;

public class Main1 {

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
        boolean[][] knows = new boolean[n+1][n+1]; // 인간관계 배열
        for (int i=1; i<=n; i++) {
            knows[i][i] = true; // 자기 자신은 알고 있다.
        }

        int maxStudent = 0; // 제일 다른 학생을 많이 알고 있는 사람
        int maxCount = 0; // 제일 다른 학생을 많이 알고 있는 사람이 알고 있는 학생 수
        int count; // 알고 있는 학생 수

        for (int i=1; i<=n; i++) {
            count = 0;
            for (int j=1; j<=n; j++) { // 다른 학생 j에 대하여
                for (int k=1; k<=5; k++) { // 1학년~5학년을 순차적 확인하면서
                    if (knows[i][j]) { // 내가 쟤를 알면 굳이 계산할 필요가 없음
                        count ++;
                        break;
                    }
                    if (bans[i][k] == bans[j][k]) { // k학년 때 반이 서로 같으면
                        knows[i][j] = true; // 현재 학생은 저 학생을 알고 있다.
                        knows[j][i] = true; // 저 학생은 나를 알고 있다
                        count ++;
                        break;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxStudent = i;
                }
            }
        }

        return maxStudent;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 테스트 횟수

        int[][] results = new int[M][N];


        for (int i=0; i<M; i++) { // i번째 테스트에서
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) { // j등은
                results[i][j] = Integer.parseInt(st.nextToken()); // ~학생이다.
            }
        }
        br.close();

        int answer = solution(results, N, M);
        System.out.print(answer);
    }

    private static int solution(int[][] results, int n, int m) {
        int positionT; // t의 등수
        int positionU; // u의 등수
        int count = 0;

        boolean isMento;

        for (int t=1; t<=n; t++) { // t번 학생
            for (int u=1; u<=n; u++) { // u번 학생에 대하여

                if (t == u) { // 같은 사람이면 계산 안 함
                    continue;
                }

                isMento = true;

                for (int i=0; i<m; i++) { // i번 테스트
                    positionT = positionU = 0;
                    for (int j=0; j<n; j++) { // j등이 누군지 확인해서
                        if (t == results[i][j]) {
                            positionT = j; // t의 등수 찾기
                        }
                        if (u == results[i][j]) {
                            positionU = j; // j의 등수 찾기
                        }
                    }
                    if (positionT > positionU) {
                        isMento = false;
                        break;
                    }
                }
                if (isMento) {
                    count ++;
                }
            }
        }
        return count;
    }
}

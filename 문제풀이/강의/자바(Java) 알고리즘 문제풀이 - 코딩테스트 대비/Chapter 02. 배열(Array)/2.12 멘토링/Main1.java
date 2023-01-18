import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 테스트 횟수

        int[][] ranks = new int[N][M]; // 각 학생마다, 시험 당시 등수


        for (int i=0; i<M; i++) { // i번째 테스트에서
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) { // j등의
                int k = Integer.parseInt(st.nextToken()) - 1; // 학생 번호는 k
                ranks[k][i] = j; // k 학생은 i번째 테스트에서 j등
            }
        }
        br.close();

        int answer = solution(ranks, N, M);
        System.out.print(answer);
    }

    private static int solution(int[][] ranks, int n, int m) {
        boolean isMento;
        int count = 0;
        for (int i=0; i<n; i++) { // i번 학생
            for (int j=0; j<n; j++) { // j번 학생
                if (i==j) {
                    continue;
                }
                isMento = true;
                for (int k=0; k<m; k++) { // k번째 테스트 등수
                    if (ranks[i][k] > ranks[j][k]) {
                        // i학생의 k번째 테스트 등수가 j학생의 k번째 테스트 등수보다 한번이라도 뒤쳐지면
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

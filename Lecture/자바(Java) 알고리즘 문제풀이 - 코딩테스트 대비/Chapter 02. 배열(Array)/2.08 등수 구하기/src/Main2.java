import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
        }
        String answer = solution(scores);
        System.out.print(answer);
    }

    private static String solution(int[] scores) {
        StringBuilder sb = new StringBuilder();
        int rank;

        for (int i=0; i< scores.length; i++) {
            rank = 1;
            for (int j=0; j<scores.length; j++) {
                if (i!= j && scores[j] > scores[i]) { // 자기 자신보다 높은, 다른 사람의 점수를 발견할 때마다
                    rank ++;
                }
            }
            sb.append(rank).append(' ');
        }
        return sb.toString();
    }
}

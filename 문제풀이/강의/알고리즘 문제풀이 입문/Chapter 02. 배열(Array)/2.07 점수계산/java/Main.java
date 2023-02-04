import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isAnswers = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            char symbol = st.nextToken().charAt(0);
            isAnswers[i] = (symbol == '1') ? true : false;
        }

        int score = solution(isAnswers);
        System.out.print(score);
    }

    private static int solution(boolean[] isAnswers) {
        int bonus = 0;
        int totalScore = 0;

        for (boolean isAnswer : isAnswers) {
            if (isAnswer) {
                bonus ++;
                totalScore += bonus;
            } else {
                bonus = 0;
            }
        }
        return totalScore;
    }
}

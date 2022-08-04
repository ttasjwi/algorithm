import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        String word = st.nextToken();
        char ch = st.nextToken().charAt(0);

        String answer = solution(word, ch);
        System.out.print(answer);
    }

    private static String solution(String word, char ch) {
        int[] distances = calculateLeftDistances(word, ch);
        updateMinDistances(word, ch, distances);
        return buildAnswerString(distances);
    }

    private static int[] calculateLeftDistances(String word, char ch) {
        int[] distances = new int[word.length()];
        int leftDistance = 1000; // 왼쪽으로부터 떨어진 거리

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                leftDistance = 0; // 같은 문자이면 떨어진 거리를 0으로 갱신
            }
            distances[i] = leftDistance;
            leftDistance++;
        }
        return distances;
    }

    private static void updateMinDistances(String word, char ch, int[] distances) {
        int rightDistance = 1000;

        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == ch) {
                rightDistance = 0;
            }
            distances[i] = Math.min(distances[i], rightDistance);
            rightDistance++;
        }
    }

    private static String buildAnswerString(int[] distances) {
        StringBuilder sb = new StringBuilder();
        for (int distance : distances) {
            sb.append(distance).append(' ');
        }
        return sb.toString();
    }

}

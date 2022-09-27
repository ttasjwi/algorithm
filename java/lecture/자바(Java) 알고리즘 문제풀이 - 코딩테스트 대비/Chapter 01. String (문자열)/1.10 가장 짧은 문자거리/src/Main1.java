import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String word = st.nextToken();
        char ch = st.nextToken().charAt(0);

        String answer = solution(word, ch);
        System.out.print(answer);
    }

    private static String solution(String word, char ch) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<word.length(); i++) {
            String leftString = word.substring(0,i);
            String rightString = word.substring(i);

            int minDistance = Math.min(getLeftDistance(ch, leftString), getRightDistance(ch, rightString));
            sb.append(minDistance).append(' ');
        }
        return sb.toString();
    }
    private static int getLeftDistance(char ch, String leftString) {
        int leftDistance = Integer.MAX_VALUE;
        for (int j = 0; j< leftString.length(); j++) {
            int currentIndex = leftString.length() - 1 - j;

            if (leftString.charAt(currentIndex) == ch) {
                leftDistance = j+1;
                break;
            }
        }
        return leftDistance;
    }
    private static int getRightDistance(char ch, String rightString) {
        int rightIndex = rightString.indexOf(ch);
        return (rightIndex == -1) ? Integer.MAX_VALUE : rightIndex;
    }

}

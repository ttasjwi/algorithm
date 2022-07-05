import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfWords = Integer.parseInt(br.readLine());
        String[] words = new String[numberOfWords];

        for (int i=0; i<numberOfWords; i++) {
            words[i] = br.readLine();
        }
        br.close();

        String answer = solution(words);
        System.out.print(answer);
    }

    public static String solution(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            StringBuilder subSb = new StringBuilder(word);
            subSb.reverse();
            sb.append(subSb).append('\n');
        }
        return sb.toString();
    }
}

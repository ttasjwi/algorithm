import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        br.close();
        String answer = solution(word);
        System.out.print(answer);
    }

    private static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (word.indexOf(ch) == i) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}

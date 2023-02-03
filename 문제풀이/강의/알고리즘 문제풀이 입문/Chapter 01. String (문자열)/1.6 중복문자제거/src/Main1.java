import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        br.close();
        String answer = solution(word);
        System.out.print(answer);
    }

    private static String solution(String word) {
        LinkedHashSet<Character> chars = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            chars.add(ch);
        }
        for (Character ch : chars) {
            sb.append(ch);
        }
        return sb.toString();
    }

}

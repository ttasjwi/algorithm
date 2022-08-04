import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int answer = solution(word);
        System.out.print(answer);
    }

    private static int solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}

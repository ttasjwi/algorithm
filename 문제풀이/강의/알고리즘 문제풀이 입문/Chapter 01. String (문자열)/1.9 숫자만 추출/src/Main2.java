import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int answer = solution(word);
        System.out.print(answer);
    }

    private static int solution(String word) {
        int value = 0;
        for (int ch : word.toCharArray()) {
            if (48 <= ch && ch <= 57) {
                value = value * 10 + (ch - 48);
            }
        }
        return value;
    }
}

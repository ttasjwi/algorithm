import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String answer = solution(word);
        System.out.print(answer);
    }

    private static String solution(String word) {
        word = word.toLowerCase();

        int left = 0;
        int right = word.length()-1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return "NO";
            }
            left ++;
            right--;
        }
        return "YES";
    }
}

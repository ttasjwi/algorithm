import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String answer = solution(word);
        System.out.print(answer);
    }

    private static String solution(String word) {
        word = word.toLowerCase().replaceAll("[^a-z]", "");
        String reverse = new StringBuilder(word).reverse().toString();
        return (word.equals(reverse)) ? "YES" : "NO";
    }
}

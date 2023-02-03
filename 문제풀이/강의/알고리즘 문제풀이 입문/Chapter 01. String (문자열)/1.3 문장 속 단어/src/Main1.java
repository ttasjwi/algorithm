import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] words = line.split(" +");

        String answer = solution(words);
        System.out.print(answer);
    }

    private static String solution(String[] words) {
        String maxLengthString = "";
        for (String word : words) {
            if (word.length() > maxLengthString.length()) {
                maxLengthString = word;
            }
        }
        return maxLengthString;
    }


}

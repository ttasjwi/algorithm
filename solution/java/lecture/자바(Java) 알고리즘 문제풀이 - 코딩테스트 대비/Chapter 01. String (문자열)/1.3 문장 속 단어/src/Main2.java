import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String answer = solution(line);
        System.out.print(answer);
    }

    private static String solution(String line) {
        String maxLengthWord = "";

        String word;
        int spaceIndex;

        while ((spaceIndex= line.indexOf(' '))!= -1) {
            word = line.substring(0, spaceIndex);
            if (word.length() > maxLengthWord.length()) {
                maxLengthWord = word;
            }
            line = line.substring(spaceIndex + 1);
        }

        // 마지막 남은 단어
        if (line.length() > maxLengthWord.length()) {
            maxLengthWord = line;
        }
        return maxLengthWord;
    }
}

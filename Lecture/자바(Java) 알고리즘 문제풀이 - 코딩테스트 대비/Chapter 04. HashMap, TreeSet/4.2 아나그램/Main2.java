import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();
        br.close();

        String answer = solution(word1, word2);

        System.out.print(answer);
    }

    private static String solution(String word1, String word2) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char ch1 : word1.toCharArray()) {
            counter.put(ch1, counter.getOrDefault(ch1, 0) + 1);
        }

        for (char ch2 : word2.toCharArray()) {
            if (!counter.containsKey(ch2) || counter.get(ch2) == 0) {
                return "NO";
            }
            counter.put(ch2, counter.get(ch2) - 1);
        }
        return "YES";
    }
}

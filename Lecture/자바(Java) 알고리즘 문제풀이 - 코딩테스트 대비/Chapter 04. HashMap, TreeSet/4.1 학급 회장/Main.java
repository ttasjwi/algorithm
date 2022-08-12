import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 학생수
        String line = br.readLine();
        br.close();

        HashMap<Character, Integer> counter = new HashMap<>();
        for (char ch : line.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        char maxChar = ' ';
        int maxCount = 0;
        int count;
        char ch;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            ch = entry.getKey();
            count = entry.getValue();

            if (count > maxCount) {
                maxChar = ch;
                maxCount = count;
            }
        }
        System.out.print(maxChar);
    }
}

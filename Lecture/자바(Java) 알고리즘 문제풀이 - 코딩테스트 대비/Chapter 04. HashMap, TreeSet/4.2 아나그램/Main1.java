import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        HashMap<Character, Integer> counter1 = new HashMap<>();
        for (char ch : line.toCharArray()) {
            counter1.put(ch, counter1.getOrDefault(ch, 0) + 1);
        }

        line = br.readLine();
        HashMap<Character, Integer> counter2 = new HashMap<>();
        for (char ch : line.toCharArray()) {
            counter2.put(ch, counter2.getOrDefault(ch, 0) + 1);
        }
        br.close();

        String answer = (counter1.equals(counter2)) ? "YES" : "NO";
        System.out.print(answer);
    }
}

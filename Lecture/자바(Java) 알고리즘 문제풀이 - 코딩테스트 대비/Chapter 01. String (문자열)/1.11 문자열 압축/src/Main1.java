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
        char[] chars = word.toCharArray();
        boolean[] isVisited = new boolean[chars.length];

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<chars.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                char current = chars[i];
                int count = 1;

                int j = i;

                while(++j < chars.length && current == chars[j]) {
                    isVisited[j] = true;
                    count ++;
                }
                sb.append(current);
                if (count >= 2) {
                    sb.append(count);
                }
            }
        }
        return sb.toString();
    }
}

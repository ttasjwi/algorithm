import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        br.close();
        String answer = solution(word);
        System.out.print(answer);
    }

    private static String solution(String word) {
        Stack<Character> charStack = new Stack<>();

        for (char ch : word.toCharArray()) {
            if (ch == '(') {
                charStack.push(ch);
            } else if (charStack.isEmpty()) {
                return "NO";
            } else {
                charStack.pop();
            }
        }
        return (charStack.isEmpty()) ? "YES" : "NO";
    }
}

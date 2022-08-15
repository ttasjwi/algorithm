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
            if (ch == ')') {
                while(charStack.pop() != '('); // '(' 만날 때까지 계속 pop
            } else {
                charStack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : charStack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

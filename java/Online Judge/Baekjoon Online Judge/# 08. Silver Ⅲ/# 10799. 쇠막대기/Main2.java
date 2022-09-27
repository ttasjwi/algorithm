import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();

        int answer = solution(line);
        System.out.print(answer);
    }

    private static int solution(String line) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') stack.push(line.charAt(i));
            else {
                stack.pop();
                if (line.charAt(i - 1) == '(') count += stack.size();
                else count++;
            }
        }
        return count;
    }
}

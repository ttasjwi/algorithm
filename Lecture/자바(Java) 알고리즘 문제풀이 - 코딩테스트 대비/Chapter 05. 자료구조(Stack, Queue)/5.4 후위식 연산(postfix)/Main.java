import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();
        int answer = solution(line);
        System.out.print(answer);
    }

    private static int solution(String line) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : line.toCharArray()) {
            if (Character.isDigit(ch)) {
            // if ('0' <= ch && ch <= '9') {
                stack.push(ch-48);
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();

            if (ch == '+') stack.push(a+b);
            else if (ch == '-') stack.push(a-b);
            else if (ch == '*') stack.push(a*b);
            else if (ch == '/') stack.push(a/b);
        }
        return stack.pop();
    }
}

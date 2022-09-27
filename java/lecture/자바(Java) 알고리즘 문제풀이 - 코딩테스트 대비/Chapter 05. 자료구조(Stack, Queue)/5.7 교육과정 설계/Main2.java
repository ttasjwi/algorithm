import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        br.close();

        String answer = solution(str1, str2);
        System.out.print(answer);
    }

    private static String solution(String order, String plan) {
        Queue<Character> queue = new LinkedList<>();
        for (char o : order.toCharArray()) queue.offer(o);

        for (char p : plan.toCharArray()) { // plan에서 p를 순서대로 꺼낸다.

            if (queue.contains(p)) { // 큐에서 p를 포함하고 으면
                if (p!=queue.poll()) {
                    // queue에서 문자를 꺼낸다. 근데 p와 같지 않으면 순서가 맞지 않다는 뜻이다.
                    return "NO";
                }
            }
        }
        return (queue.isEmpty()) ? "YES" : "NO";
    }
}

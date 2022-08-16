import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1 {

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
        for (char ch : plan.toCharArray()) queue.offer(ch);
        boolean find;

        for (char o : order.toCharArray()) {
            find = false;
            while(!queue.isEmpty()) {
                if (queue.poll() == o) {
                    find = true;
                    break;
                }
            }

            if (find) {
                continue;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}

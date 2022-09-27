import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int n = Integer.parseInt(st.nextToken()); // 숫자의 갯수
        int k = Integer.parseInt(st.nextToken()); // 몇 번째?

        int answer = solution(n, k);
        System.out.print(answer);
    }

    private static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList();

        for (int i=1; i<=n; i++) queue.offer(i);

        while (queue.size() != 1) {
            for (int i=0; i<k-1; i++) queue.offer(queue.poll()); // k-1번째까지는 뺐다 넣는다.
            queue.poll(); // k번째 요소는 제거한다.
        }
        return queue.poll(); // 마지막 남은 단 하나를 반환한다.
    }
}

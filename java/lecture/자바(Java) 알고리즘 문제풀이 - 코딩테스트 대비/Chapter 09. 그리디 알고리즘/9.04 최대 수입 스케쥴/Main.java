import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int n;

    private static Lecture[] lectures;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    private static int maxTime = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        lectures = new Lecture[n];
        int money, time;
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            money = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());

            maxTime = Math.max(maxTime, time);
            lectures[i] = new Lecture(money, time);
        }
        int answer = solution();
        System.out.print(answer);
    }

    private static int solution() {
        Arrays.sort(lectures);
        int sum = 0;
        int index = 0;
        for (int time=maxTime; time>=1; time --) {
            while(index < n && lectures[index].time >= time) {
                pq.offer(lectures[index].money);
                index ++;
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        return sum;
    }
}

class Lecture implements Comparable<Lecture> {

    int money;
    int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture other) {
        return other.time - this.time; // 날짜 기준 내림차순
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 참석 인원수
    private static Event[] events;

    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        events = new Event[2*n];
        StringTokenizer st;
        for (int i=0; i<2*n; i+= 2) {
            st = new StringTokenizer(br.readLine(), " ");
            events[i] = new Event(Integer.parseInt(st.nextToken()), false);
            events[i+1] = new Event(Integer.parseInt(st.nextToken()), true);
        }
        br.close();
    }

    private static int solution() {
        Arrays.sort(events);
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (Event event : events) {
            if (event.isEnd) count --;
            else count ++;
            max = Math.max(max, count);
        }
        return max;
    }
}

class Event implements Comparable<Event> {

    int when;
    boolean isEnd;

    public Event(int when, boolean isEnd) {
        this.when = when;
        this.isEnd = isEnd;
    }


    @Override
    public int compareTo(Event other) {
        if (this.when == other.when) {
            if (isEnd && !other.isEnd) {
                return -1;
            } else if (!isEnd && other.isEnd) {
                return 1;
            } else {
                return 0;
            }
        }
        return this.when - other.when;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 회의 수
    private static Time[] times;

    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        times = new Time[n];

        StringTokenizer st;
        int start, end;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }
        br.close();
    }

    private static int solution() {
        Arrays.sort(times);
        int beforeEnd = 0;
        int answer = 0;
        for (Time time : times) {
            if (beforeEnd <= time.start) {
                beforeEnd = time.end;
                answer++;
            }
        }
        return answer;
    }
}

class Time implements Comparable<Time> {

    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}

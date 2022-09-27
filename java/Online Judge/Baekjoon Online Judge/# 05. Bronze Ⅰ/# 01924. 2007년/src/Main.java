import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int dayOfYear = 0; // 올해의 몇 번째 날
        int x = Integer.parseInt(st.nextToken()); // 년
        int y = Integer.parseInt(st.nextToken()); // 월

        int[] DAY_OF_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i=0; i<x; i++) {
            dayOfYear += DAY_OF_MONTHS[i]; // 그 달까지 일수를 누적
        }

        dayOfYear += y; // 그 달의 경과 일수를 누적
        String[] DAY_OF_WEEKS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println(DAY_OF_WEEKS[dayOfYear%7]); // 누적 일수를 7로 나눈 나머지에 따라 요일을 출력
    }
}

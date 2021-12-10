import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine(), " "); // 생년월일

        int yearGap = - Integer.parseInt(input.nextToken()); // 연도 차
        int monthGap = -Integer.parseInt(input.nextToken()); // 월의 차 (기준 월 - 태어난 월)
        int dateGap = -Integer.parseInt(input.nextToken()); // 일의 차 (기준 일 - 태어난 일)

        input = new StringTokenizer(br.readLine(), " "); // 기준 년월일
        br.close();

        yearGap += Integer.parseInt(input.nextToken());
        monthGap += Integer.parseInt(input.nextToken());
        dateGap += Integer.parseInt(input.nextToken());

        int yearAge = yearGap; // 연 나이 : 연도의 차
        int countAge = yearGap + 1; // 세는 나이(한국나이)
        int fullAge; // 만 나이

        if (monthGap < 0 || (monthGap == 0 && dateGap<0)) {
            fullAge = yearAge-1;
        } else {
            fullAge = yearAge;
        }

        StringBuilder sb = new StringBuilder().append(fullAge).append('\n').append(countAge).append('\n').append(yearAge);
        System.out.println(sb);
    }
}
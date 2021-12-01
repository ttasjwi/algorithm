import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        br.close();

        final StringTokenizer tokens = new StringTokenizer(inputLine, " ");
        final int dValue = Integer.parseInt(tokens.nextToken()); // d값
        final int hRatio = Integer.parseInt(tokens.nextToken()); // h 비율
        final int wRatio = Integer.parseInt(tokens.nextToken()); // w 비율

        final double dRatio = sqrt(pow(hRatio,2) + pow(wRatio,2)); // d 비율(by 피타고라스 정리)

        final int hValue = (int)(dValue * hRatio/dRatio); // h값 : d * cos값
        final int wValue = (int)(dValue * wRatio/dRatio); // w값 : d * sin값

        StringBuilder sb = new StringBuilder().append(hValue).append(" ").append(wValue); // 알고리즘 풀 때 짧은 문자열 결합은 StringBuilder로 처리
        System.out.println(sb);
    }
}
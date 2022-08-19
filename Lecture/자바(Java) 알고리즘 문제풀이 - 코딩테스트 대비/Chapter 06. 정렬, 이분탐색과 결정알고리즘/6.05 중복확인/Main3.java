import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 캐시의 크기
        int[] numbers = new int[10_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int input;
        String answer = "U";
        for (int i=0; i<n; i++) {
           input = Integer.parseInt(st.nextToken());
           if (numbers[input] == input) {
               answer = "D";
               break;
           }
           numbers[input] = input;
        }
        System.out.print(answer);
    }

}

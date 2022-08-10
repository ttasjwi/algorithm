import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int answer = solution(n);
        System.out.print(answer);
    }

    private static int solution(int n) {
        int answer = 0;
        int count = 1;
        n -= count;

        while (n > 0) {
            n -= ++count;
            if (n % count == 0) {
                answer++;
            }
        }
        return answer;
    }

}

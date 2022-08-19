import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 캐시의 크기
        HashSet<Integer> numbers = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String answer = "U";
        int input;
        for (int i=0; i<n; i++) {
           input = Integer.parseInt(st.nextToken());
           if (numbers.contains(input)) {
               answer = "D";
               break;
           }
           numbers.add(input);
        }
        System.out.print(answer);
    }

}

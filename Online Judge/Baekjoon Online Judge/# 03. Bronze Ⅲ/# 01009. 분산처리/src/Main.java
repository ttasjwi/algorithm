import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] comNumbers = {
                {10}, // a의 나머지가 10
                {1}, // 1
                {6,2,4,8}, // 2
                {1,3,9,7}, // 3
                {6,4}, // 4
                {5}, // 5
                {6}, // 6
                {1,7,9,3}, // 7
                {6,8,4,2}, // 8
                {1,9} // 9
        };
        while (T>0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())%10;
            int b = Integer.parseInt(st.nextToken());
            sb.append(comNumbers[a][b%(comNumbers[a].length)]).append('\n');
            T--;
        }
        br.close();
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

        StringBuilder sb = new StringBuilder();
        String[] words;
        for (int i=1; i<=n; i++) {
            words = br.readLine().split(" ");
            sb.append("Case #").append(i).append(':').append(' ');

            for (int j=words.length-1; j>=0; j--) {
                sb.append(words[j]).append(' ');
            }

            sb.append('\n');
        }
        br.close();

        System.out.print(sb);
    }

}

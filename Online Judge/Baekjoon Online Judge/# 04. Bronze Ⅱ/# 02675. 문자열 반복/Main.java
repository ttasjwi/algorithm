import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int r;
        String word;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine()," ");
            r = Integer.parseInt(st.nextToken());
            word = st.nextToken();

            for (char c : word.toCharArray()) {
                for (int k=0; k<r; k++) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        br.close();
        System.out.print(sb);
    }
}

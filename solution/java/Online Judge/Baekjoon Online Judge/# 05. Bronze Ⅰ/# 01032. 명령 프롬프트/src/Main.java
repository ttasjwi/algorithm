import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        char ch;
        for (int j = 0; j < words[0].length(); j++) {
            ch = words[0].charAt(j);

            for (int i = 1; i < n; i++) {
                if (words[i].charAt(j) != ch) {
                    ch = '?';
                    break;
                }
            }
            sb.append(ch);
        }
        System.out.print(sb);
    }

}

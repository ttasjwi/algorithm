import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        br.close();
        Arrays.sort(words, (s1, s2) -> // 길이 기준으로 오름차순 정렬하되, 길이가 같으면 사전식으로 오름차순 정렬한다.
                (s1.length() == s2.length())
                        ? s1.compareTo(s2)
                        : s1.length() - s2.length());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i >= 1 && words[i - 1].equals(words[i])) {
                continue;
            }
            sb.append(words[i]).append('\n');
        }
        System.out.print(sb);
    }
}

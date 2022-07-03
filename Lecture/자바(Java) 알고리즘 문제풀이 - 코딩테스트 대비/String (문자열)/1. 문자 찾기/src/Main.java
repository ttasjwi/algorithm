import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char ch = br.readLine().charAt(0);
        br.close();

        int solution = solution(str, ch);
        System.out.print(solution);
    }

    private static int solution(String str, char ch) {
        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);

        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == ch) {
                count ++;
            }
        }
        return count;
    }

}

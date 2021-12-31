import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        String input = br.readLine();
        for (int i=0; i< N; i++) {
            result += input.charAt(i) - 48;
        }
        br.close();
        System.out.println(result);
    }
}

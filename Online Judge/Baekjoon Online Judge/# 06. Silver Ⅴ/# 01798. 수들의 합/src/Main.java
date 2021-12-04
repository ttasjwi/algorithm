import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        br.close();

        int n = 1; // 숫자의 갯수
        while (S-n>n) {
            S -= n++;
        }
        System.out.println(n);
    }
}

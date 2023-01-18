import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) sb.append(input).append('\n'); // 입력값이 있을 때만
        br.close();
        System.out.println(sb);
    }
}
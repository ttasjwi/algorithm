import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()); // 라인 1
        int b = Integer.parseInt(br.readLine()); // 라인 2
        br.close();

        System.out.println(a+b); // 합
    }

}

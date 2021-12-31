import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int LENGTH = input.length();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<LENGTH/10; ) {
            sb.append(input, i*10, (++i)*10).append('\n');
        }

        sb.append(input, LENGTH/10*10, LENGTH);
        System.out.print(sb);
    }
}

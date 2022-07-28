import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;

        int count;

        while(!(line = br.readLine()).equals("#")) {
            count = 0;

            for (char ch : line.toCharArray()) {
                switch (ch) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        count ++;
                        break;
                    default:
                        break;
                }
            }
            sb.append(count).append('\n');
        }
        br.close();

        System.out.print(sb);
    }

}

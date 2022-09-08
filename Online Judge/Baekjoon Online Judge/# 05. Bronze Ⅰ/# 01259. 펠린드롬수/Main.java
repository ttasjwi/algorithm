import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        boolean noFlag;
        while (!(input = br.readLine()).equals("0")) {
            noFlag = false;
            for (int i=0; i<input.length()/2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    noFlag = true;
                    break;
                }
            }
            if (noFlag) {
                sb.append("no").append('\n');
            } else {
                sb.append("yes").append('\n');
            }
        }
        br.close();
        System.out.print(sb);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int fullStar = 2*N-1;
        int starCount = fullStar;

        while(starCount > 1) {
            sb.append(" ".repeat((fullStar-starCount)/2))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount -= 2;
        }

        while(starCount <= fullStar) {
            sb.append(" ".repeat((fullStar-starCount)/2))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount += 2;
        }

        System.out.print(sb);


    }
}

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        while (N>0) {
            sb.append(N).append('\n');
            N--;
        }

        System.out.print(sb);
    }
}

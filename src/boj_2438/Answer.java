package boj_2438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nmbOfBars = Integer.parseInt(br.readLine());
        br.close();

        final char ch = '*';
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nmbOfBars; i++) {
            for (int j=0; j<i+1; j++) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

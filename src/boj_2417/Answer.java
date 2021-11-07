package boj_2417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long n = Long.parseLong(br.readLine());
        br.close();
        final double sqrtN = Math.pow(n, 0.5);
        final long q = (long) Math.ceil(sqrtN); // 양의 제곱근값의 올림값
        System.out.println(q);
    }
}

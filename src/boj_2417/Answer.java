package boj_2417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long n = Long.parseLong(br.readLine());
        br.close();
        final double rootN = Math.pow(n, 0.5); // 양의 제곱근
        final long q  = (rootN - (long)rootN == 0) // 소수부분이 0인지 여부를 판단
                ? (long)rootN // 소수부분이 0이면 올리지 않아도 됨
                : (long)Math.ceil(rootN); // 소수부분이 0이 아니면 올림처리
        System.out.println(q);
    }
}

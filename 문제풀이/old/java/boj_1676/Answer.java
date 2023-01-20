package boj_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Answer {

    public static void main(String[] args) throws IOException {
        //사용자로부터 n값을 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        br.close();

        // n! 값을 구한다.
        BigInteger nFactorial = BigInteger.ONE;
        for (int i=1; i<=n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        // n!을 문자열로 반환받는다.
        final String nFactorial_Str = nFactorial.toString();

        // 문자열의 맨 뒤부터 0의 갯수를 세다가, 0이 아닌 숫자가 처음 나오면 세는 것을 멈춘다.
        int cntOfZeroFromEnd = 0;
        for (int i=nFactorial_Str.length()-1; i>=0; i--) {
            if(nFactorial_Str.charAt(i) != '0') {
                break;
            }
            cntOfZeroFromEnd ++;
        }

        // 뒤에서부터 센 0의 갯수를 출력한다.
        System.out.println(cntOfZeroFromEnd);
    }

}

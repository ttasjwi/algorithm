package boj_8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int nmbOfTestCase = Integer.parseInt(br.readLine()); // 사용자로부터 테스트케이스의 갯수를 입력받는다.

        final StringBuilder sb = new StringBuilder();

        for (int i=0; i<nmbOfTestCase; i++) {
            char[] chars = br.readLine().toCharArray(); // 사용자로부터 문자열을 입력받고 이를 문자배열로 변환한다.
            int score = 0;
            int bonus = 0;
            for (int j=0; j<chars.length; j++) { // 각 문자를 순서대로 읽어온다.
                if (chars[j]=='O') { // 정답일 경우 bonus를 증가시키고 bonus만큼 점수를 증가시킴
                    bonus ++;
                    score += bonus;
                    continue;
                }
                bonus = 0; // 오답일 경우 bonus를 0으로 초기화
            }
            sb.append(score).append('\n'); // 점수 집계가 끝난 것은 StringBuilder에 append한다. 개행문자도 append
        }
        br.close();
        System.out.print(sb); // StringBuilder에 저장된 값을 출력한다.
    }
}


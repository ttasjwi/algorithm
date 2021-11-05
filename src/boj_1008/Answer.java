package boj_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Answer {

    public static void main(String[] args) throws IOException {
        
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        
        // 분리
        StringTokenizer st = new StringTokenizer(input, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        // 계산
        double result = (double)a/b;
        
        // 출력
        System.out.println(result);
    }
}

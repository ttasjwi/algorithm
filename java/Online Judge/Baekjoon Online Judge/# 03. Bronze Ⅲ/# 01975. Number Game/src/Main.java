import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        final int T = Integer.parseInt(br.readLine()); // 테스트케이스의 갯수
        int N;
        int tmp;
        int cnt = 0;

        for (int i = 0; i<T; i++) {

            N = Integer.parseInt(br.readLine()); // 입력값
            for (int j=2; j<=N; j++) {
                tmp = N; // 입력값을 tmp에 저장한다.

                while (tmp%j ==0) { //tmp를 j(진수)로 나누고, 나머지가 0이면
                    cnt ++; // cnt를 증가시킨뒤
                    tmp /= j; // tmp를 한번 더 진법 값으로 나누고 반복한다.
                }
            }
            sb.append(cnt).append('\n'); // cnt값을 StringBuilder에 append한다.
            cnt = 0; // cnt값 초기화
        }
        br.close();
        System.out.println(sb); // sb에 저장된 값들 일괄 출력
    }
}

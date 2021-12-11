import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());
        final int COUNTER_LENGTH = s1 + s2 + s3 +1;
        int[] sumCounter = new int[COUNTER_LENGTH]; // 합의 등장 횟수를 저장하는 배열

        for (int i=1; i<=s1; i++) {
            for (int j=1; j <=s2; j++) {
                for (int k=1; k<=s3; k++) {
                    sumCounter[i+j+k] ++; // 합에 대응하는 counter 값을 증가시킨다.
                }
            }
        }
        int maxCountSum = 3; // 가장 많이 집계된 합 (인덱스)

        for (int i=4; i<COUNTER_LENGTH; i++) {
            if (sumCounter[maxCountSum] < sumCounter[i]) maxCountSum = i; // 등장 횟수가 최대면, "최대 등장횟수의 합"을 갱신한다.
        }

        System.out.println(maxCountSum);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int N = Integer.parseInt(st.nextToken()); // 전체 물병의 갯수
        int K = Integer.parseInt(st.nextToken()); // 재분배 결과, 최대 병의 갯수

        int buyBottle = 0; // 사야하는 병의 갯수

        while (true) {
            int count = 0;
            int number = N;
            while (number>0) {
                if (number%2 == 1) count ++; // 병의 재분배는 물병의 갯수를 이진수로 만들었을 때 1의 갯수와 구조적 동일하다.
                number = number >> 1; // 오른쪽으로 비트를 민다(자릿수를 내린다) : 2로 나누는 행위와 구조적 동일
            }
            if (count <=K) break; // (탈출 조건) 1의 갯수가 K 이하이면 조건에 부합하므로 반복을 탈출
            buyBottle ++; // 조건에 부합하지 않으므로 사야하는 병의 갯수가 증가한다.
            N ++; // 병을 구입하여 전체 물병의 갯수가 변화함. 다시 처음으로 돌아가 계산을 반복한다.
        }
        System.out.print(buyBottle);
    }
}
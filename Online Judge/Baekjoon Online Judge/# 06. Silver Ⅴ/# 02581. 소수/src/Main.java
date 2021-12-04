import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int m = Integer.parseInt(br.readLine());
        final int n = Integer.parseInt(br.readLine());
        br.close();

        boolean[] isNotPrimeNumber = new boolean[n+1]; // 0~n
        isNotPrimeNumber[0] = isNotPrimeNumber[1] = true;

        for (int devisor=2; devisor<=Math.sqrt(n) ; devisor++) { // sqrt(n)이하의 정수까지 나눴을 때 나눠지는지의 여부로 판별 가능

            if (isNotPrimeNumber[devisor]==true) continue; // 이미 걸러졌으면 다음으로 넘어감
            for (int multiple = devisor * 2; multiple< isNotPrimeNumber.length; multiple+= devisor) {
                isNotPrimeNumber[multiple] = true; // devisor의 배수는 제거한다.
            }
        }

        int sum = 0;
        int min = -1;

        for (int i=m; i<=n; i++) {
            if (isNotPrimeNumber[i] == false) {
                sum += i; // 소수의 합
                if (min==-1) min = i; // 소수의 최솟값 갱신
            }
        }

        if (min == -1) { // 소수가 없는 경우
            System.out.println(min);
        } else { // 소수가 있는 경우
            StringBuilder sb = new StringBuilder();
            sb.append(sum).append('\n').append(min);
            System.out.println(sb);
        }

    }
}
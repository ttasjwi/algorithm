import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(numbers, n, k);
        System.out.print(answer);
    }

    private static int solution(int[] numbers, int n, int k) {
        int answer = 0;
        int cnt = 0; // 0을 1로 바꾼 횟수
        int lt = 0; // 왼쪽 끝값
        int length; // 연속 수열의 길이
        for (int rt = 0; rt < n; rt++) {
            if (numbers[rt] == 0) { // rt가 있는 위치는 무조건 1이여야한다. (rt가 움직이면서 0을 1로 변환시킨다.)
                cnt++; // rt의 위치를 1로 변환했다고 가정한다
            }

            while(cnt > k) { // k보다 더 많이 cnt를 증가시킨 상황이므로 lt를 그만큼 오른쪽으로 움직여야한다.
                if (numbers[lt] == 0) { //
                    cnt --; // lt를 움직이기 전에, rt에 의해 1로 바뀌었던 것을 0으로 되돌린다)
                }
                lt ++; // lt를 움직인다.
            }

            // cnt <=k일 때 (합법적으로 lt가 가장 왼쪽인 시점)
            length = rt - lt + 1; // rt 시점에서 가장 길게 잡을 수 있는 길이
            answer = Math.max(answer, length);
        }
        return answer;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        String answer = solution(numbers, n);
        System.out.print(answer);
    }

    /**
     * 삽입정렬 (최선 - 정렬되어 있을 때 O(N), 최악 : O(N^2))
     * 1. 앞의 데이터를 정렬된 요소로 보고 뒤의 데이터를 정렬되지 않은 요소로 본다.
     * 2. 기본적으로 시작 시점에서, 0번 인덱스는 정렬된 요소로 보고 1번 인덱스부터 반복하면 된다.
     * 3. 정렬된 데이터의 끝값부터 첫값까지 순서대로 비교하면서, head보다 크면 뒤로 민다.
     * 4. head와 작거나 같으면 그 다음 위치에 head를 둔다.
     * 5. 계속 밀어서 더 밀 요소가 없으면 첫값에 head를 둔다.
     */
    private static String solution(int[] numbers, int n) {
        int head;
        int j;
        for (int i=1; i<n; i++) { // 정렬하려는 대상 값
            head = numbers[i]; // head : 정렬하는 대상(현재값)을 담은 변수
            for (j = i-1; j>=0; j--) { // j : 정렬된 범위
                if (head < numbers[j]) numbers[j+1] = numbers[j]; // head보다 크면 뒤로 민다.
                else break; // 같거나 크면 탈출한다. (삽입할 위치를 찾아냄)
            }
            numbers[j+1] = head; // j 다음 위치에 head를 삽입한다.
        }
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(' ');
        }
        return sb.toString();
    }
}

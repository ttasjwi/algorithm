import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 크레인의 한변 길이
        int[][] dolls = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                dolls[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine()); // 크레인 작동 횟수
        int[] moves = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i=0; i<m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(dolls, moves, n);
        System.out.print(answer);
    }

    private static int solution(int[][] dolls, int[] moves, int n) {
        int count = 0; // 터트려서 사라진 인형의 갯수

        Stack<Integer> basket = new Stack<>(); // 바구니
        for (int move : moves) {
            int doll = getDoll(dolls, n, move); // 인형을 뽑아온다.

            if (doll == 0) { // 뽑아온 인형이 없으면 아무 것도 하지 않는다.
                continue;
            }
            if (!basket.isEmpty() && basket.peek() == doll) { // 바구니의 최상단 인형이 뽑은 인형과 같으면
                basket.pop(); // 바구니에서 꺼낸다.
                count += 2; // 인형이 쌍으로 터진다.
            } else { // 바구니가 비어있거나, 바구니 최상단 인형이 뽑은 인형이 다르면
                basket.push(doll); // 바구니에 인형을 쌓는다.
            }
        }
        return count; // 최종적으로 터트려진 전체 인형의 갯수를 반환한다.
    }

    private static int getDoll(int[][] dolls, int n, int move) {
        int doll = 0; // 인형을 저장할 변수. 기본적으로 아무 것도 뽑지 않은 상태는 0이다.
        int index = move - 1; // 뽑을 위치(인덱스)

        for (int j = 0; j< n; j++) { // 인덱스로 이동하여 위에서부터(0,1,2, ...) 인형을 찾는다.
            if (dolls[j][index] != 0) { // 인형을 찾으면
                doll = dolls[j][index]; // 인형을 doll 변수에 저장한다.
                dolls[j][index] = 0; // 해당 위치를 비운다.
                break; // 인형을 찾았으므로 탐색을 중단하고 반복을 탈출한다.
            }
        }
        return doll; // doll 변수에 저장된 값을 반환한다.
    }
}

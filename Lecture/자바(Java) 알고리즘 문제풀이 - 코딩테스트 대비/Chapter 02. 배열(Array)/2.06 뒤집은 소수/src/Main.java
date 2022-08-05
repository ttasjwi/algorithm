import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            words[i] = st.nextToken();
        }
        String answer = solution(words);
        System.out.print(answer);
    }

    private static String solution(String[] words) {
        StringBuilder sb = new StringBuilder();

        boolean[] isCompositeNumber = new boolean[100001];
        isCompositeNumber[1] = true;

        for (int i=2; i<isCompositeNumber.length; i++) {
            if (!isCompositeNumber[i]) {
                for (int j=i+i; j<isCompositeNumber.length; j +=i) {
                    isCompositeNumber[j] = true;
                }
            }
        }

        for (int i=0; i< words.length; i++) {
            int reverseNumber = Integer.parseInt(new StringBuilder(words[i]).reverse().toString());
            if (!isCompositeNumber[reverseNumber]) {
                sb.append(reverseNumber).append(' ');
            }
        }
        return sb.toString();
    }

    private static int reverseNumber(int number) {
        int reverseNumber = 0;
        int tmp;

        while(number > 0) { // 숫자가 0보다 큰 동안 반복 돌린다.
            tmp = number%10; // 일의 자리 숫자를 추출한다.
            reverseNumber = reverseNumber * 10 + tmp; // 숫자 뒤에 일의 자리 숫자를 덧붙인다.
            number = number/10; // number를 10으로 나누어, 자리수를 끝을 줄인다.
        }
        return reverseNumber;
    }
}

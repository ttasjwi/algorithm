import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String answer = solution(word);
        System.out.print(answer);
    }

    private static String solution(String word) {
        word = new StringBuilder(word).append(' ').toString();

        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i=0; i<word.length()-1; i++) {
            char current = word.charAt(i);
            char next = word.charAt(i+1);

            if (current == next) {
                count ++; // 다음 문자가 같으면 카운트 증가
            } else { // 다음이 다른 문자면 여태 누적해온걸 StringBuilder에 반영한다.
                sb.append(current);
                if (count >= 2) {
                    sb.append(count);
                }
                count = 1; //카운트를 초기화한다.
            }
        }
        return sb.toString();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        br.close();

        String answer = solution(word);
        System.out.print(answer);
    }

    public static String solution(String word) {
        char[] charArray = word.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (!Character.isAlphabetic(charArray[left])) {
                // left가 특수문자일 때는 뒤집지 못 함
                left  ++;
            } else if (!Character.isAlphabetic(charArray[right])) {
                // left가 알파벳이고 right가 특수문자이면 뒤집지 못 함
                right --;
            } else {
                // left가 알파벳이고 right가 알파벳이면 뒤집을 수 있음
                char tmp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = tmp;
                left ++;
                right --;
            }
        }
        return String.valueOf(charArray);
    }
}

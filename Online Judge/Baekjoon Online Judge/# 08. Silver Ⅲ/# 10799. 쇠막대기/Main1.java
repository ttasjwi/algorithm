import java.io.IOException;

public class Main1 {

    public static void main(String[] args) throws IOException {
        int answer = getCount();
        System.out.print(answer);
    }

    private static int getCount() throws IOException {
        int count = 0;
        int stick = 0;
        int before = 0;
        int input;

        while ((input = System.in.read()) != '\n') {
            if (input == '(') { // 기본적으로 '('은 stick으로 본다.
                stick++;
            } else {
                stick --; // '('이 아니면 일단 stack의 요소를 하나 뽑는다.
                if (before == '(') { // 이전 문자가 '('이면 레이저
                    count += stick; // stick의 갯수만큼 count를 증가
                } else {
                    count ++; // stick이 끝난 것이므로 count +1
                }
            }
            before = input; // 이전 문자를 input으로 한다.
        }
        return count;
    }
}

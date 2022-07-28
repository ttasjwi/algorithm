import java.io.IOException;

public class Main {

    private static final int DAY_SECOND = 24 * 60 * 60;
    private static final int HOUR_SECOND = 60 * 60;
    private static final int MINUTE_SECOND = 60;

    public static void main(String[] args) throws IOException {
        int second = 0; // 전체 시간을 초로 환산
        second += readInt() * HOUR_SECOND; // 시
        second += readInt() * MINUTE_SECOND; // 분
        second += readInt(); // 초
        second += readInt(); // 추가 초

        StringBuilder sb = new StringBuilder();

        second = second%DAY_SECOND; // 1일 이상의 초 제거
        sb.append(second/HOUR_SECOND).append(' '); // 남은 시 환산

        second = second%HOUR_SECOND; // 1시간 이상의 초 제거
        sb.append(second/MINUTE_SECOND).append(' '); // 남은 분 환산

        second = second%MINUTE_SECOND; // 1분 이상의 초 제거
        sb.append(second);

        System.out.print(sb);
    }

    public static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + input - 48;
            }
        }
    }
}

import java.io.IOException;

public class Main1 {

    public static void main(String[] args) throws IOException {
        int answer = readCharCount();
        System.out.print(answer);
    }

    public static int readCharCount() throws IOException {
        int count = 0;
        int input;

        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return count;
            } else {
                count ++;
            }
        }
    }
}

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = readInt();
        int b = readInt();
        System.out.print(a-b);
    }

    public static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == '\n'|| input == ' ') {
                return value;
            }
            value = value + (input - 48);
        }
    }

}

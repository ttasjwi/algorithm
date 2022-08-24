import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = readReverse();
        int b = readReverse();
        int answer = Math.max(a, b);
        System.out.print(answer);
    }

    private static int readReverse() throws IOException {
        int value = 0;

        value += (System.in.read() - 48);
        value += (System.in.read() - 48) * 10;
        value += (System.in.read() - 48) * 100;
        System.in.read();
        return value;
    }

}

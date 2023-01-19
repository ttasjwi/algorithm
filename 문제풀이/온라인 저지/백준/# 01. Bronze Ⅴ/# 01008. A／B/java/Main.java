import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = System.in.read() - 48;
        System.in.read();
        double b = System.in.read() - 48;
        System.out.print(a/b);
    }

}

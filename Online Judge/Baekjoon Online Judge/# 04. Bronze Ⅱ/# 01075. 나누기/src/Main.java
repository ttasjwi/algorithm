import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt()/100*100;
        int f = readInt();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<100; i++) {
            if ((n+i)%f == 0) {
                if (i < 10) {
                    sb.append(0).append(i);
                } else {
                    sb.append(i);
                }
                break;
            }
        }
        System.out.print(sb);
    }

    public static int readInt() throws IOException {
        int value = 0;
        int input;

        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return value;
            } else {
                value = value *10 + input - 48;
            }
        }
    }
}

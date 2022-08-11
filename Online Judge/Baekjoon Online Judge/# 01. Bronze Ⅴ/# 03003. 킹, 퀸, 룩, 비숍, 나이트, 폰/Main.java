import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException  {
        int[] counts = new int[]{1,1,2,2,2,8};

        StringBuilder sb = new StringBuilder();
        int diff;
        for (int i=0; i<6; i++) {
            diff = counts[i] - readInt();
            sb.append(diff).append(' ');
        }
        System.out.print(sb);
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        double[] scores = new double[n];
        int maxScore = Integer.MIN_VALUE;
        double answer = 0;
        for (int i=0; i<n; i++) {
            answer += scores[i] = readInt();
            if (scores[i] > maxScore) maxScore = (int) scores[i];
        }
        answer = answer/maxScore/n * 100;
        System.out.print(answer);
    }

    private static int readInt() throws IOException {
        int value = 0;
        int input;
        while(true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return value;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }

}

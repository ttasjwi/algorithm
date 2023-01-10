import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] counter = new int[7];

        for (int i=0; i<3; i++) {
            counter[readInt()]++;
        }

        int answer;

        int maxNumber = 0;

        for (int i=1; i<=6; i++) {
            if (counter[i] == 3) {
                answer = 10000 + (i * 1000);
                System.out.print(answer);
                return;
            } else if (counter[i] == 2) {
                answer = 1000 + i * 100;
                System.out.print(answer);
                return;
            } else if (counter[i] == 1){
                maxNumber = (i > maxNumber) ? i : maxNumber;
            } else {
                continue;
            }
        }
        answer = maxNumber * 100;
        System.out.print(answer);
    }

    public static int readInt() throws IOException {
        int value = 0;
        int input;
        while(true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return value;
            } else {
                value = input - 48;
            }
        }
    }
}

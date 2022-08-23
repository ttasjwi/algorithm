import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] counter = new int[26];
        int input;

        while((input= System.in.read()) >= 65) {
            if (input>=97) {
                input = input - 32;
            }
            counter[input-65] ++;
        }

        char answer = ' ';
        int maxCount = Integer.MIN_VALUE;
        for (int i=0; i<26; i++) {
            if (counter[i] > maxCount) {
                maxCount = counter[i];
                answer = (char) (i+65);
            } else if (counter[i] == maxCount) {
                answer = '?';
            }
        }
        System.out.print(answer);
    }

}

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] firstIndexes = new int[26];
        for (int i=0; i<26; i++) firstIndexes[i] = -1;

        int index = 0;
        int input;
        while((input = System.in.read()) != '\n') {
            if (firstIndexes[input - 97] == -1) {
                firstIndexes[input-97] = index;
            }
            index ++;
        }

        StringBuilder sb = new StringBuilder();
        for (int firstIndex : firstIndexes) {
            sb.append(firstIndex).append(' ');
        }
        System.out.print(sb);
    }

}

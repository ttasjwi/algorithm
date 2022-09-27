import java.io.IOException;

public class Main {
    private static int n; // 숫자 갯수
    private static int m; // 선택하는 숫자의 갯수
    private static int[] selectedNumbers; // 선택된 숫자
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        n = readInt();
        m = readInt();
        String answer = solution();
        System.out.print(answer);
    }

    private static String solution() {
        selectedNumbers = new int[m];
        sb = new StringBuilder();
        dfs(0, 1);
        return sb.toString();
    }

    private static void dfs(int index, int start) {
        if (index == m) {
            for (int selectedNumber : selectedNumbers) {
                sb.append(selectedNumber).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i=start; i<=n; i++) {
            selectedNumbers[index] = i;
            dfs(index + 1, i+1);
        }
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

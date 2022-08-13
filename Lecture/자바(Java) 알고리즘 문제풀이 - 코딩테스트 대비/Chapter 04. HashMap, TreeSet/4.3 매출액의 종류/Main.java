import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        br.close();

        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        String answer = solution(numbers, n, k);
        System.out.print(answer);
    }

    private static String solution(int[] numbers, int n, int k) {
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int i=0; i<k; i++) {
            int number = numbers[i];
            counter.put(number, counter.getOrDefault(number, 0) + 1);
        }
        sb.append(counter.size()).append(' ');

        for (int rt=k; rt<n; rt++) {
            int ltNumber = numbers[rt-k];
            int rtNumber = numbers[rt];

            if (counter.get(ltNumber) == 1) { // 하나 남아 있으면 제거
                counter.remove(ltNumber);
            } else {
                counter.put(ltNumber, counter.get(ltNumber) - 1);
            }

            counter.put(rtNumber, counter.getOrDefault(rtNumber, 0) + 1);
            sb.append(counter.size()).append(' ');
        }

        return sb.toString();
    }
}

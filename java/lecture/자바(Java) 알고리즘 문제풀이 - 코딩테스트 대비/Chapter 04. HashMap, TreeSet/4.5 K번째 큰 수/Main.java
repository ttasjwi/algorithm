import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(numbers, n, k);
        System.out.print(answer);
    }

    private static int solution(int[] numbers, int n, int k) {
        TreeSet<Integer> sums = new TreeSet<>(Comparator.reverseOrder());

        for (int t=0; t<n; t++) {
            for (int u=t+1; u<n; u++) {
                for (int v=u+1; v<n; v++) {
                    sums.add(numbers[t] + numbers[u] + numbers[v]);
                }
            }
        }

        if (sums.size() < k) {
            return -1;
        }

        return (Integer) sums.toArray()[k-1];
    }
}

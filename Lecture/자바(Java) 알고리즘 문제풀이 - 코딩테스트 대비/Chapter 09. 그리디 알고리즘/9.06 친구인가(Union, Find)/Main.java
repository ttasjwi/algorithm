import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n; // 학생 수
    private static int m; // 숫자 쌍의 갯수
    private static int[] parent; // 부모

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i=1; i<=n; i++) parent[i] = i;
        m = Integer.parseInt(st.nextToken());

        int a, b;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
        }

        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        String answer = (findParent(a) == findParent(b)) ? "YES" : "NO";
        System.out.print(answer);
    }

    private static void unionParent(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else if (rootA > rootB) {
            parent[rootA] = rootB;
        }
    }


    /**
     * 루트를 찾아 반환
     */
    private static int findParent(int x) {
        // 루트가 아니라면, 루트를 찾을 때까지 재귀적 호출
        if (parent[x] == x) {
            return parent[x];
        }
        return parent[x] = findParent(parent[x]); // 경로 압축
    }

}

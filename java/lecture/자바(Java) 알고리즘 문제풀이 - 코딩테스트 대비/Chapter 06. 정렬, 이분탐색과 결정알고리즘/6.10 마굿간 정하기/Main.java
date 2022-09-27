import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 마굿간의 갯수 (  3<=n<=200,000)
        int c = Integer.parseInt(st.nextToken()); // 말의 수 (2<= c < =n)

        int[] barns = new int[n]; // 마굿간들
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i = 0; i < n; i++) {
            barns[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(barns, n, c); // 가장 가까운 두 말의 최대거리
        System.out.print(answer);
    }

    private static int solution(int[] barns, int n, int c) {
        int answer = -1;
        Arrays.sort(barns);

        // 탐색하고자 하는 것 : 가장 가까운 두 말 사이의 거리 (최대)
        int lt = 1; // 마굿간이 바로 옆에 붙어있을 때
        int rt = barns[n-1] - barns[0]; // 검색 최대 범위(첫번째 마굿간 ~ 마지막 마굿간 거리)
        int mid;
        int maxHorseCount;

        while(lt <= rt) {
            mid = (lt + rt) / 2; // 가장 가까운 두 말 사이의 거리
            maxHorseCount = getMaxHorseCount(barns, n, mid); // 제한에 맞게 배치했을 때 배치할 수 있는 말의 최대 갯수

            if (maxHorseCount >= c) { // 최소거리 제한이 느슨해서 더 많이 배치할 수 있다면
                answer = mid;
                lt = mid + 1; // 최소거리 제한 조건을 좀 더 늘려본다. (더 엄격하게 해서 최적화 시도)
            } else {
                rt = mid - 1; // 말을 전부 배치할 수 없다면 제한 조건을 좀 더 느슨하게 해본다.
            }
        }
        return answer;
    }

    // 거리 최소 제한에 맞게 말을 순서대로 배치했을 때 가능한 배치 말의 최대 갯수
    private static int getMaxHorseCount(int[] barns, int n, int minDistance) {
        int count = 1; // 배치 가능한 말의 수
        int before = barns[0];
        int distance; // 이전 말과의 거리
        for (int i=1; i<n; i++) {
            distance = barns[i] - before;

            if (distance >= minDistance) { // 최소거리 이상 벌려져있을 때 배치 가능하다.
                count ++;
                before = barns[i];
            }
        }
        return count;
    }

}

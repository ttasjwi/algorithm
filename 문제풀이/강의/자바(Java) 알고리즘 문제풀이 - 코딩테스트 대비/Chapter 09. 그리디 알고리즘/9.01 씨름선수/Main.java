import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static Body[] bodies;

    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bodies = new Body[n];

        StringTokenizer st;
        int height, weight;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            height = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            bodies[i] = new Body(height, weight);
        }
        br.close();
    }

    private static int solution() {
        Arrays.sort(bodies); //키를 기준으로 내림차순 정렬
        int answer = 0;
        int maxWeight = Integer.MIN_VALUE;
        for (Body body : bodies) {
            if (body.weight > maxWeight) { // 키는 앞의 사람이 무조건 크고, 몸무게가 더 커야 살아남음
                answer ++;
                maxWeight = body.weight;
            }
        }
        return answer;
    }
}



class Body implements Comparable<Body> {

    int height;
    int weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body other) {
        return other.height - this.height; // 키 기준 내림차순 정렬
    }
}

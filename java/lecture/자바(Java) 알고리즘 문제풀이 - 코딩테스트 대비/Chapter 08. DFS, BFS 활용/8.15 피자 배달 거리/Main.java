import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n; // 격자 가로 세로
    private static int m; // 몇 개

    private static final ArrayList<Point> homes = new ArrayList<>(); // 집들
    private static final ArrayList<Point> pizzas = new ArrayList<>(); // 피자집들
    private static final List<List<Point>> combinations = new ArrayList<>(); // 피자집을 m개씩 선택해서 조합한 모음

    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char tmp;
        for (int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 1; x <= n; x++) {
                tmp = st.nextToken().charAt(0);
                if (tmp == '1') homes.add(new Point(x, y));
                else if (tmp == '2') pizzas.add(new Point(x, y));
            }
        }
    }

    private static int solution() {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < m; i++) points.add(null);
        combination(0, 0, points); // 피자집들 중 m개를 선택한 것 모든 경우들을 리스트화
        return minCityPizzaDistance();
    }

    private static void combination(int start, int index, List<Point> points) {
        if (index == m) {
            combinations.add(new ArrayList<>(points));
            return;
        }
        for (int i = start; i < pizzas.size(); i++) {
            points.set(index, pizzas.get(i));
            combination(i + 1, index + 1, points);
        }
    }

    private static int minCityPizzaDistance() {
        int answer = Integer.MAX_VALUE; // 각 조합별 도시의 피자배달거리 최솟값
        for (List<Point> combination : combinations) {
            answer = Math.min(answer, cityPizzaDistance(combination));
        }
        return answer;
    }

    /**
     * 피자집들, 집들이 주어졌을 때 그 도시의 피자 배달거리
     */
    private static int cityPizzaDistance(List<Point> combination) {
        int sum;
        sum = 0;
        for (Point home : homes) {
            sum += home.pizzaDistance(combination);
        }
        return sum;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int pizzaDistance(List<Point> pizzas) {
        int min;
        min = Integer.MAX_VALUE;
        for (Point pizza : pizzas) {
            min = Math.min(min, distance(pizza));
        }
        return min;
    }

    private int distance(Point other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

}

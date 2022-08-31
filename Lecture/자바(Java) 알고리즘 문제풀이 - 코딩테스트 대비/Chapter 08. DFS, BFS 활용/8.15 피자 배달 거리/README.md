# 8.15 피자 배달 거리
- 분류 : dfs
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.15)

---

## 문제의 용어 해석
- 집의 피자 배달 거리 : 어떤 한 집을 기준으로, 해당 도시에 존재하는 피자집들과의 거리들 중 최솟값
- 도시의 피자 배달거리 : 각 '집의 피자 배달 거리'의 합
- 구하는 것 : 피자집 m개를 살린 여러가지 경우 중에서 도시의 피자 배달거리의 최솟값

---

### Point
```java
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
```
- pizzaDistance : 피자집들이 주어졌을 때 해당 지점을 기준으로 피자 배달거리
- distance : 문제에서 정의한 '거리'

### 정적 변수
```java
    private static int n; // 격자 가로 세로
    private static int m; // 몇 개

    private static final ArrayList<Point> homes = new ArrayList<>(); // 집들
    private static final ArrayList<Point> pizzas = new ArrayList<>(); // 피자집들
    private static final List<List<Point>> combinations = new ArrayList<>(); // 피자집을 m개씩 선택해서 조합한 모음
```
- homes : 집들
- pizzas : 피자집들
- combinations : 피자집들 중 m개 택한 조합들을 모은 2차원 `ArrayList`

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }
```

### input
```java
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
```
- 1을 입력받으면 homes에 해당 지점 point 생성 후 저장
- 2를 입력받으면 pizzas에 해당 지점 point 생성 후 저장

### solution
```java
    private static int solution() {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < m; i++) points.add(null);
        combination(0, 0, points); // 피자집들 중 m개를 선택한 것 모든 경우들을 리스트화
        return minCityPizzaDistance();
    }
```
- 전체 피자집들 중 m개를 선택한 피자집 조합들을 생성한 후, 이를 기반으로 minCityPizzaDistance를 통해 값을 구해 반환

### minCityPizzaDistance
```java
    private static int minCityPizzaDistance() {
        int answer = Integer.MAX_VALUE; // 각 조합별 도시의 피자배달거리 최솟값
        for (List<Point> combination : combinations) {
            answer = Math.min(answer, cityPizzaDistance(combination));
        }
        return answer;
    }
```
- 조합들을 토대로, 도시피자배달거리의 최솟값을 구해 반환한다

### CityPizzaDistance
```java
    private static int cityPizzaDistance(List<Point> combination) {
        int sum;
        sum = 0;
        for (Point home : homes) {
            sum += home.pizzaDistance(combination);
        }
        return sum;
    }
```
- 도시피자배달거리(집마다 주어진 피자집들 사이의 피자배달거리를 구하고 이들을 누적한 값)을 반환한다.




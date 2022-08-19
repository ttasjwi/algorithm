# 6.07 좌표정렬

- 분류 : 정렬(compareTo 활용)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.07)

---

## 풀이
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[i] = new Coordinate(x, y);
        }
        br.close();

        String answer = solution(coordinates, n);
        System.out.print(answer);
    }
```
- 좌표를 입력받을 때, Coordinate 객체를 생성하여 로직에 사용하도록 했다.
- 로직 결과 문자열을 sout으로 출력한다.

### Coordinate 클래스
```java
class Coordinate implements Comparable<Coordinate> {

    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}
```
- `Comparable` 인터페이스를 구현했다.

### 로직
```java
    private static String solution(Coordinate[] coordinates, int n) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(coordinates);
        for (Coordinate coordinate : coordinates) {
            sb.append(coordinate.x).append(' ').append(coordinate.y).append('\n');
        }
        return sb.toString();
    }
```
- 정렬한다. (Comparable이 구현되어 있으므로 그대로 정렬할 수 있다.)
- for문을 돌면서 좌표값을 StringBuilder에 append 하고, 문자열로 반환한다.

---

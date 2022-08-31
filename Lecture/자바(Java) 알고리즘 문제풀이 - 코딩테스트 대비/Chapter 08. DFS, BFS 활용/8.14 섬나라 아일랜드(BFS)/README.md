# 8.14 섬나라 아일랜드(BFS)
- 분류 : bfs
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.14)

---

## 풀이

### Point
```java
class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```


### 정적 변수
```java
private static final int[] DIRECTION_X = {1, 1, 0, -1, -1, -1, 0, 1}; // 동, 남동, 남, 남서, 서, 북서, 북, 북동
private static final int[] DIRECTION_Y = {0, 1, 1, 1, 0, -1, -1, -1}; // 동, 남동, 남, 남서, 서, 북서, 북, 북동

private static int n; // 격자판의 가로 세로
private static int[][] board; // 격자판 정보
private static int answer = 0;
```
- 팔방 방향 배열
- 격자판 정보

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.print(answer);
    }
```

### input
```java
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }
```
- 격자판 입력

### solution
```java
    private static void solution() {
        Queue<Point> queue = new LinkedList<>();
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (board[y][x] == 1) {
                    answer++;
                    bfs(x, y, queue); // 섬을 찾으면 너비 탐색을 하여 전부 방문처리한다.
                }
            }
        }
    }
```
- 1을 찾아내면 answer를 증가시킨다.
- 해당 지점을 중심으로 bfs해서 모두 방문처리한다

### bfs
```java
    private static void bfs(int startX, int startY, Queue<Point> queue) {
        queue.offer(new Point(startX, startY));
        board[startY][startX] = 0;
        Point current;
        int nextX, nextY;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int i = 0; i < 8; i++) {
                nextX = current.x + DIRECTION_X[i];
                nextY = current.y + DIRECTION_Y[i];

                if (isValidPosition(nextX, nextY) && board[nextY][nextX] == 1) {
                    board[nextY][nextX] = 0;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
    }
```
- 시작점을 queue에 offer한다
- 방문처리한다
- 큐가 빌때까지 반복한다
  - 팔방을 탐색하여 값이 1인 지점을 큐에 삽입 및 방문처리한다

---

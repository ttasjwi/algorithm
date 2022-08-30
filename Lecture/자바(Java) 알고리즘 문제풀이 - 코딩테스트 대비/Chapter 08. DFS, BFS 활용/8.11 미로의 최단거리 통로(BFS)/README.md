# 8.11 미로의 최단거리 통로(BFS)
- 분류 : bfs
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.11)

---

## 풀이

## Point 클래스
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
    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동 남 서 북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1}; // 동 남 서 북
    private static int[][] grid = new int[8][8];
    private static int[][] dis = new int[8][8];
```
- grid : 방문 가능 배열
  - 1 : 벽
  - 0 : 통과 가능
  - 2 : 지나간 곳

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = bfs();
        System.out.print(answer);
    }
```

### input
```java
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 7; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }
```
- 행, 열에 숫자 입력받아 저장

### BFS
```java
    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        dis[1][1] = 0;
        grid[1][1] = 2; // 방문
        queue.offer(new Point(1, 1));

        Point current;
        int nearX, nearY;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int j = 0; j < 4; j++) {
                nearX = current.x + DIRECTION_X[j];
                nearY = current.y + DIRECTION_Y[j];
                if (nearY == 7 && nearX == 7) return dis[current.y][current.x] + 1;
                if (isValidPosition(nearX, nearY) && grid[nearY][nearX] == 0) {
                    grid[nearY][nearX] = 2;
                    dis[nearY][nearX] = dis[current.y][current.x] + 1;
                    queue.offer(new Point(nearX, nearY));
                }
            }
        }
        return -1;
    }
```
- 큐에 시작 위치를 삽입한다.
- 큐가 빌때까지 요소를 꺼낸다. (매순간 큐에서 꺼내지는 위치들은 방문하지 않은 가장 가까운 위치에 존재하는 위치다)
  - 근처 4방의 요소를 확ㅇ니하여 이동할 수 있으면 방문처리하고, 해당 위치의 최단거리를 갱신한다.

---

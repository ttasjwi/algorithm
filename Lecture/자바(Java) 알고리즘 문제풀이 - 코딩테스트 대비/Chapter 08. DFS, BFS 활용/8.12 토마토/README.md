# 8.12 토마토
- 분류 : bfs
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.12)

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
- 좌표 저장

### 정적 변수
```java
    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동 남 서 북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1}; // 동 남 서 북

    private static int m; // 가로
    private static int n; // 세로
    private static int[][] store; // 토마토 저장 상태
```

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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        store = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                store[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
```
- store 초기화
  - 여기서 1로 마킹되어 있는 것은 익은 토마토를 의미하기도 하지만, `처음 익은 일자 +1`을 의미하기도 한다.

### bfs
```java

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (store[i][j] == 1) {
                    queue.offer(new Point(j, i));
                }
            }
        }

        Point current;
        int nearX, nearY;
        while(!queue.isEmpty()) {
            current = queue.poll();
            for (int j=0; j<4; j++) {
                nearX = current.x + DIRECTION_X[j];
                nearY = current.y + DIRECTION_Y[j];
                if (isValidPosition(nearX, nearY) && store[nearY][nearX] == 0) {
                    store[nearY][nearX] = store[current.y][current.x] + 1;
                    queue.offer(new Point(nearX, nearY));
                }
            }
        }
```
1. store를 탐색해서, 저장값이 1이면(익은 토마토면) queue에 Point를 offer한다.
2. 큐가 빌 때까지 다음을 반복한다
   - 큐에서 익은 토마토의 위치를 꺼낸다.
   - 익은 토마토의 위치 기준으로 동남서북을 확인하여 안 익은 토마토가 있으면 해당 토마토의 익은 일자를 갱신한다.
   - queue에 offer한다.
```java
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (store[i][j] > max) {
                    max = store[i][j];
                }
                if (store[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max -1; // 모두 익었을 경우. 최댓값-1이 모두 숙성하는데 소요되는 날짜
    }
```
3. store를 탐색하면서 현재 store의 저장값들의 최댓값을 갱신시킨다.
4. 만약 저장값이 0인 지점이 있다면, 안 익은 토마토가 남아있다는 뜻이므로 -1을 반환한다.
5. 최댓값 -1을 반환한다. (모두 숙성하는데 소요되는 날짜)
   - 첫날 모두 익었다면 최댓값 -1이 0이 되므로 문제에서 의도한 대로 0을 반환하게 된다.

---

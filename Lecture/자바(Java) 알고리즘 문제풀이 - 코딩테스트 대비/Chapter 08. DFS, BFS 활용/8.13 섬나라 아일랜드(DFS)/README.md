# 8.13 섬나라 아일랜드(DFS)
- 분류 : bfs
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.12)

---

## 풀이

### 정적변수
```java
    private static final int[] DIRECTION_X = {1, 1, 0, -1, -1, -1, 0, 1}; // 동, 남동, 남, 남서, 서, 북서, 북, 북동
    private static final int[] DIRECTION_Y = {0, 1, 1, 1, 0, -1, -1, -1}; // 동, 남동, 남, 남서, 서, 북서, 북, 북동

    private static int n; // 격자판의 가로 세로
    private static int[][] board; // 격자판 정보

    private static int answer = 0;
```
- 팔방 방향 배열을 준비해둔다


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
- 격자판을 초기화한다

### solution
```java
    private static void solution() {
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (board[y][x] == 1) {
                    answer++;
                    dfs(x, y); // 섬을 찾으면 깊이 탐색을 하여 전부 방문처리한다
                }
            }
        }
    }
```
- 2중 for문을 돌아서 값이 1인 지점을 섬으로 간주하고 연결된 곳을 dfs로 모두 탐색하여 방문처리한다.
  - answer를 증가시킨다.

### DFS
```java
    private static void dfs(int startX, int startY) {
        board[startY][startX] = 0; // 방문 처리

        int nextX, nextY;
        for (int i = 0; i < 8; i++) {
            nextX = startX + DIRECTION_X[i];
            nextY = startY + DIRECTION_Y[i];

            if (isValidPosition(nextX, nextY) && board[nextY][nextX] == 1) {
                dfs(nextX, nextY);
            }
        }
    }
```
- 방문처리한다.
- 팔방을 뒤져서 값이 `1`인 지점을 dfs한다

---

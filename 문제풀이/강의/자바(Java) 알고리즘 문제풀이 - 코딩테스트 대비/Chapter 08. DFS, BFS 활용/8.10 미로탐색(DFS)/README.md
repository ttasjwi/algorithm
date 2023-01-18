# 8.10 미로탐색(DFS)
- 분류 : dfs
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.10)

---

## 풀이

### 정적 변수
```java
    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동 남 서 북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1}; // 동 남 서 북
    private static int[][] grid = new int[8][8]; // 2 : 지나간 경로다 1 : 막혀있다. 0 : 지나갈 수 있다.
    private static int answer = 0;
```

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        dfs(1, 1);
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

### dfs
```java
    private static void dfs(int row, int column) {
        if (row == 7 && column == 7) { // 도착지점이면 answer 증가
            answer++;
            return;
        }
        grid[row][column] = 2; // 현재 방문한 위치는 방문했으므로 2로 체크한다.
        int nearRow, nearColumn;
        for (int i = 0; i < 4; i++) {
            nearRow = row + DIRECTION_Y[i];
            nearColumn = column + DIRECTION_X[i];
            if (isValidPosition(nearRow, nearColumn) && grid[nearRow][nearColumn] == 0) {
                dfs(nearRow, nearColumn); // 방문한다
            }
        }
        grid[row][column] = 0; // 이 지점은 탐색이 완료됐으므로 0으로 되돌린다.
    }
```
- 현재 행, 열이 7이면 answer 증가 후 반환
- 현재 위치를 방문처리
- 동남서북 탐색하여 유효한 방문 가능한 위치가 있으면 dfs
- 방문을 마치면 다시 통과 가능한 상태로 되돌림

### isValidPosition
```java
    private static boolean isValidPosition(int column, int row) {
        return (1 <= column && column <= 7) && (1 <= row && row <= 7);
    }
```
- 올바른 범위에 포함되어 있는 지 여부를 반환

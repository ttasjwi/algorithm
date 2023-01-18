# 7.12 경로 탐색(DFS)
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.12)

---

## 풀이

### 입출력

### 정적 변수
```java
    private static int n; // 정점 갯수
    private static boolean[][] graph; // 인접행렬
    private static boolean[] visited; // 방문 배열
    private static int answer = 0; // 정답
```

### 입출력
```java
    public static void main(String[] args) throws IOException {
        n = readInt(); // 정점의 개수
        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        int m = readInt();
        int p1, p2;
        for (int i=0; i<m; i++) {
            p1 = readInt();
            p2 = readInt();
            graph[p1][p2] = true;
        }
        solution();
        System.out.print(answer);
    }
```
- n을 입력받고 인접행렬과 방문배열을 초기화한다.
- 인접행렬 graph에 연결 관계를 저장한다. (단방향)
- `solution()` 실행 후 answer를 출력한다.

### `solution()`
```java
    private static void solution() {
        visited[1] = true;
        DFS(1);
    }
```
- 1번 노드를 방문처리
- `DFS(1)`을 호출한다.


### `DFS`
```java
    private static void DFS(int i) {
        if (i == n) {
            answer ++;
            return;
        }
        for (int j=1; j<=n; j++) {
            if (!visited[j] && graph[i][j]) {
                visited[j] = true;
                DFS(j);
                visited[j] = false;
            }
        }
    }
```
- `i==n` : 도착했으므로, answer를 증가
- 아닐 경우
  - 1~n까지 순회한다.
  - 방문처리가 되지 않았고, 인접행렬에서 연결되어 있는 곳을 찾은 뒤
  - 방문처리 하고, DFS를 수행한 뒤, 방문처리를 해제한다.

---

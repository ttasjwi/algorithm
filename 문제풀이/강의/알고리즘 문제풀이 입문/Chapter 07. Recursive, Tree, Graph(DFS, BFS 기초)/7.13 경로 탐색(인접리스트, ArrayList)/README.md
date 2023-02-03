# 7.13 경로 탐색(인접리스트)
- 분류 : DFS, 인접 리스트
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.13)

---

## 인접행렬 vs 인접리스트
- 인접행렬은 작은 갯수의 정점에 대해서는 그럭저럭 다룰 수 있지만 정점의 개수가 10000, 100만 이렇게 커지면 메모리 공간을 비효율적으로 차지한다.
- 탐색 시 for문으로 전부 돌면 매우 시간이 오래 걸린다.

---

## 풀이

### 입출력

### 정적 변수
```java
private static int n;
private static ArrayList<ArrayList<Integer>> graph;
private static boolean[] visited;
private static int answer = 0;
```
- 인접행렬 대신, ArrayList를 사용하면 공간을 아낄 수 있다.
- 모두 탐색하지 않고 인접한 것만 탐색하기에 시간도 더 줄어든다.


### 입출력
```java
    public static void main(String[] args) throws IOException {
        n = readInt(); // 정점의 개수
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];

        int m = readInt();
        int p1, p2;
        for (int i=0; i<m; i++) {
            p1 = readInt();
            p2 = readInt();
            graph.get(p1).add(p2);
        }
        solution();
        System.out.print(answer);
    }
```
- n을 입력받고 인접 리스트과 방문배열을 초기화한다.
- 인접리스트 graph에 연결 관계를 저장한다. (단방향)
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
    private static void DFS(int v) {
        if (v == n) {
            answer ++;
            return;
        }
        for (int nv : graph.get(v)) {
            if (!visited[nv]) {
                visited[nv] = true;
                DFS(nv);
                visited[nv] = false;
            }
        }
    }
```
- `i==n` : 도착했으므로, answer를 증가
- 아닐 경우
  - 1~n까지 순회한다.
  - 인접리스트에서 방문처리가 되지 않은 곳을
  - 방문처리 하고, DFS를 수행한 뒤, 방문처리를 해제한다.

---

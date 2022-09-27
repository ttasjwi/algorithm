# 7.14 그래프 최단거리(BFS)
- 분류 : BFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.14)

---

## 거리 배열?
- 단순히 간선간 거리가 1로 고정되어 있는 경우에는 레벨링이 편리하지만
- 나중에 간선간 거리가 제각각 다른 경우에는 별도로 거리 배열을 통해 다루는 것이 편리하다.
- 여기서는 거리배열, BFS를 사용해 풀어보도록 한다.

---

## 풀이

### 정적 상수
```java
private static int n; // 정점의 갯수
private static ArrayList<ArrayList<Integer>> graph; // 인접 리스트
private static boolean[] checked; // 방문 배열

private static int[] dis; // 거리 배열
```

### main
```java
    public static void main(String[] args) throws IOException {
        n = readInt(); // 정점의 개수
        graph = new ArrayList<>();
        dis = new int[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        checked = new boolean[n + 1];

        int m = readInt();
        int p1, p2;
        for (int i = 0; i < m; i++) {
            p1 = readInt();
            p2 = readInt();
            graph.get(p1).add(p2);
        }
        String answer = solution();
        System.out.print(answer);
    }
```

### solution
```java
    private static String solution() {
        BFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(dis[i]).append(' ');
        }
        return sb.toString();
    }
```
- BFS 수행
- 거리배열의 요소를 순서대로 StringBuilder에 append 한다.

### BFS
```java
    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        dis[v] = 0;
        checked[v] = true;
        queue.offer(v);

        int current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int next : graph.get(current)) { // 인접한 요소들을 탐색한다.
                if (!checked[next]) {
                    checked[next] = true;
                    dis[next] = dis[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
```
- 시작 노드의 거리를 0으로 초기화한다.
- 시작 위치를 방문처리 한다.
- 큐에 시작 위치를 삽입한다.
- 큐가 빌 때까지 반복한다.
  - `current` : 큐에서 꺼낸 노드
  - 큐와 연결된 방문되지 않은 인접 노드를 찾아내, 방문처리하고 거리를 현 위치 +1로 잡는다. 큐에 인접노드를 삽입한다.
  - 반복

---

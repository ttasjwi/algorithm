# 9.05 다익스트라 알고리즘
- 분류 : 다익스트라 알고리즘, 그리디 알고리즘, Priority Queue
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.05)

---

## 그리디 알고리즘
- 매 순간의 최적해가 전체의 최적해

## Priority Queue
- 정렬 기준으로 가장 먼저 오는 것을 먼저 꺼냄

## 다익스트라 알고리즘
- 매 순간 최소비용의 노드를 방문하여, 각 지점의 간선 정보를 확인 후, 인접한 노드의 최소 방문 비용을 갱신해나가는 알고리즘
- 느린 다익스트라 알고리즘 : O(N^2)
  - 매 순간 노드를 순차적으로 탐색하여 방문하지 않은 비용이 최소인 지점을 찾는다.
  - 각 지점을 기준으로 연결된 간선정보를 확인 후, 인접한 노드의 최소 방문 비용을 갱신한다.
- 빠른 다익스트라 알고리즘 : O(NlogN)
  - 시작점의 노드를 우선순위 큐에 삽입한다.
  - 다음을 반복한다.
    - 큐에서 가장 방문비용이 적은 노드를 꺼낸다.
    - dis 배열에서의 비용값과 해당 노드의 비용값을 비교했을 때 dis 배열이 더 저렴하면 무시한다.
    - 해당 노드를 기준으로 연결된 간선정보를 확인 후, 다음 작업을 수행한다.
      - 다음 노드까지 도달하는 비용이 더 저렴하게 갱신됐다면 비용 정보를 반영하여 노드 객체를 큐에 삽입한다.
      - dis배열을 최적화한다.

---

## 사용 클래스

### Node
```java
public class Node implements Comparable<Node> {
    int pos;
    int cost;

    public Node(int pos, int cost) {
        this.pos = pos;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
```
노드를 나타낸 객체
- pos : 위치
- cost : 해당 지점까지 도착하는데 필요한 누적 비용
- 정렬 기준 : 비용 기준 오름차순

### Edge
```java
public class Edge {
    int end;
    int cost;

    public Edge(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}
```
간선을 나타낸 객체
- end : 종착점
- cost : 비용

---

## 느린 다익스트라 (Main1)

### 느린 다익스트라 (Main1) : 정적 변수
```java
    private static int n; // 노드 수
    private static int m; // 간선 수

    private static int[] dis;
    private static boolean[] checked;
    private static final ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    private static final int INF = Integer.MAX_VALUE;
```
- graph : 각 노드에서 출발하는 간선들
- dis : 출발지의 비용을 0으로 했을 때 갱신해나갈 최소 방문 비용 배열
- checked : 체크했는 지 여부
- INF : 무한

### 느린 다익스트라 (Main1) : main
```java
    public static void main(String[] args) throws IOException {
        input();
        String answer = solution();
        System.out.print(answer);
    }
```

### 느린 다익스트라 (Main1) : input
```java
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        checked = new boolean[n+1];
        dis = new int[n+1];
        Arrays.fill(dis, INF);

        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());

        int start, end, cost;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, cost));
        }
        br.close();
    }
```
- 각 노드의 방문비용은 기본적으로 INF(무한)으로 초기화
- graph에 각 지점별 간선을 배치

### 느린 다익스트라 (Main1) : solution
```java

    private static String solution() {
        slowDijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=n; i++) {
            sb.append(i).append(" : ");
            if (dis[i] < INF) {
                sb.append(dis[i]);
            } else {
                sb.append("impossible");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
```
- 느린 다익스트라를 수행 후 비용 배열을 순회하여 결과 문자열 생성

### 느린 다익스트라 (Main1) : slowDijkstra()
```java
    private static void slowDijkstra() {
        dis[1] = 0;
        for (int i=1; i<=n-1; i++) {
            int minNode = findUncheckedMinimumNode(); // 체크하지 않은 방문비용이 최소인 노드를 찾음
            checked[minNode] = true;
            for (Edge edge : graph.get(minNode)) {
                if (dis[edge.end] > dis[minNode] + edge.cost) {
                    dis[edge.end] = dis[minNode] + edge.cost;
                }
            }
        }
    }
```
- 방문하지 않은 최소비용의 노드의 인덱스를 찾는다.
  - 찾지 못 하면 0이 반환되는데 0번은 사용하지 않는 인덱스이고, 출발하는 간선이 없으니 로직에 영향을 끼치지 않는다.
- 해당 노드를 방문 처리하고, 연결된 간선들을 확인한다. (이 시점에서 방문처리한 노드의 최소 도착 비용은 확정된다.)
  - 간선 도착점의 최소비용을 갱신시킬 수 있다면 최소비용을 갱신시킨다.

### 느린 다익스트라 (Main1) : slowDijkstra()
```java
    private static int findUncheckedMinimumNode() {
        int min = INF;
        int minIndex = 0; // 기본적으로 사용하지 않는 0번 인덱스를 기본값으로 한다.
        for (int j=1; j<=n; j++) {
            if (!checked[j] && dis[j] < min) {
                min = dis[j];
                minIndex = j;
            }
        }
        return minIndex;
    }
```
- 방문하지 않은 최소비용의 노드의 인덱스를 찾는다.
  - 찾지 못 하면 0이 반환되는데 0번은 사용하지 않는 인덱스이고, 출발하는 간선이 없으니 로직에 영향을 끼치지 않는다.

---

## 빠른 다익스트라 (Main2)

### 빠른 다익스트라 (Main2) : 정적 변수
```java
    private static int n; // 노드 수
    private static int m; // 간선 수
    private static int[] dis;
    private static final ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    private static final int INF = Integer.MAX_VALUE;
```
- 별도로 checked 배열을 다루지 않는다

### 빠른 다익스트라 (Main2) : main
```java
    public static void main(String[] args) throws IOException {
        input();
        String answer = solution();
        System.out.print(answer);
    }
```

### 빠른 다익스트라 (Main2) : input
```java
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dis = new int[n+1];
        Arrays.fill(dis, INF);

        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());

        int start, end, cost;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, cost));
        }
        br.close();
    }
```

### 빠른 다익스트라 (Main2) : solution
```java
    private static String solution() {
        fastDijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=n; i++) {
            sb.append(i).append(" : ");
            if (dis[i] < INF) {
                sb.append(dis[i]);
            } else {
                sb.append("impossible");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
```

### 빠른 다익스트라 (Main2) : solution
```java
    private static void fastDijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[1] = 0;
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if (dis[current.pos] < current.cost) {
                // dis 배열 저장값이 더 작다는 것은 이미 앞에서 더 좋은 방문 방법이 반영됐다는 것이므로 계산하지 않는다.
                continue;
            }
            // 여기까지 통과하면 current 노드의 최소방문비용은 확정된다.
            
            for (Edge edge : graph.get(current.pos)) {
                if (dis[edge.end] > dis[current.pos] + edge.cost) {
                    dis[edge.end] = dis[current.pos] + edge.cost;
                    pq.offer(new Node(edge.end, dis[edge.end]));
                }
            }
        }
    }
```
- 우선순위 큐를 사용한다.
- 매순간 O(N)으로 방문비용이 최소인 지점을 찾을 필요가 없어져서 탐색 시간복잡도가 O(logN)이 된다.
- 전체 시간복잡도가 O(NlogN)이 된다.

---

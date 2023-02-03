# 9.08 원더랜드(프림 - Priority Queue)
- 분류 : 프림 알고리즘
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.08)

---

## 프림 알고리즘
- 크루스칼 알고리즘과 마찬가지로 최소 신장 트리를 구하는 알고리즘

---

## 시간 복잡도 비교 (프림 알고리즘 vs 크루스칼 알고리즘)
- 크루스칼 알고리즘 : O(ElogE)
  - E : 간선의 갯수
  - 간선 E개를 정렬해야함
  - 내부에서 서로소 집합 알고리즘의 복잡도는 정렬 시간 복잡도보다 작으므로 무시
- 프림 알고리즘 : O(ElogV)
- 무엇을 쓸 것인가?
  - 간선의 갯수가 많아지면 프림 알고리즘을 사용하는 것이 유리
  - 간선의 갯수가 적다면 크루스칼 알고리즘을 사용하는 것이 유리

---

## 풀이

### Edge
```java
public class Edge implements Comparable<Edge> {

    int end;
    int cost;

    public Edge(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}
```
- end : 간선의 끝
- cost : 해당 간선의 비용
- 비용 기준으로 오름차순 정렬할 수 있도록 한다

### 정적 변수
```java
    private static int v;
    private static int e;
    private static ArrayList<ArrayList<Edge>> graph;
    private static boolean[] checked; // 방문 배열
```
- v : 정점의 갯수
- e : 간선의 갯수
- graph : 인접 리스트
- checked : 체크 배열

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }
```

### input
```java
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i=0; i<=v; i++) graph.add(new ArrayList<>());

        checked = new boolean[v+1];

        int node1, node2, cost;
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(node1).add(new Edge(node2, cost));
            graph.get(node2).add(new Edge(node1, cost));
        }
        br.close();
    }
```

### solution
```java
    private static int solution() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        int answer = 0;
        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if (checked[current.end]) continue;

            checked[current.end] = true; // 방문 처리
            answer += current.cost;

            for (Edge edge : graph.get(current.end)) {
                if (!checked[edge.end]) pq.offer(edge);
            }
        }
        return answer;
    }
```
- 1번 정점을 시작점으로 삼는다.
- 처음에 1번 노드로 0의 비용으로 도착했다 가정한다.
- 우선순위 큐에 1번 노드로 도착하는 가상의 간선을 삽입한다.
- 우선순의 큐가 빌 때까지 다음을 반복한다.
  - 간선의 도착지점이 방문됐다면 무시하고 다음으로 넘어간다.
  - 간선의 도착지점이 방문되지 않았다면 다음을 수행한다.
    - 방문처리 후, 간선의 비용만큼을 answer에 증가시킨다.
    - 도착지가 이미 방문처리되지 않은 간선들을 우선순위 큐에 삽입한다.
- 이렇게 하면, 최소 신장 트리를 완성시킬 수 있다.

---

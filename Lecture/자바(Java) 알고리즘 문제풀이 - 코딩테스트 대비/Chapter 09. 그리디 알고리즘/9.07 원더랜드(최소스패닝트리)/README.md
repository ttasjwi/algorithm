# 9.07 원더랜드(최소 스패닝 트리)
- 분류 : 크루스칼 알고리즘
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.07)

---

## 신장 트리(Spanning tree)
다음 조건을 만족하는 트리를 신장 트리라고 한다.
- 그래프에서 모든 정점을 포함한다
- 정점들이 모두 연결되어야 한다.
- 사이클이 존재하지 않아야한다.

## 최소신장트리(Minimum Spanning Tree, MST)
가중치의 합이 최소가 되는 신장 트리

---

## 크루스칼 알고리즘(Kruskal Algorithm)
최소 신장 트리를 구하는 알고리즘.  
최소 비용의 간선을 순서대로 확인하여 사이클이 형성되지 않는 선에서 연결하므로 그리디 알고리즘의 일종이다.  
- 간선들을 가중치 기준으로 오름차순 정렬한다.
- 정렬된 순서대로 간선을 확인하며 다음을 수행한다.
  - `findParent`를 통해 간선의 양 끝점의 루트 노드를 찾는다.
    - 양 끝점의 루트노드가 같으면 이미 연결되어 있는 노드들이므로 넘어간다. (이미 연결되어있는 상황에서 노드를 더 연결하면 사이클이 발생한다.)
    - 양 끝점의 루트노드가 다르면 연결되어 있지 않은 노드이므로 연결한다.(union)
  - 노드의 갯수 -1 만큼의 간선이 연결됐다면 최소신장트리가 완성됐으므로 반복을 멈춘다.
- 최소 신장트리가 완성된다.

---

## 풀이
### Edge
```java
public class Edge implements Comparable<Edge> {
    int node1;
    int node2;
    int cost;

    public Edge(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}
```
- node1, node2 : 간선의 양 끝점
- cost : 비용
- 비용 기준으로 오름차순 정렬할 수 있게 Comparable을 구현한다

### 정적 변수
```java
    private static int v; // 도시 수
    private static int e; // 도로의 갯수
    private static Edge[] edges; // 간선들
    private static int[] parent; // 부모
```
- v : 도시의 갯수
- e : 도로의 갯수
- edges : 간선들
- parent : 부모들

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }
```
- input : 입력
- solution : answer를 구한다.
- sout : 출력

### input
```java

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edges = new Edge[e];
        parent = new int[v+1];
        for (int i=1;i<=v; i++) parent[i] = i;

        int node1, node2, cost;
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(node1, node2, cost);
        }
        br.close();
    }
```
- parent 배열 초기화 시 자기 자신을 부모 노드로 하도록 한다.
- 간선들을 입력받고 배열에 저장한다.

### solution
```java
    private static int solution() {
        Arrays.sort(edges); // 비용을 기준으로 오름차순 정렬

        int answer = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (findParent(edge.node1) != findParent(edge.node2)) {
                unionParent(edge.node1, edge.node2);
                answer += edge.cost;
                cnt ++; // 계산 완료된 간선의 갯수를 센다.
                if (cnt == v-1) break; // 간선의 갯수가 v-1개이면 모든 도시가 연결된 상황
            }
        }
        return answer;
    }
```
- 간선들을 비용 기준으로 오름차순 정렬한다.
- answer : 가중치 합
- cnt : 연결한 간선의 갯수.
  - v-1개가 되면 모든 노드가 연결되어 최소신장트리가 완성됐다는 뜻이다.
- 간선들을 순차적으로 탐색하여 양 끝점이 연결되지 않았다면 다음을 수행한다.
  - union 시킨다.
  - cnt를 1 증가시킨다.
  - 가중치 합에 가중치를 더한다.
  - cnt가 v-1이 된 순간 반복을 탈출한다.
- answer를 반환한다.

### findParent
```java
    private static int findParent(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        return parent[x] = findParent(parent[x]);
    }
```
- 부모배열을 확인하여 인덱스와 저장값이 같으면 루트 노드다. 값을 반환한다.
- 저장값이 인덱스와 다르면 루트노드가 아니다. 재귀적으로 메서드를 호출하여 루트 노드를 찾는다.
  - 찾은 루트 노드를 현재 저장값으로 갱신한다.(경로 압축)

### unionParent
```java
    private static void unionParent(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else if (rootA > rootB) {
            parent[rootA] = rootB;
        }
    }
```
- 두 노드의 루트 노드를 확인하여 하나로 통합한다.

---

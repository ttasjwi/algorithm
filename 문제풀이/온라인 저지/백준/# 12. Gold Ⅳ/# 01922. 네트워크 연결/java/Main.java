import java.io.IOException;

public class Main {

    private static int n;
    private static int e;
    private static int[] parent;
    private static Heap heap;

    public static void main(String[] args) throws IOException {
        n = i();
        e = i();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        heap = new Heap(e);
        for (int i = 0; i < e; i++) {
            heap.push(new Edge(i(), i(), i()));
        }

        int cnt = 0;
        int costSum = 0;

        Edge edge;
        while (heap.size > 0) {
            edge = heap.pop();
            if (union(edge.from, edge.to)) {
                cnt++;
                costSum += edge.cost;
                if (cnt == n - 1) {
                    break;
                }
            }
        }
        System.out.print(costSum);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        if (aRoot < bRoot) parent[bRoot] = aRoot;
        else parent[aRoot] = bRoot;
        return true;
    }

    private static int i() throws IOException {
        int v = 0;
        int c = System.in.read();
        do v = v * 10 + (c - 48); while ((c = System.in.read()) > 47);
        return v;
    }
}

class Heap {

    private Edge[] edges;
    int size;

    public Heap(int capacity) {
        this.edges = new Edge[capacity + 1];
    }

    public void push(Edge e) {
        edges[++size] = e;
        int i = size;
        int p = i >> 1;
        Edge tmp;
        while (p > 0) {
            if (edges[i].compareTo(edges[p]) < 0) {
                tmp = edges[i];
                edges[i] = edges[p];
                edges[p] = tmp;

                i = p;
                p = i >> 1;
            } else {
                break;
            }
        }
    }

    public Edge pop() {
        Edge e = edges[1];
        edges[1] = edges[size];
        edges[size --] = null;

        int i = 1;
        int lt = i << 1;
        int rt = lt + 1;
        int small = i;

        Edge tmp;
        while (true) {
            if (lt <= size && edges[lt].compareTo(edges[small]) < 0) small = lt;
            if (rt <= size && edges[rt].compareTo(edges[small]) < 0) small = rt;
            if (small == i) break;
            tmp = edges[i];
            edges[i] = edges[small];
            edges[small] = tmp;
            i = small;
            lt = i << 1;
            rt = lt + 1;
        }
        return e;
    }

}

class Edge implements Comparable<Edge> {

    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}
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

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Node[] nodes = initNodes();
        Node root = nodes[1];
        int answer = BFS(root);
        System.out.print(answer);
    }

    private static int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);

        int size;
        Node current;
        while(!queue.isEmpty()) {
            size = queue.size();

            for (int i=0; i<size; i++) {
                current = queue.poll();
                if (isLeafNode(current)) {
                    return level;
                }
                if (current.lt != null) {
                    queue.offer(current.lt);
                }
                if (current.rt != null) {
                    queue.offer(current.rt);
                }
            }
            level ++;
        }
        return -1;
    }

    private static boolean isLeafNode(Node node) {
        return node.lt == null && node.rt == null;
    }

    private static Node[] initNodes() {
        Node[] nodes = new Node[6];
        for (int i=1; i<=5; i++) nodes[i] = new Node(i);

        int[] parents = new int[]{-1, -1, 1, 1, 2, 2};
        for (int i=2; i<=5; i++) {
            Node child = nodes[i];
            Node parent = nodes[parents[i]];

            if (parent.lt == null) {
                parent.lt = child;
            } else {
                parent.rt = child;
            }
        }
        return nodes;
    }

}

class Node {
    int value;
    Node lt;
    Node rt;

    public Node(int value) {
        this.value = value;
    }
}

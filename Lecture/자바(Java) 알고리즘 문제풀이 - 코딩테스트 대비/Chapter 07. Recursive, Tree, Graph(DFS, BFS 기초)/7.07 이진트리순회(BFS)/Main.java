import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Node[] nodes = initNodes();
        Node root = nodes[1];
        StringBuilder answer = solution(root);
        System.out.print(answer);
    }

    private static StringBuilder solution(Node root) {
        StringBuilder sb = new StringBuilder();
        BFS(root, sb);
        return sb;
    }

    private static StringBuilder BFS(Node node, StringBuilder sb) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        int size;
        while (!queue.isEmpty()) {
            sb.append("Level ").append(level).append(": ");
            size = queue.size();
            for (int i=0; i<size; i++) {
                Node current = queue.poll();
                sb.append(current.value).append(' ');
                if (current.lt != null) {
                    queue.offer(current.lt);
                }
                if (current.rt != null) {
                    queue.offer(current.rt);
                }
            }
            sb.append('\n');
            level ++;
        }
        return sb;
    }

    private static Node[] initNodes() {
        Node[] nodes = new Node[8];
        for (int i=1; i<=7; i++) nodes[i] = new Node(i);

        int[] parents = new int[]{-1, -1, 1, 1, 2, 2, 3, 3};
        for (int i=2; i<=7; i++) {
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

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Node[] nodes = initNodes();
        Node root = nodes[1];
        StringBuilder answer = solution(root);
        System.out.print(answer);
    }

    private static StringBuilder solution(Node root) {
        StringBuilder sb = new StringBuilder();
        DFS(root, sb);
        return sb;
    }

    private static StringBuilder DFS(Node node, StringBuilder sb) {
        if (node == null) return sb;
        sb.append(node.value).append(' ');
        DFS(node.lt, sb);
        DFS(node.rt, sb);
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

public class Main {

    public static void main(String[] args) {
        Node[] nodes = initNodes();
        Node root = nodes[1];
        int answer = DFS(root, 0);
        System.out.print(answer);
    }

    private static int DFS(Node node, int level) {
        if (isLeafNode(node)) return level;

        if (isRtNull(node)) {
            return DFS(node.lt, level + 1);
        }

        return Math.min(DFS(node.lt, level +1), DFS(node.rt, level + 1));
    }

    private static boolean isRtNull(Node node) {
        return node.lt != null && node.rt == null;
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

# 7.07 이진트리 순회(BFS)
- 분류 : BFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.07)

---

## BFS (너비 우선 탐색)
- Queue를 사용한다.
- 찾고자 하는 대상까지의 거리(레벨)를 찾을 때 유용하게 사용할 수 있다.

---

### Node
```java
class Node {
    int value;
    Node lt;
    Node rt;

    public Node(int value) {
        this.value = value;
    }
}
```
- value : 현재 노드 값
- lt : 왼쪽 노드를 참조로 연결
- rt : 오른쪽 노드를 참조로 연결

### 노드 초기화
```java
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
```
- 1,2,3,4,5,6,7 의 트리 관계를 맺어주기 위함

### 입출력
```java
    public static void main(String[] args) {
        Node[] nodes = initNodes();
        Node root = nodes[1];
        StringBuilder answer = solution(root);
        System.out.print(answer);
    }
```
- 노드 초기화
- 1번 노드를 root로 하여 BFS 한다.
- 탐색 순서대로 값을 출력한다.

---

## BFS 구현
```java
    private static StringBuilder BFS(Node node, StringBuilder sb) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        int size;
        while (!queue.isEmpty()) { // 큐가 빌 떄까지
            sb.append("Level ").append(level).append(": "); // 현재 레벨
            size = queue.size(); // 현재 레벨에 속한 원소의 갯수
            for (int i=0; i<size; i++) { // 현재 레벨 원소들을 모두 꺼내서
                Node current = queue.poll();
                sb.append(current.value).append(' '); // 값 순서대로 출력
                if (current.lt != null) {
                    queue.offer(current.lt); // 왼쪽,오른쪽 노드를 Queue 에 저장
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
```
- Queue에서 현재 레벨의 노드들을 전부 꺼낸다.
  - 순서대로 모두 출력한다.
- 자식 노드들을 순서대로 Queue 에 넣는다.
  - 반복

---

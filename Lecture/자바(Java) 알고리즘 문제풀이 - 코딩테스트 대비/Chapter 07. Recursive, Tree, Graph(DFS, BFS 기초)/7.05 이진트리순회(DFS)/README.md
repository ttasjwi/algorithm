# 7.05 이진트리 순회(DFS)
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.05)

---

## DFS (깊이 우선 탐색)
- 재귀를 사용한다.

## 전위 탐색, 중위 탐색, 후위 탐색
- 전위 탐색 : **자기 자신** - 왼쪽 노드 - 오른쪽 노드
- 중위 탐색 : 왼쪽 노드 - **자기 자신** - 오른쪽 노드-
- 후위 탐색 : 왼쪽 노드 - 오른쪽 노드 - **자기 자신**

---

## 풀이

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
- 1번 노드를 root로 하여 DFS 한다.
- 탐색 순서대로 값을 출력한다.

---

## DFS (전위, 중위, 후위) 구현

### 1. 전위 탐색
```java
    private static StringBuilder DFS(Node node, StringBuilder sb) {
        if (node == null) return sb;
        sb.append(node.value).append(' ');
        DFS(node.lt, sb);
        DFS(node.rt, sb);
        return sb;
    }
```
- 말단 노드는 자식이 없는 노드인데, 말단 노드의 자식은 null이다.
- DFS에 null이 인자로 넘어가면 바로 반환하도록 함.
- 기본적으로 전위탐색을 함. 자기 자신 -> 왼쪽노드 -> 오른쪽 노드 순으로 탐색

### 2. 중위 탐색
```java
    private static StringBuilder DFS(Node node, StringBuilder sb) {
        if (node == null) return sb;
        DFS(node.lt, sb);
        sb.append(node.value).append(' ');
        DFS(node.rt, sb);
        return sb;
    }
```
- 말단 노드는 자식이 없는 노드인데, 말단 노드의 자식은 null이다.
- DFS에 null이 인자로 넘어가면 바로 반환하도록 함.
- 중위탐색 : 왼쪽노드 -> 자기 자신 -> 오른쪽 노드 순으로 탐색

### 3. 후위 탐색
```java
    private static StringBuilder DFS(Node node, StringBuilder sb) {
        if (node == null) return sb;
        DFS(node.lt, sb);
        DFS(node.rt, sb);
        sb.append(node.value).append(' ');
        return sb;
    }
```
- 말단 노드는 자식이 없는 노드인데, 말단 노드의 자식은 null이다.
- DFS에 null이 인자로 넘어가면 바로 반환하도록 함.
- 후위탐색 : 왼쪽노드 -> 오른쪽 노드 -> 자기 자신 순으로 탐색

---

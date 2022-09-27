# 7.09 Tree 말단노드까지의 까장 짧은 경로(DFS)
- 분류 : BFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.09)

---

## 풀이

### 입출력
```java
    public static void main(String[] args) {
        Node[] nodes = initNodes();
        Node root = nodes[1];
        int answer = DFS(root, 0);
        System.out.print(answer);
    }
```
- 노드 초기화
- 1번 노드를 루트 노드로 한다.
- 1번 노드의 레벨을 0으로 한다.
- DFS를 통해 가장 가까운 리프노드가 위치한 레벨을 반환하게 한다.
- 출력

### DFS
```java
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
```
- 리프노드이면 현재 레벨을 반환한다.
- 리프노드가 아닐 경우, 왼쪽 노드/오른쪽 노드의 DFS 함수 호출 반환값 중 최솟값을 반환한다.

---

## 참고
- 이 문제의 경우, DFS 방식은 쓸데없이 더 깊숙한 노드까지 탐색해야하는 문제점이 있다.
- BFS를 통해 풀었을 때 좀더 빠르게 답을 구할 수 있다.

---

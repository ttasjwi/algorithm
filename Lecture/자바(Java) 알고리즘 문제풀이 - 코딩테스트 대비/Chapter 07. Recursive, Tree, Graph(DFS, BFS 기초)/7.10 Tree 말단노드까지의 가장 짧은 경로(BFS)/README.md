# 7.10 Tree 말단노드까지의 까장 짧은 경로(BFS)
- 분류 : BFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.10)

---

## 풀이

### BFS
```java

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
```
- DFS를 사용하면 재귀를 통해 쓸데없이 더 깊은 범위를 탐색해야했다.
- BFS를 사용하면 Queue를 사용하고, 레벨을 따로 기록하면서 탐색하므로 빠르게 대상을 찾고 레벨을 반환할 수 있다.

---

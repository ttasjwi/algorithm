# 7.08. 송아지 찾기 1(BFS - 상태트리탐색)
- 분류 : BFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.08)

---

## BFS (너비 우선 탐색)
- Queue를 사용한다.
- 찾고자 하는 대상까지의 거리(레벨)를 찾을 때 유용하게 사용할 수 있다.

---

## 풀이
### 상수
```java
    private static final int[] DIRECTION = new int[]{-1, 1, 5};
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 10000;
    private static final boolean[] visited = new boolean[10001];
```
- `DIRECTION` : -1, 1, 5 (이동 가능한 방향들)
- `RANGE_MIN`, `RANGE_MAX` : 좌표의 최대/ 최소
- `visited` : 방문배열


### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = BFS(s,e);
        System.out.print(answer);
    }
```
- s, e를 입력받는다.
- BFS를 통해 도달하고자 하는 위치까지의 최단거리를 구한다.
- 출력한다.

### BFS
```java
    private static int BFS(int s, int e) {
        int level = 0;
        if (s == e) return 0;
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int size;
        int current, next;
        while(!queue.isEmpty()) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                current = queue.poll();
                for (int j=0; j<3; j++) {
                    next = current + DIRECTION[j];
                    if (next == e) return level +1;
                    if (RANGE_MIN <= next && next <= RANGE_MAX && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
```
- 시작위치의 점프 횟수(레벨로 칭하겠다)는 0이므로 0으로 초기화한다.
- 시작 위치가 송아지 위치와 같으면 바로 jump값을 반환한다.
- 현 위치를 방문처리 한다.
- 큐에 시작 위치를 삽입한다.
- 큐가 빌 때까지 반복한다.
  - 큐에 포함된 모든 요소들의 갯수를 구한다.
  - 현재 레벨에 속한 모든 요소들마다, 추출 후 다음 작업을 반복한다.
    - -1, 1, 5 방향에 있는 요소를 확인하고 해당 요소가 송아지 위치이면 바로 level + 1 을 반환한다.
    - -1, 1, 5 방향이 유효한 좌표이고 방문하지 않았다면, 방문처리하고 큐에 해당 위치를 삽입한다.
  - 현재 레벨에 속한 요소들을 모두 탐색했으므로 레벨을 증가시킨다.

---

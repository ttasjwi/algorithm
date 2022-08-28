# 8.05 동전교환
- 분류 : DFS, BFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.05)

---

## DFS 방식

### 정적 변수
```java
    private static int n; // 동전의 종류 갯수
    private static int m; // 거슬러 줄 금액
    private static Integer[] units; // 각 동전의 금액단위
    private static int answer = Integer.MAX_VALUE; // 거슬러 줄 동전의 최소 갯수
```
- 동전 금액단위는 내림차순 정렬해야하는데 Arrays에서 정렬자(`Comparator`)을 지정하기 위해서는 래퍼클래스로 타입을 지정해야한다.
- 거슬러줄 동전의 최소 갯수를 answer로 놓는다.

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        units = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            units[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(units, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());
        br.close();
        
        dfs(m, 0);
        System.out.print(answer);
    }
```
- 단위를 입력받고 내림차순으로 정렬해야한다. (작은 단위부터 따지면 시간 효율 상 좋지 못 하다.)
- dfs 수행후 answer를 출력한다

### dfs
```java
    private static void dfs(int money, int count) {
        if (money < 0) return;
        if (count >= answer) return;
        if (money == 0) {
            answer = count;
            return;
        }
        for (int i=0; i<n; i++) {
            dfs(money-units[i], count + 1);
        }
    }
```
- 남은 금액이 0보다 작으면 return
- count가 answer 이상이면 더 이상 answer를 갱신할 수 없으므로 return
- 남은 금액이 0이면 answer를 count로 갱신한다. (위에서 이미 answer 이상인 count는 걸러짐)
- 남은 금액이 0보다 크면
  - 단위별로 순서대로 dfs(남은 금액- 단위, count + 1)를 수행한다.
  - 큰 단위부터 answer를 갱신하기 때문에 dfs로 더 깊이 들어갈 가능성이 상당히 배제된다.

---

## BFS 방식

### 정적 변수
```java
    private static int n; // 동전의 종류 갯수
    private static int m; // 거슬러 줄 금액
    private static Integer[] units; // 각 동전의 금액단위
    private static boolean checked[]; // 체크여부
```
- 해당 금액이 이미 체크됐는지 여부를 기록하는 checked 배열을 사용한다

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        units = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            units[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(units, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());
        checked = new boolean[m+1];
        br.close();
        int answer = bfs();
        System.out.print(answer);
    }
```
- 큰 단위부터 따지는게 아주 조금 더 빨리 답을 찾을 가능성이 있어서, 내림차순 정렬했다.
- 체크 배열에는 1~m까지 해당 금액을 이미 따졌는지 여부를 기록한다.
- bfs로 answer를 구하여 출력한다.

### bfs
```java

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int next;
        for (int unit : units) {
            next = m - unit;
            if (next == 0) return 1;
            if (next > 0) {
                checked[next] = true;
                queue.offer(next);
            }
        }
        int count = 1; // 화폐 수
        int size;
        while(!queue.isEmpty()) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                int current = queue.poll();
                for (int unit : units) {
                    next = current - unit;
                    if (next == 0) return count +1;
                    if (next > 0 && !checked[next]) {
                        checked[next] = true;
                        queue.offer(next);
                    }
                }
            }
            count ++;
        }
        return -1;
    }
```
- 큐에 우선 각 단위의 금액을 삽입한다.
  - 초기 금액에서 단위 금액을 차감한다.
  - 차감한 금액이 같으면 화폐 1개를 써서 거슬른 것이므로 1 반환
  - 차감한 금액이 0보다 크면 queue에 삽입한다.
  - 처음에 queue에 무작정 모든 차감 금액을 삽입하면 0보다 작은 경우 혹은 0인 경우도 발생할 수 있어서(조건 범위) 여기서도 따지도록 했다.
- 큐가 빌 때까지 다음을 반복한다.
  - size를 확인하고 size만큼 반복한다.
  - 위의 작업과 구조적으로 같은데, 체크배열을 사용하여 이미 따진 값은 더 이상 따지지 않도록 했다.

---


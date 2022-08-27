# 8.02 바둑이 승차
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.02)

---

## 풀이

### 정적 변수
```java
    private static int n; // 바둑이 수
    private static int c; // 무게 제한
    private static int[] weights; // 무게들
    private static int answer = Integer.MIN_VALUE; // 무게 제한을 넘지 않는 최대 무게
```
- n : 바둑이 수
- c : 무게 제한
- weights : 무게들
- answer : 무게 제한을 넘지 않는 최대 무게

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        weights = new int[n];

        for (int i=0; i<n; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        dfs(0, 0);
        System.out.print(answer);
    }
```
- 순차적으로 값을 입력받고, dfs를 수행한 뒤 무게 제한을 넘지 않는 최대 무게 answer를 출력한다.

### DFS
```java
    private static void dfs(int index, int sum) {
        if (sum > c) return; // 초과하면 더 따져봤자 조건에 부합할 가능성이 없다.
        if (index == n) {
            if (sum > answer) answer = sum;
            return;
        }
        dfs(index + 1, sum+ weights[index]); // 현재 index에 대응하는 바둑이를 포함하는 경우
        dfs(index + 1, sum); // 현재 index에 대응하는 바둑이를 포함하지 않는 경우
    }
```
- sum이 c보다 클 경우 바로 return
- index가 n일 경우 sum과 answer를 비교하여 최댓값을 갱신후 return
- 현재 인덱스에 대응하는 바둑이를 포함하는 경우, 포함하지 않는 경우를 기준으로 DFS를 수행한다.

---

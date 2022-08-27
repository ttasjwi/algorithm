# 8.01 합이 같은 부분집합
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.01)

---

## 풀이

### 정적 변수
```java
    private static int n;
    private static int[] numbers;
    private static int totalSum = 0;
    private static boolean yesFlag;
```
- n : 숫자의 갯수
- numbers : 숫자들의 배열
- totalSum : 숫자들의 총합
- yesFlag : 이 Flag가 true이면 "YES"

### 입력, 출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            totalSum += numbers[i];
        }
        dfs(0, 0);
        String answer = (yesFlag) ? "YES" : "NO";
        System.out.print(answer);
    }
```
- 숫자들을 입력받고 배열에 저장하면서 totalSum도 구해놓는다.
- DFS를 수행한다.
- DFS 수행 후 yesFlag가 true이면 "YES", false 이면 "NO"를 출력한다.

### DFS
```java
    private static void dfs(int index, int sum) {
        if (yesFlag) return; // 더 탐색할 필요 없이 무조건 YES다.
        if (sum > totalSum) return; // 초과하면 더 구해봤자 정답이 아니다.
        if (index == n) {
            if (totalSum == 2 * sum) {
                yesFlag =  true; // YES가 되는 조건을 찾았다.
                return;
            }
            return;
        }
        dfs(index + 1, sum+ numbers[index]); // 현재 index에 저장된 값을 포함하는 경우
        dfs(index + 1, sum); // 현재 index에 저장된 값을 포함하지 않는 경우
    }
```
- 현재 index의 값을 포함하는 경우, 포함하지 않는 경우로 나눠서 dfs하면 된다.
- `yesFlag`가 true이면 더 탐색할 필요 없으므로 return
- sum이 totalSum보다 크면 더 탐색할 필요 없으므로 return
- index가 n이 되면, 총합이 totalSum과 같은지 비교하고, 일치하면 yesFlag를 true로 하고 return 시킨다.

---

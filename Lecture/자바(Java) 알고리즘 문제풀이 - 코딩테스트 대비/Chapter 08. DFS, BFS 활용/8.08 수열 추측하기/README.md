# 8.08 수열 추측하기
- 분류 : dfs, 조합(메모이제이션)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.08)

---

## 풀이

### 정적변수
```java
    private static int n; // 제일 큰 수
    private static int f; // 찾는 수
    private static int[][] combinations; // 조합수 메모이제이션
    private static int[] selectedNumbers; // 선택된 숫자들
    private static boolean[] checked; // 체크 배열
    private static boolean found; // 답을 찾았는지 여부
    private static StringBuilder sb;
```

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        combinations = new int[n][n];
        checked = new boolean[n+1];
        selectedNumbers = new int[n];
        String answer = solution();
        System.out.print(answer);
    }
```

### solution
```java
    private static String solution() {
        sb = new StringBuilder();
        dfs(0, 0);
        return sb.toString();
    }
```
- dfs 돌리고 `sb.toString` 반환

### dfs
```java
    public static void dfs(int index, int sum) {
        if (found) return;
        if (sum > f) {
            return;
        }
        if (index == n) {
            if (sum == f) {
                found = true;
                for (int selectedNumber : selectedNumbers) {
                    sb.append(selectedNumber).append(' ');
                }
                return;
            }
            return;
        }
        for (int number=1; number<=n; number++) {
            if (!checked[number]) {
                checked[number] = true;
                selectedNumbers[index] = number;
                dfs(index+1, sum + number * combination(n-1,index));
                checked[number] = false;
            }
        }
    }
```
- `found`가 true이면 이미 답을 찾았으니 바로 반환
- `sum`이 f보다 크면 더 계산해봐야 답이 아니므로 바로 반환
- index가 n이면 sum과 f를 비교해 같으면 found를 true로 변환하여 정답 문자열을 만들고 반환
- 숫자들을 dfs를 통해 순열 형태로 만든다.
- sum에 `number * combination(n-1, index)`를 더해나가면 마지막에 합쳐지는 값이 계산된다.

### combination
```java
    private static int combination (int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == n || r == 0) {
            return combinations[n][r] = combinations[n][n-r] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][r] = combinations[n][n-r] = n;
        }
        return combinations[n][r] = combinations[n][n-r] = combination(n-1, r-1) + combination(n-1, r);
    }
```
- 조합수를 구하는 로직

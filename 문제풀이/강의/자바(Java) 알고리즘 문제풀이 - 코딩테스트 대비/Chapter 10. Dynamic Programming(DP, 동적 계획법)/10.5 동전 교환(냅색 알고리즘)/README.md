# 10.5 동전 교환(냅색 알고리즘)
- 분류 : DP
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 10.5)

---

## 풀이

### 정적 변수
```java
    private static int n; // 동전의 종류 갯수
    private static int m; // 거슬러줄 금액
    private static int coins[]; // 동전의 단위
    private static int dp[]; // i원을 만드는데 드는  최소 동전의 갯수
```

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }
```

### input
```java

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coins = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        br.close();
    }
```

### dp
```java
    private static int solution() {
        dp = new int[m+1];
        for (int i=1; i<=m; i++) dp[i] = 501;

        for (int coin : coins) {
            for (int i=coin; i<=m; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return dp[m];
    }
```
- i원을 만드는데 드는  최소 동전의 갯수
- `dp[i]` 초기화 : 거스러야 할 동전 갯수가 최대 500인데, 501로 초기화한다.
  - Integer.MAX_VALUE로 하면 int 범위 밖으로 벗어날 가능성이 있다.
- coins 중 하나인 coin을 도입시키면서 `dp[i]`를 최적화한다.
  - `dp[i] = Math.min(dp[i], dp[i-coin] + 1);`
    - `i-coin`을 거스르는 동전의 갯수에 coin원 1개를 추가로 지불하는 방법을 더 했을 때 기존 것보다 더 동전 개수를 최적화시킬 수 있는지 확인
    - 더 최적화 시킬 수 있으면 최적화한다.

---

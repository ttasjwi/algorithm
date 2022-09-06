# 10.2 돌다리 건너기
- 분류 : DP
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 10.2)

---

## 다이나믹 프로그래밍
- 특정 범위까지의 값을 구하기 위해서 그것과 다른 범위까지의 값을 이용하여 효율적으로 값을 구하는 알고리즘
- 과거에 구한 해를 활용

---

## 풀이

### main
```java

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int answer = solution(n);
        System.out.print(answer);
    }
```

### solution
```java
    private static int solution(int n) {
        int[] dp = new int[n+2];
        return dp(n+1, dp);
    }
```
- 돌다리를 건너는 방법의 수는 n+1번째 돌다리에 가는 방법의 가짓수이다.

### dp
```java
    private static int dp(int k, int[] dp) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=k; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[k];
    }
```

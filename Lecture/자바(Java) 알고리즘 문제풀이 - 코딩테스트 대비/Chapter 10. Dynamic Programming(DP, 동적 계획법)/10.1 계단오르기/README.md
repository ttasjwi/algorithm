# 10.1 계단오르기
- 분류 : DP
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 10.1)

---

## 다이나믹 프로그래밍
- 특정 범위까지의 값을 구하기 위해서 그것과 다른 범위까지의 값을 이용하여 효율적으로 값을 구하는 알고리즘
- 과거에 구한 해를 활용

---

## 정적 변수
```java
    private static int n;
    private static int[] dp;
```

### main
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
        int answer = solution();
        System.out.print(answer);
    }
```

### solution
```java
    private static int solution() {
        dp = new int[n+1];
        return dp(n);
    }
```
- 배열 수행 후 dp 알고리즘을 수행한다.

### DP
```java
    private static int dp(int k) {
        if (dp[k] > 0) {
            return dp[k];
        }
        if (k==1) {
            return dp[k] = 1;
        }
        if (k==2) {
            return dp[k] = 2;
        }
        return dp[k] = dp(k-2) + dp(k-1);
    }
```
- 전에 사용한 결과를 재사용
- 저장값이 양수이면 계산이 끝난 것이므로 배열 내용을 꺼내 재사용한다
- 계산 후 배열에 저장한다

---

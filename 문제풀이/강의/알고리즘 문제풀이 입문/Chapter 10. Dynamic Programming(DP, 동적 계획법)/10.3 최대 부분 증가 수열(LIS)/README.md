# 10.3 최대 부분 증가 수열(LIS)
- 분류 : DP
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 10.3)

---

## LIS (최대 부분 증가 수열) 알고리즘
- 최대 부분 증가 수열 : 수열이 주어질 때, 그 중 가장 길게 증가하는 원소들의 집합

## 풀이

### main
```java
    private static int n; // n개의 자연수
    private static int[] numbers; // 숫자들
    private static int[] dp; // i번째 숫자를 마지막 숫자로 했을 때의 최대 부분 증가수열의 길이
```
- n : 숫자의 갯수
- numbers : 숫자들
- dp
  - `dp[i]`는 i번째 인덱스에서 끝나는 최장 증가 부분 수열의 길이를 의미한다.

### input
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int answer = solution();
        System.out.print(answer);
    }
```

### solution
```java
    private static int solution() {
        dp[0] = 1;
        int max;
        int answer = Integer.MIN_VALUE;
        for (int i=1; i<n; i++) {
            max = 0; // 앞의 dp 값 중 최댓값
            for (int j=0; j<i; j++) {
                if (numbers[j] < numbers[i] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1; // dp[i]는 앞 dp 최댓값 + 1이다.
            answer = Math.max(answer, dp[i]); // 모든 dp[i] 값 중 최댓값이 정답
        }
        return answer;
    }
```
- 0번 인덱스를 1로 초기화한다.
- 정수 부분수열에서, i번째 요소 `numbers[i]`가 증가 부분 수열의 마지막 값이 되기 위해서는 이 숫자가 추가되기 전 증가부분수열의 마지막 값이 `numbers[i]`보다 작은 값이어야 한다.
- `numbers[i]`를 마지막 값으로 가지는 가장 긴 증가 부분 수열의 길이는 `numbers[i]`가 추가될 수 있는 증가 부분 수열 중 가장 긴 수열의 길이에 1을 더한 값이 되어야 한다.

---

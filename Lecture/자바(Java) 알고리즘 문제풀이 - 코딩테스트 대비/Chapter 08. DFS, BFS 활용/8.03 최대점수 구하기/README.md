# 8.03 최대점수 구하기
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.03)

---

## 풀이

### 정적 변수
```java
    private static int n; // 문제 수
    private static int m; // 제한 시간
    private static int[] scores; // 점수들
    private static int[] times; // 소요 시간들
    private static int answer = Integer.MIN_VALUE; // 제한 시간 내에 얻을 수 있는 최대 점수
```
- n : 문제수
- m : 제한 시간
- scores : 점수들
- times : 소요시간들
- answer : 제한 시간 내에 얻을 수 있는 최대 점수

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        scores = new int[n];
        times = new int[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            scores[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dfs(0, 0, 0);
        System.out.print(answer);
    }
```
- 입력을 받고 dfs를 수행후 answer를 출력한다.

### DFS
```java
    private static void dfs(int index, int scoreSum, int timeSum) {
        if (timeSum > m) return; // 초과하면 더 따져봤자 조건에 부합할 가능성이 없다.
        if (index == n) {
            answer = Math.max(answer, scoreSum);
            return;
        }
        dfs(index + 1, scoreSum + scores[index], timeSum + times[index]); // 현재 index에 대응하는 문제를 풀 경우
        dfs(index + 1, scoreSum, timeSum); // 현재 index에 대응하는 문제를 풀지 않을 경우
    }
```
- timeSum이 m보다 크면 더 따질 필요 없이 조건에 부합하지 않으므로 return
- index가 n이면 answer와 scoreSum을 비교해 최댓값을 갱신한다.
- index가 n 미만이면
  - 현재 인덱스의 문제를 푼 경우, 풀지 않은 경우를 고려하여 dfs 한다.

---

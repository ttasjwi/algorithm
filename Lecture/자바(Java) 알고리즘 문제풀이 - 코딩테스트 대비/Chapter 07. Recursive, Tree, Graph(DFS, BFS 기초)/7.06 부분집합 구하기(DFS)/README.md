# 7.06 부분집합 구하기(DFS)
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.06)

---

## 풀이

### 입출력
```java
    private static int n;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder answer = solution();
        System.out.print(answer);
    }
    private static StringBuilder solution() {
        used = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        dfs(1, sb);
        return sb;
    }
```
- n : 최대 숫자
- used : 사용되었는 지 여부

### DFS
```java

    private static StringBuilder dfs(int i, StringBuilder sb) {
        if (i > n) { // n보다 큰 숫자는 포함 대상이 아니다.
            boolean emptySet = true;
            for (int j=1; j<=n; j++) {
                if (used[j]) {
                    emptySet = false;
                    sb.append(j).append(' ');
                }
            }
            if (!emptySet) sb.append('\n');
            return sb;
        }
        used[i] = true; // 자기 자신을 포함한 상황
        dfs(i+1, sb);
        used[i] = false; // 자기 자신을 포함하지 않은 상황
        dfs(i+1, sb);
        return sb;
    }
```
- 자기 자신이 사용됐다고 체크하고
  - 다음 요소로 진행해서 가지치기 한다.
- 자기 자신이 사용되지 않았다고 체크하고
  - 다음 요소로 진행해서 가지치기 한다.
- 가지의 끝 (n을 넘어간 시점)에서는 모든 사용된 요소를 sb에 append 한다.

---


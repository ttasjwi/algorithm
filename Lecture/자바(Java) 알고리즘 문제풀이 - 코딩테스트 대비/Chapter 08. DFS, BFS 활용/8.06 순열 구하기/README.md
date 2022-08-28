# 8.06 순열 구하기
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.06)

---

## 풀이

### 정적 변수
```java
    private static int n; // 숫자의 갯수
    private static int m; // 몇개 뽑니
    private static int[] numbers; // 숫자들
    private static int[] selectedNumbers; // 선택된 숫자들
    private static boolean[] checked; // 체크 여부
    private static StringBuilder sb;
```

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        checked = new boolean[n];

        m = Integer.parseInt(st.nextToken());
        selectedNumbers = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        String answer = solution();
        System.out.print(answer);
    }
```
- 입력후 solution을 통해 answer를 얻어와 출력한다.

### solution
```java
    private static String solution() {
        sb = new StringBuilder();
        dfs(0);
        return sb.toString();
    }
```
StringBuilder를 초기화하고, dfs 진행 후 sb 내용물을 문자열로 변환해 반환

### DFS
```java
    private static void dfs(int index) {
        if (index == m) {
            for (int selectedNumber : selectedNumbers) {
                sb.append(selectedNumber).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i=0; i<n; i++) {
            if (!checked[i]) { // 선택되지 않았다면
                checked[i] = true;
                selectedNumbers[index] = numbers[i]; // 선택
                dfs(index + 1);
                checked[i] = false;
            }
        }
    }
```
- index가 m이면 현재 선택된 숫자들을 sb에 append
- index 0~n까지 반복하면서
  - 현재 선택되지 않은 숫자를 선택(체크배열 체크, 선택 숫자에 삽입)
  - 나머지 숫자들을 dfs 돌린뒤
  - 선택을 해제한다.

---

# 8.04 중복순열 구하기
- 분류 : DFS
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.04)

---

## 풀이

### 정적 변수
```java
    private static int n; // 1~n까지
    private static int m; // m개
    private static StringBuilder sb;
    private static int[] numbers; // 숫자들을 순서대로 저장할 배열
```
- n : 숫자 범위
- m : 몇 개 선택할래
- sb : StringBuilder
- numbers : m개의 숫자를 순서대로 저장할 배열

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String answer = solution();
        System.out.print(answer);
    }
```
- 값을 입력받고 solution을 실행
- 출력

### solution
```java
    private static String solution() {
        numbers = new int[m]; // m개의 자리를 마련함
        sb = new StringBuilder();
        dfs(0);
        return sb.toString();
    }
```
- 크기가 m인 배열을 초기화한다.
- dfs를 호출한다.
- StringBuiler의 내용 문자열을 반환

### dfs
```java
    private static void dfs(int index) {
        if (index == m) {
            for (int number : numbers) sb.append(number).append(' ');
            sb.append('\n');
            return;
        }
        for (int i=1; i<=n; i++) {
            numbers[index] = i;
            dfs(index + 1);
        }
    }
```
- 인덱스가 m이면 배열이 꽉찼으므로 배열의 모든 요소를 순서대로 `sb`에 `append`한다.
- 이 메서드는 현재 인덱스에 1~n까지 순서대로 값을 채우고, 다음 인덱스를 인자로 넣은 dfs를 호출한다.
- 이 방식대로 돌면 1~n 중에서, m개를 택한 중복순열을 오름차순으로 출력할 수 있게 된다.

---

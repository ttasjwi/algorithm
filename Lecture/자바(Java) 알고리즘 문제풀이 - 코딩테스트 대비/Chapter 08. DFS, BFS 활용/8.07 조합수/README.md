# 8.07 조합수
- 분류 : 재귀, 메모이제이션
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.07)

---

## 풀이

### 정적변수
```java
    private static int[][] combinations;
```
- 조합수를 메모이제이션 하기 위한 이차원배열

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        combinations = new int[n+1][n+1];

        int answer = combination(n, r);
        System.out.print(answer);
    }
```
- n,r을 입력 받고 combintation 메서드를 호출해서 조합을 구한다.

### combination
```java
    private static int combination(int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == n || r == 0) {
            return combinations[n][r] = combinations[n][0] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][r] = combinations[n][n-r] = n;
        }
        return combinations[n][r] = combinations[n][n-r] = combination(n-1, r-1) + combination(n-1, r);
    }
```
- `combinations[n][r]`이 0보다 크다는 것은 이미 값이 저장되어 있다는 뜻. 저장된 값을 꺼내 쓴다.
- 기본적으로 n개 중에 r개를 택하는 경우의 수는 n개중에 n-r개를 선택하지 않는 경우의 수와 같다. 이를 이용하여 쌍으로 저장한다.
- n개 중 n개를 선택하는 경우의 수 == n개 중 0개를 선택하지 않는 경우의 수 == 1
- n개 중 1개를 선택하는 경우의 수 == n개 중 n-r개를 선택하지 않는 경우의 수 == 1
- n개 중 r개를 선택하는 경우의 수는 어떤 원소를 반드시 포함하는 경우와 그 원소를 포함하지 않는 경우의 수와 같다.

---

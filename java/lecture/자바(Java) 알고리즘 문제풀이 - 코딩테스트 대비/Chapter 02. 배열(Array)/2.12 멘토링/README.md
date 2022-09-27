
# 2.12 멘토링

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.12)

---

## 풀이1 (내 풀이)

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 테스트 횟수

        int[][] ranks = new int[N][M]; // 각 학생마다, 시험 당시 등수


        for (int i=0; i<M; i++) { // i번째 테스트에서
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) { // j등의
                int k = Integer.parseInt(st.nextToken()) - 1; // 학생 번호는 k
                ranks[k][i] = j; // k 학생은 i번째 테스트에서 j등
            }
        }
        br.close();

        int answer = solution(ranks, N, M);
        System.out.print(answer);
    }
```
- 입력받는 규격 그대로 바로 배열에 넣지 않고, 각 학생별의 각 테스트 결과 등수를 배열에 저장
  - 결국 테스트마다 각 학생의 등수를 서로 비교해야하는데, 등수를 따로 저장해두지 않으면 매번 등수를 꺼낼 떄 반복문 돌면서 찾아야한다.
  - 등수를 저장해두면 비교가 편리하다.

### 로직
```java
    private static int solution(int[][] ranks, int n, int m) {
        boolean isMento;
        int count = 0;
        for (int i=0; i<n; i++) { // i번 학생
            for (int j=0; j<n; j++) { // j번 학생
                if (i==j) {
                    continue;
                }
                isMento = true;
                for (int k=0; k<m; k++) { // k번째 테스트 등수
                    if (ranks[i][k] > ranks[j][k]) {
                        // i학생의 k번째 테스트 등수가 j학생의 k번째 테스트 등수보다 한번이라도 뒤쳐지면
                        isMento = false;
                        break;
                    }
                }
                if (isMento) {
                    count ++;
                }
            }
        }
        return count;
    }
```
- 배열에 각 학생의 각 테스트별로, 등수를 순서대로 저장해뒀기 때문에 비교가 편리하다.
- 시간 복잡도 : `O(n^2 m)`

---
## 풀이2 - 강사님 풀이

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 테스트 횟수

        int[][] results = new int[M][N];


        for (int i=0; i<M; i++) { // i번째 테스트에서
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) { // j등은
                results[i][j] = Integer.parseInt(st.nextToken()); // ~학생이다.
            }
        }
        br.close();

        int answer = solution(results, N, M);
        System.out.print(answer);
    }
```
- 각 줄마다 해당 테스트의 1등,2등,3,... 등이 주어짐
- 배열에 그대로 바로 저장한다.
  - `result[i][j] = ...` : i번 테스트의 j등은 `...`

### 풀이
```java
    private static int solution(int[][] results, int n, int m) {
        int positionT; // t의 등수
        int positionU; // u의 등수
        int count = 0;

        boolean isMento;

        for (int t=1; t<=n; t++) { // t번 학생
            for (int u=1; u<=n; u++) { // u번 학생에 대하여

                if (t == u) { // 같은 사람이면 계산 안 함
                    continue;
                }

                isMento = true;

                for (int i=0; i<m; i++) { // i번 테스트
                    positionT = positionU = 0;
                    for (int j=0; j<n; j++) { // j등이 누군지 확인해서
                        if (t == results[i][j]) {
                            positionT = j; // t의 등수 찾기
                        }
                        if (u == results[i][j]) {
                            positionU = j; // j의 등수 찾기
                        }
                    }
                    if (positionT > positionU) {
                        isMento = false;
                        break;
                    }
                }
                if (isMento) {
                    count ++;
                }
            }
        }
        return count;
    }
```
- 4중 for문
- 학생 두명, 그리고 i번 테스트를 놓고 각 학생이 해당 테스트에서 몇 등 했는지 찾는다.
  - 이 때문에 4중 for문을 돌아야한다. 등수를 반복문 돌려서 찾아야한다.
- 시간복잡도 : `O(n^3 * m)`

---

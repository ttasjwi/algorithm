
# 2.10 봉우리

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.10)

---

## 풀이
### 방향배열
```java
    private static final int[] DIRECTION_X = {1, 0, -1, 0}; // 동남서북
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};
```

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n + 2][n + 2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = solution(numbers, n);
        System.out.print(answer);
    }
```
- 숫자 배열을 2칸 더 벌려서 받음(경계선 계산의 편의성)

### 로직
```java
    private static int solution(int[][] numbers, int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isMountainTop = true;
                for (int k = 0; k<4; k++) {
                    int nx = j + DIRECTION_X[k];
                    int ny = i + DIRECTION_Y[k];
                    if (numbers[i][j] <= numbers[ny][nx]) {
                        isMountainTop = false;
                        break;
                    }
                }
                if (isMountainTop) count ++;
            }
        }
        return count;
    }
```
- 동남서북의 요소들을 순차적으로 탐색하여, 한개라도 자신보다 같거나 큰 것이 있으면 봉우리가 아님
- 없으면 `count ++`

---

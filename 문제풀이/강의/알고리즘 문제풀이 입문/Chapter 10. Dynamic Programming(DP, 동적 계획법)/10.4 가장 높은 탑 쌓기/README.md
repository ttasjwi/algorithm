# 10.4 가장 높은 탑 쌓기
- 분류 : DP
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 10.4)

---

## 풀이

### Brick
```java
public class Brick implements Comparable<Brick> {

    int area; // 밑면의 넓이
    int height; // 높이
    int weight; // 무게

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    // 넓이를 기준으로 오름차순 정렬
    @Override
    public int compareTo(Brick other) {
        return this.area - other.area;
    }

}
```
- 문제에서 제약한게 넓이, 무게의 대소인데 두가지 기준을 기준으로 따지려 들면 상황이 매우 복잡해진다.
- 이 경우 한 기준으로 정렬하면 다른 기준으로만 생각하면 되니, 문제를 좀 더 간단히 할 수 있다.
- 벽돌의 면적을 기준으로 오름차순 정렬한다. (무게를 기준으로 해도 상관은 없다)

### 정적 변수
```java
private static int n; // 벽돌의 수
private static Brick[] bricks; // 벽돌들
private static int[] dp; // i번째 벽돌을 맨 밑의 요소로 했을 때의 최대 높이
```
- `dp`에는 i번째 벽돌을 제일 밑에 뒀을 때 탑의 최대 높이를 저장한다.

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }
```

### input
```java
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bricks = new Brick[n];
        dp = new int[n];

        StringTokenizer st;
        int area, height, weight;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            area = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            bricks[i] = new Brick(area, height, weight);
        }
        br.close();
    }
```

### solution
```java
    private static int solution() {
        Arrays.sort(bricks);

        int maxHeight; // 그 위에 놓을 수 있는 최대 높이
        int answer = 0;
        for (int i=0; i<n; i++) {
            maxHeight = 0;
            for (int j=0; j<i; j++) {
                if (bricks[j].weight < bricks[i].weight && maxHeight < dp[j]) {
                    maxHeight = dp[j];
                }
            }
            dp[i] = maxHeight + bricks[i].height; // i번 벽돌을 제일 밑에 뒀을 때의 최대 높이
            answer = Math.max(answer, dp[i]); // 최대 높이
        }
        return answer;
    }
```
- 벽돌을 면적 기준으로 오름차순 정렬한다.
- 면적 기준으로 오름차순 정렬했으므로 앞의 벽돌은 절대 뒤의 벽돌 밑에 놓일 수 없다.
- 최대 부분 증가 수열(LIS) 알고리즘과 동일해진다.
- i번째 벽돌을 제일 위에 뒀을 때 탑의 최대 높이는
  - 0~i-1 번째 벽돌 중 i번째 벽돌보다 넓이/무게가 작은 k번 벽돌 기준으로
  - 최대의 `dp[k]`에 i번 벽돌의 높이를 더한 것과 같다.(제일 높은 탑을 i번 벽돌 위에 쌓는다고 보면 됨.)
- `dp`를 전부 순회하여 제일 높이가 높은 것이 최대 높이이다.

---

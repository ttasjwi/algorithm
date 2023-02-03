# 6.10 마굿간 정하기
- 분류 : 매개변수 탐색, 결정 알고리즘
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.10)

---

## 풀이
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 마굿간의 갯수 (  3<=n<=200,000)
        int c = Integer.parseInt(st.nextToken()); // 말의 수 (2<= c < =n)

        int[] barns = new int[n]; // 마굿간들
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i = 0; i < n; i++) {
            barns[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(barns, n, c); // 가장 가까운 두 말의 최대거리
        System.out.print(answer);
    }
```

### 로직
```java
    private static int solution(int[] barns, int n, int c) {
        int answer = -1;
        Arrays.sort(barns);

        // 탐색하고자 하는 것 : 가장 가까운 두 말 사이의 거리 (최대)
        int lt = 1; // 마굿간이 바로 옆에 붙어있을 때
        int rt = barns[n-1] - barns[0]; // 검색 최대 범위(첫번째 마굿간 ~ 마지막 마굿간 거리)
        int mid;
        int maxHorseCount;

        while(lt <= rt) {
            mid = (lt + rt) / 2; // 가장 가까운 두 말 사이의 거리
            maxHorseCount = getMaxHorseCount(barns, n, mid); // 제한에 맞게 배치했을 때 배치할 수 있는 말의 최대 갯수

            if (maxHorseCount >= c) { // 최소거리 제한이 느슨해서 더 많이 배치할 수 있다면
                answer = mid;
                lt = mid + 1; // 최소거리 제한 조건을 좀 더 늘려본다. (더 엄격하게 해서 최적화 시도)
            } else {
                rt = mid - 1; // 말을 전부 배치할 수 없다면 제한 조건을 좀 더 느슨하게 해본다.
            }
        }
        return answer;
    }
```
- 찾고자 하는 것 : 가까운 두 말의 최소 거리를 최대한 멀리 잡기(최댓값)
- lt, rt, mid (이분 탐색)
- maxHorseCount : 현재 말 사이 최소거리를 기준으로 마굿간에 배치할 수 있는 최대 마릿수
  - getMaxHorseCount 메서드로 구한다.
- maxHorseCount가 c보다 크거나 같으면, 조건에는 맞지만 더 최적화 할 수 있는지 시도를 한다.
  - answer를 mid로 갱신한다.(최적화된 현재 정답)
  - 최소거리제한을 더 엄격하게 하기 위해 lt를 mid보다 크게 해본다.
- maxHorseCount가 c보다 작으면, 최소거리 제한이 너무 엄격해서 모든 말을 배치할 수 없는 상황이다.
  - 최소거리제한을 좀더 느슨하게 하기 위해 rt를 mid보다 작게 한다.

### getMaxHorseCount
```java
    // 거리 최소 제한에 맞게 말을 순서대로 배치했을 때 가능한 배치 말의 최대 갯수
    private static int getMaxHorseCount(int[] barns, int n, int minDistance) {
        int count = 1; // 배치 가능한 말의 수
        int before = barns[0];
        int distance; // 이전 말과의 거리
        for (int i=1; i<n; i++) {
            distance = barns[i] - before;

            if (distance >= minDistance) { // 최소거리 이상 벌려져있을 때 배치 가능하다.
                count ++;
                before = barns[i];
            }
        }
        return count;
    }
```
- 현재 주어진 최소거리제한에 맞게 말을 순서대로 배치해가면서 최대한 배치할 수 있는 말의 갯수를 구하여 반환

---


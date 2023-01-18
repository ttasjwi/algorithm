# 6.09 뮤직비디오

- 분류 : 매개변수 탐색, 결정 알고리즘
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.09)

---

## 풀이
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 노래 갯수
        int m = Integer.parseInt(st.nextToken()); // 허용되는 DVD 갯수

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(numbers, n, m);
        System.out.print(answer);
    }
```

### 로직
```java
    private static int solution(int[] numbers, int n, int m) {
        int answer = 0;
        int lt = Arrays.stream(numbers).max().getAsInt();
        int rt = Arrays.stream(numbers).sum();
        int count;
        int mid;

        while (lt <= rt) {
            mid = (lt + rt) / 2; // 값을 정해둔다
            count = getCount(numbers, mid);

            if (count <= m) { // 조건에 부합하는 상황이면 일단 rt의 범위를 좀 더 줄여본다.
                answer = mid;
                rt = mid - 1;
            } else { // 조건에 부합하지 않는 상황이면  lt를 mid보다 크게 한다.
                lt = mid + 1;
            }
        }
        return answer;
    }
```
- 매개변수 탐색
- n : 전체 곡의 갯수
- m : 허용하는 DVD 최대 갯수
- 검색 초기 범위
  - lt : 주어진 배열의 최솟값
  - rt : 주어진 배열의 모든 요소의 합
- mid : lt, rt의 평균값. 현재 용량
- count  : 현재 mid를 용량으로 하였을 때, 수록하는 DVD의 갯수
  - getCount : 후술
- answer: 찾고자 하는 값
- count(DVD 갯수)와 m(허용하는 DVC 최대 갯수)을 비교했을 때
  - 같거나 적으면
    - 일단 answer를 mid로 한다.
    - 더 적은 범위 내에서 answer가 발견될 수 있으니, rt를 줄여 계속 검색해본다.
  - 더 많으면
    - 조건에 부합하지 않는다.
    - lt를 늘려서 더 큰 용량 범위로 찾는다.

### getCount
```java
    private static int getCount(int[] numbers, int capacity) {
        int cnt = 1, sum = 0;
        for (int number : numbers) {
            // 여태 누적한 sum과 비교했을 때
            if (sum + number > capacity) { // 용량을 초과한다면
                cnt ++;
                sum = number;
            } else {
                sum += number;
            }
        }
        return cnt;
    }
```
- cnt를 일단 1로 초기화한다.
- 배열의 값을 하나하나 읽고 sum에 추가한 값과 용량을 비교한다.
  - 용량 초과이면 cnt를 증가시키고, 다음 dvd에 해당 곡을 수록한다.
  - 그렇지 않으면 현재 dvd에 포함시킨다.(sum 증가)
- 최종적으로 cnt를 반환한다.

---

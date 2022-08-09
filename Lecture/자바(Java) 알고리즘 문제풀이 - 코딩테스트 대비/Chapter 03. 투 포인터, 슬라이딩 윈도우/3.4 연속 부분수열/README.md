# 3.4 연속 부분수열

- 분류 : 투 포인터(Two Pointer)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 3.4)

---

### 풀이1 : 누적합

### 1.1 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 숫자의 수
        int m = Integer.parseInt(st.nextToken()); // 특정 숫자

        int[] sums = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i=1; i<=n; i++) {
            int input = Integer.parseInt(st.nextToken());
            sums[i] = sums[i-1] + input; // 누적합
        }
        int answer = solution(sums, n, m);
        System.out.print(answer);
    }
```
- 입력 받을 때 누적합 배열로 입력받는다.

### 1.2 로직
```java
    private static int solution(int[] sums, int n, int m) {
        int start = 1;
        int end = 1;

        int count = 0; // 조건에 부합하는 부분수열의 갯수
        int rangeSum = 0; // 범위 합

        while (start <=n) {
            if (end >n) {
                start++;
                end = start;
                continue;
            }
            rangeSum = sums[end] - sums[start-1];
            if (rangeSum == m) { // 범위 합이 일치하면
                count ++;
                start ++; // 그 이상의 범위는 계속 더 해봐야 더 클 수밖에 없다
                end = start;
            } else if (rangeSum > m) { // 값이 더 크면 해당 범위에서 계속 찾아봐야 답이 안 나온다.
                start ++; // 윈도우를 다음 범위로 이동
                end = start;
            } else {
                end ++; // 값이 부족하므로 윈도우의 길이를 늘려본다.
            }
        }
        return count;
    }
```
- 누적합 방식 + 투 포인터
- 다만 이 방식은, end를 다시 앞으로 땡겨옴으로서 시간 손실이 발생한다.
- 2,3 방식에서는 end가 절대 후퇴하지 않으므로 개선이 필요.

---

## 풀이2 : Main2 - 강사님 풀이(투 포인터)

### 2.1 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 숫자의 수
        int m = Integer.parseInt(st.nextToken()); // 특정 숫자

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = solution(arr, n, m);
        System.out.print(answer);
    }
```
- 각각의 수들을 순차적으로 입력받는다.

### 2.2 로직
```java
    private static int solution(int[] arr, int n, int m) {
        int count = 0;
        int sum = 0;
        int start = 0;
        for (int end=0; end<n; end ++) {
            sum += arr[end];
            if (sum == m) {
                count ++;
            }
            while (sum >= m) {
                sum -= arr[start++];
                if (sum == m) {
                    count ++;
                }
            }
        }
        return count;
    }
```
- 투 포인터 사용
- start~end 범위의 합을 구한다. (최초에는 start, end 값이 같으므로 end값만 합산한다.)
- sum에 `arr[end]` 합산 후, sum이 m과 같으면 count 증가
- sum이 만약 m이상이면, m보다 작아질 때까지
  - `arr[start]`만큼 sum에서 차감시키고
  - start를 오른쪽으로 이동
  - 반복시키는 동안 sum과 m이 같은 때가 오면 count를 증가시킨다.
- 끝까지 돌고나서는 end를 증가시킨다.
- 이 로직의 특이 사항은 start, end가 절대 뒤로 가지 않는다. 시간 복잡도가 O(n)이다.

---

## 풀이3 : 내가 푼 누적합 방식 + 강사님 방식 (Main 3)

### 3.1 입출력
- 1번 풀이의 내 입출력과 같다.(누적합으로 입력)

### 3.2 로직
```java
    private static int solution(int[] sums, int n, int m) {
        int start = 1;

        int count = 0; // 조건에 부합하는 부분수열의 갯수
        int rangeSum = 0; // 범위 합

        for (int end = 1; end<=n; end ++) {
            rangeSum = sums[end] - sums[start-1];

            if (rangeSum == m) {
                count++;
            }
            while (rangeSum >=m) {
                rangeSum = sums[end] - sums[(++start) - 1];
                if (rangeSum == m) {
                    count ++;
                }
            }
        }
        return count;
    }
```
- 범위의 누적합을 구할 때는 단순히 범위 끝 시점의 누적합에서, 범위 시작 전까지의 누적합을 뺴주면 된다.
  - 누적합을 구할 때 좀 더 편리하게 계산할 수 있다.
- 그 외 세세한 로직은 1번 풀이와 같다.

---
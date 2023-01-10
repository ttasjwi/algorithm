
# 2.09 격자판 최대합

- 분류 : 배열(Array) - 2차원
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.09)

---

## 풀이1(내 풀이) : 배열에 합산결과 저장
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n][n];

        StringTokenizer st;


        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = solution(numbers);
        System.out.print(answer);
    }
```
- 2중 for문에 입력

### 합계 구하기
```java
    private static int solution(int[][] numbers) {
        int leftCrossSum = 0;
        int rightCrossSum = 0;

        int[] verticalSums = new int[numbers.length];
        int[] horizontalSums = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            for (int j=0; j<numbers.length; j++) {
                if (i==j) {
                    leftCrossSum += numbers[i][j];
                }
                if (i+j == numbers.length-1) {
                    rightCrossSum += numbers[i][j];
                }
                verticalSums[j] += numbers[i][j];
                horizontalSums[i] += numbers[i][j];
            }
        }
```
- 배열을 2중 for문 돌면서
  - 조건에 맞는 행/열일 때 대각선 합에 합산
  - 가로 세로 누적
### 최댓값 계산
```java
        int max = Math.max(leftCrossSum, rightCrossSum);

        for (int verticalSum : verticalSums) {
            max = Math.max(max, verticalSum);
        }
        for (int horizontalSum : horizontalSums) {
            max = Math.max(max, horizontalSum);
        }
        return max;
    }
```
- 가로대각선합, 세로대각선합 중 최댓값 구하기
- 가로누적값, 세로누적값을 전부 탐색해서 최댓값 구하기

---

## 풀이2(강사님 풀이)
```java
   private static int solution(int[][] numbers) {
        int answer = 0;
        int leftCrossSum = 0;
        int rightCrossSum = 0;

        int verticalSum, horizontalSum;

        for (int i=0; i<numbers.length; i++) {
            verticalSum = horizontalSum = 0;
            for (int j=0; j<numbers.length; j++) {
                if (i==j) {
                    leftCrossSum += numbers[i][j];
                }
                if (i+j == numbers.length-1) {
                    rightCrossSum += numbers[i][j];
                }
                horizontalSum += numbers[i][j]; // 가로합
                verticalSum += numbers[j][i]; // 세로합
            }
            answer = Math.max(answer, verticalSum);
            answer = Math.max(answer, horizontalSum);
        }
        answer = Math.max(answer, leftCrossSum);
        answer = Math.max(answer, rightCrossSum);
        return answer;
    }
```
- 가로합, 세로합을 굳이 배열에 저장하지 않고 for문 돌면서 그 때 그 때 최댓값 갱신을 전부 진행


# 2.08 등수 구하기

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.08)

---

## 풀이1 : 처음 인덱스를 저장해둔 객체 사용, 정렬기능 사용

### 1.1 Result1 객체 정의
```java
class Result1 implements Comparable<Result1> {

    int originalIndex;
    int score;

    public Result1(int originalIndex, int score) {
        this.originalIndex = originalIndex;
        this.score = score;
    }


    @Override
    public int compareTo(Result1 o) {
        return o.score - this.score; // 내림차순
    }
}
```
- 처음 입력받은 시점의 순서, 점수를 저장해두는 객체를 정의한다.
- Comparable을 구현한다.
    - score 기준 **내림차순**으로 구현한다.
### 1.2 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Result1[] results = new Result1[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int score = Integer.parseInt(st.nextToken());
            results[i] = new Result1(i, score);
        }
        String answer = solution(results);
        System.out.print(answer);
    }
```
- 점수를 입력받는 부분에서 배열 초기화 시, 인덱스와 점수를 기반으로 객체 생성 후 저장한다.

### 1.3 풀이
```java
    private static String solution(Result1[] results) {
        Arrays.sort(results); // 내림차순 정렬
        int[] ranks = new int[results.length];

        int minValue = Integer.MAX_VALUE;
        int currentRank = 1; // 등수
        int sameScoreCount = 0; // 동점자 수

        for (Result1 result : results) {
            if (minValue > result.score) {
                minValue = result.score; // 점수가 더 작아졌으므로 현재 최솟값 갱신
                currentRank += sameScoreCount; // 이전 등수의 동점자수만큼 등수 증가
                ranks[result.originalIndex] = currentRank; // 현재 랭크를 반영

                sameScoreCount = 1; // 동점자 수를 1로 초기화
            } else { // 이전 사람과 비교했을 때 동점일 경우
                ranks[result.originalIndex] = currentRank; // 현재 랭크를 반영
                sameScoreCount ++; // 동점자 수 증가
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int rank : ranks) {
            sb.append(rank).append(' ');
        }
        return sb.toString();
    }
```
- 내림차순 정렬한다.
- 배열을 순회한다.
- 점수가 더 낮아지면
  - 최솟값을 갱신한다.
  - 이전 등수의 동점자 수만큼 rank를 증가시킨다.
  - 현재 랭크를 반영한다.
  - 동점자수를 1로 초기화한다.
- 점수가 같으면(동점자이면)
  - 현재 랭크를 그대로 반영한다.
  - 동정자수를 증가시킨다.

---

## 풀이2 : 2중 for문 → 점수가 더 높은 사람 확인할 떄마다 rank 증가
```java
    private static String solution(int[] scores) {
        StringBuilder sb = new StringBuilder();
        int rank;

        for (int i=0; i< scores.length; i++) {
            rank = 1;
            for (int j=0; j<scores.length; j++) {
                if (i!= j && scores[j] > scores[i]) { // 자기 자신보다 높은, 다른 사람의 점수를 발견할 때마다
                    rank ++;
                }
            }
            sb.append(rank).append(' ');
        }
        return sb.toString();
    }
```
- 2중 for문을 돈다.
- rank는 초기에 1로 초기화
- 순서대로 rank를 순회
- 자기 자신은 비교하지 않음
- 자기보다 점수면 rank를 증가시킨다.
- 최종적으로 계산 완료된 rank를 StringBuilder에 추가

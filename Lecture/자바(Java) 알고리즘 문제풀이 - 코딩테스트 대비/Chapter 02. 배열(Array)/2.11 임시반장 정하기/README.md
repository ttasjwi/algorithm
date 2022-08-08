
# 2.11 임시반장 정하기

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.11)

---

## 풀이1 (내 풀이)

### 입출력
```java
    public static void main(String[] args) throws IOException {
        int n = readInt(); // 학생수
        int[][] bans = new int[n+1][6]; // 관리의 편의를 위해 1칸씩 크게 해서 입력

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=5; j++) {
                bans[i][j] = readInt();
            }
        }

        int answer = solution(bans, n);
        System.out.print(answer);
    }
```
- 계산의 편의를 위해, 학년, 학생수 +1 의 길이만큼으로 배열을 지정

### 인간관계 배열 knows 정의, 초기화
```java
   private static int solution(int[][] bans, int n) {
        boolean[][] knows = new boolean[n+1][n+1]; // 인간관계 배열
        for (int i=1; i<=n; i++) {
            knows[i][i] = true; // 자기 자신은 알고 있다.
        }
```
- 각 학생이 같은 반이였던 학생의 갯수를 계산하는 것이 중요하다.
- 행/열의 갯수가 n+1(계산의 편의를 위함)인 배열을 생성한다.
  - 각 행의 번호는 주체(a)
  - 각 열의 번호는 다른 사람(b)
  - a가 b를 알고 있으면 true다.
- 자기 자신은 자기 자신을 알고 있으므로(?) true로 초기화한다.

### knows 집계
```java
        int maxStudent = 0; // 제일 다른 학생을 많이 알고 있는 사람
        int maxCount = 0; // 제일 다른 학생을 많이 알고 있는 사람이 알고 있는 학생 수
        int count; // 알고 있는 학생 수

        for (int i=1; i<=n; i++) {
            count = 0;
            for (int j=1; j<=n; j++) { // 다른 학생 j에 대하여
                for (int k=1; k<=5; k++) { // 1학년~5학년을 순차적 확인하면서
                    if (knows[i][j]) { // 내가 쟤를 알면 굳이 계산할 필요가 없음
                        count ++;
                        break;
                    }
                    if (bans[i][k] == bans[j][k]) { // k학년 때 반이 서로 같으면
                        knows[i][j] = true; // 현재 학생은 저 학생을 알고 있다.
                        knows[j][i] = true; // 저 학생은 나를 알고 있다
                        count ++;
                        break;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxStudent = i;
                }
            }
        }

        return maxStudent;
    }
```
- i : 학생
- j : 다른 학생
- k : 학년
- `knows[i][j]` : i가 j를 알고 있는 지 여부

---

## 풀이2
```java
    private static int solution(int[][] bans, int n) {
        int maxIndex = 0;

        int maxCount = Integer.MIN_VALUE;
        int count;

        for (int i=1; i<=n; i++) {
            count = 0;
            for (int j=1; j<=n; j++) { // 다른 학생
                for (int k=1; k<=5; k++) { // 1~5학년
                    if (bans[i][k] == bans[j][k]) { // k학년 때 i학생, j학생의 반이 같으면
                        count ++; // count 증가
                        break; // 그 이후 학년은 고려 안 함
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
```
- 반이 같으면 그 순간 반복을 멈추고 break

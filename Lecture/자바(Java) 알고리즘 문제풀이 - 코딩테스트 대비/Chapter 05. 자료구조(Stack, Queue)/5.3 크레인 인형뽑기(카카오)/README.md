# 5.3 크레인 인형뽑기(카카오)

- 분류 : Stack
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 5.3)

---

## 풀이

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 크레인의 한변 길이
        int[][] dolls = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                dolls[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine()); // 크레인 작동 횟수
        int[] moves = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        for (int i=0; i<m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(dolls, moves, n);
        System.out.print(answer);
    }
```
- 변수
  - `int n` : 기계 한 변의 길이
  - `int[][] dolls` : 기계에 쌓여진 인형들의 상태를 기록한 이차원 배열
  - `int m` : 크레인 작동 횟수
  - `int[] moves` : 크레인 작동 위치 (1,2,3, ...)
- 출력
  - answer : 정답. `solution(...)`을 통해 얻어온다.
  - answer을 `sout`으로 출력한다.

### 전체 로직
```java
    private static int solution(int[][] dolls, int[] moves, int n) {
        int count = 0; // 터트려서 사라진 인형의 갯수

        Stack<Integer> basket = new Stack<>(); // 바구니
        for (int move : moves) {
            int doll = getDoll(dolls, n, move); // 인형을 뽑아온다.

            if (doll == 0) { // 뽑아온 인형이 없으면 아무 것도 하지 않는다.
                continue;
            }
            if (!basket.isEmpty() && basket.peek() == doll) { // 바구니의 최상단 인형이 뽑은 인형과 같으면
                basket.pop(); // 바구니에서 꺼낸다.
                count += 2; // 인형이 쌍으로 터진다.
            } else { // 바구니가 비어있거나, 바구니 최상단 인형이 뽑은 인형이 다르면
                basket.push(doll); // 바구니에 인형을 쌓는다.
            }
        }
        return count; // 최종적으로 터트려진 전체 인형의 갯수를 반환한다.
    }
```
- 스택을 생성하고 여기에 인형을 쌓는다.
- count에 터트린 인형의 갯수를 저장한다.
- moves를 읽어서 순서에 맞게 인형을 얻어오고 바구니에 인형을 담아가며, 경과를 기록한다.
  - `getDoll` : move 값을 읽고 dolls의 지정 위치에 있는 최상단 인형을 얻어온다.
  - 얻어온 doll이 없으면 아무 것도 하지 않는다. (`doll == 0`)
  - 얻어온 doll과, 바구니 최상단 인형을 비교하여 같으면 터트린다. 같지 않으면 쌓는다.
    - 터트릴 때, 쌍으로 터지므로 count를 2 증가 시켜야한다.
- 최종적으로 합산된 count를 반환한다.

### getDoll (인형을 뽑아오는 로직)
```java
    private static int getDoll(int[][] dolls, int n, int move) {
        int doll = 0; // 인형을 저장할 변수. 기본적으로 아무 것도 뽑지 않은 상태는 0이다.
        int index = move - 1; // 뽑을 위치(인덱스)

        for (int j = 0; j< n; j++) { // 인덱스로 이동하여 위에서부터(0,1,2, ...) 인형을 찾는다.
            if (dolls[j][index] != 0) { // 인형을 찾으면
                doll = dolls[j][index]; // 인형을 doll 변수에 저장한다.
                dolls[j][index] = 0; // 해당 위치를 비운다.
                break; // 인형을 찾았으므로 탐색을 중단하고 반복을 탈출한다.
            }
        }
        return doll; // doll 변수에 저장된 값을 반환한다.
    }
```
- 입력을 받을 때 1,2,3,... 순서 기반으로 입력받았는데 실제 저장은 배열에 0,1,2,... 로 저장되어 있으므로 괴리감이 있다.
- `move`에서 1을 차감하여 `index`에 할당한다.
- index 위치의 위에서부터(0,1,2,...) 인형을 찾아 doll에 저장하고 반환한다.
- doll을 못 찾으면 최종적으로 0이 저장된다.

---

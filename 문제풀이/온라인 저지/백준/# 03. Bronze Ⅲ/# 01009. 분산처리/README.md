# \[BOJ01009] 분산처리

- 난이도 : Bronze3
- 마지막 데이터가 처리될 컴퓨터의 번호 출력하기
- 문제 : <a href="https://www.acmicpc.net/problem/1009" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Idea

1. 각 자연수의 거듭제곱의 끝자리 수는, 주기적으로 반복된다.
   - 1 -> 1, 1, 1, 1, 1, ...
   - 2 -> 2, 4, 8, 6, 2 ,...
   - 3 -> 3, 9, 7, 1, 3, ...
   - 4 -> 4, 6, 4, ...
   - 5 -> 5, 5, ...
   - 6 -> 6, 6 ,...
   - 7 -> 7, 9, 3, 1, 7, ...
   - 8 -> 8, 4, 2, 6, 8 , ...
   - 9 -> 9, 1, 9, ...
   - 10 -> 0, 0, 0, 0, ...

---

## Main.java : 백준 제출 답안
```
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
```
- 사용자로부터 입력을 `BufferedReader`를 통해 받는다.
- `StringBuilder`에 출력값을 누적한다.
- 테스트의 갯수는 T다.

```
    int[][] comNumbers = {
            {10}, // a의 나머지가 10
            {1}, // 1
            {6,2,4,8}, // 2
            {1,3,9,7}, // 3
            {6,4}, // 4
            {5}, // 5
            {6}, // 6
            {1,7,9,3}, // 7
            {6,8,4,2}, // 8
            {1,9} // 9
    };

    while (T>0) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken())%10;
        int b = Integer.parseInt(st.nextToken());
        sb.append(comNumbers[a][b%(comNumbers[a].length)]).append('\n');
        T--;
    }
    br.close();
    System.out.println(sb);
}

```
- `comNumbers` : 컴퓨터의 번호를 모아둔 이차원 배열이다. 각 a별 거듭제곱 결과에 대응하는 값들을 모아뒀다.
- a를 10으로 나눈 뒤 a에 다시 저장한다.
- a는 `comNumbers`의 row를 결정한다.
- `b%(comNumbers[a].length)]`는 column을 결정한다.

---

## Review
- 자연수의 거듭제곱은 주기적으로 반복되는 점을 이용하는게 특징이였던 문제.
- 다소 수학적인 개념이 녹아있는 문제여서 곤란했다. 우리는 개발자 지망생이지, 수학자가 아니야!

---
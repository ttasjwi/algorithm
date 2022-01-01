# \[BOJ02438] 별 찍기 - 1

- 난이도 : Bronze3
- 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
- 문제 : <a href="https://www.acmicpc.net/problem/2438" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=N; i++) {
            for (int j=0; j<i; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
```
- 반복문의 처음 배우는 사람들이 한 번씩은 거치게 되는 문제
- 이중 for문을 활용

---

## Review
- 1위분들과 별 차이 없는 코드지만 시간이 아무리 해도 124ms에서 안 줄어듬.
- 백준 채점 점수에는 그러려니 하고 적당선에서 평균적인 속도 나오면 거기서 만족해야.

---
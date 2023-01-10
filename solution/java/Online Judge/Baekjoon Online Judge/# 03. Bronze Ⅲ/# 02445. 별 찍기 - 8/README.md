# \[BOJ02445] 별 찍기 - 8

- 난이도 : Bronze3
- 별의 갯수를 증가시키다가 감소시키면서 출력하도록 하기(첫째 줄부터 2×N-1번째 줄까지)
- 문제 : <a href="https://www.acmicpc.net/problem/2445" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int starCount = 1;

        while(starCount < N) {
            sb.append("*".repeat(starCount))
                    .append(" ".repeat(2 * (N - starCount)))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount++; // 별의 갯수 증가
        }
        while(starCount > 0) { 
            sb.append("*".repeat(starCount))
                    .append(" ".repeat(2 * (N - starCount)))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount--; // 별의 갯수 감소
        }

        System.out.print(sb);
    }
```
- starCount 값에 1을 주고, 별, 공백, 별을 순서대로 적절한 갯수만큼 출력후 starCount 증가
  - starCount가 N보다 작은 상황에서만 반복
- starCount 값이 N이 되는 순간부터는 다음 명령으로 넘어가서 동일한 작업을 진행후 starCount 감소
  - starCount가 0보다 큰 상황에서만 반복

---

## Review
- while문 2번 쓴게 좀 지저분하긴 하긴 하다.
  - while문 하나로 저 작업을 다 퉁치려면, boolean 변수를 도입해야하고, while문 조건식에서 이것도 추가로 따져줘야해서 속도가 더 느려질 것 같았음.

---
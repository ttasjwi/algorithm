# \[BOJ10992] 별 찍기 - 16

- 난이도 : Bronze3
- 예제를 보고 규칙을 유추하여 별 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/10992" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int line = 1;
        
        // 맨 위 꼭짓점
        StringBuilder sb = new StringBuilder()
                .append(" ".repeat(N-line))
                .append('*')
                .append('\n');
        line ++;

        while (line <N) {
            // 맨 밑변
            if (line == N) {
                sb.append("*".repeat(2*N-1));
                break;
            }
            // 사이구간
            sb.append(" ".repeat(N-line))
                    .append("*")
                    .append(" ".repeat(2*(line)-3))
                    .append("*")
                    .append("\n");
            line ++;
        }
        System.out.print(sb);
    }
```
- N : 입력값
- line : 그 라인의 번호 (1,2,3, ... , N)
- 맨 위 꼭짓점을 찍어야한다.
  - 첫번째 꼭짓점의 공백은 N-line개
  - 별을 하나 찍음
  - 개행 및 line 증가
- 그 후 line이 N 이하일 동안 다음을 반복한다.
  - `line==N`, 즉 마지막 라인일 때 : 2*N-1 개의 별을 찍고 반복문 탈출
- 그 사이구간일 때
  - N-line개의 공백을 찍고 별을 하나 찍는다.
  - 2*line -3개의 공백을 찍고 별을 하나 찍는다.
  - 개행 및 line 증가

---

## Review
- 맨위 꼭짓점, 사이구간, 맨 밑변을 구분해서 처리해야해서 애먹었음.
- Java 11 기준 1등했다. 히히힣

---
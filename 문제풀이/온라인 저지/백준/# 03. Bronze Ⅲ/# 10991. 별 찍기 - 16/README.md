# \[BOJ10991] 별 찍기 - 16

- 난이도 : Bronze3
- 예제를 보고 규칙을 유추하여 별 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/10991" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int frontSpace = N-1;

        while(frontSpace >=0) {
            sb.append(" ".repeat(frontSpace))
                    .append("* ".repeat(N-frontSpace))
                    .append('\n');
            frontSpace--; // 앞의 공백 제거
        }

        System.out.print(sb);

    }
```
- N : 입력값
- 반복 : frontSpace가 0 이상일 때
  - frontSpace: 앞에 출력될 공백. N-1부터 시작하여 매 작업 종료시 1 감소
  - 별의 갯수 : N-frontSpace

---

## Review
- 별찍기 지긋지긋해지고 힘들다...
- java 11 기준 1위(2022-01-02 기준)

---
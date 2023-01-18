# \[BOJ02441] 별 찍기 - 4

- 난이도 : Bronze3
- 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제(오른쪽 정렬)
- 문제 : <a href="https://www.acmicpc.net/problem/2441" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int count = N;

        while(count>0) {
            sb.append(" ".repeat(N-count))
                    .append("*".repeat(count))
                    .append('\n');
            count --;
        }
        System.out.print(sb);
    }
```
- count 값에 N을 주고 반복시마다 count를 감소시킨다
- N-count만큼 공백을 출력하고, count만큼 별을 출력한다.
  - repeat 메서드는 문자열을 지정횟수만큼 반복한 문자열을 반환하는 메서드다.

---

## Review
- 별의 별 메서드가 다 있네. repeat 메서드는 처음 알았다.

---
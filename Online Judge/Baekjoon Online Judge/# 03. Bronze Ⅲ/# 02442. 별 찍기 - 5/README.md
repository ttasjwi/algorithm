# \[BOJ02442] 별 찍기 - 5

- 난이도 : Bronze3
- 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제(가운데 대칭)
- 문제 : <a href="https://www.acmicpc.net/problem/2442" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int spaceCount = N-1;

        while(spaceCount>=0) {
            sb.append(" ".repeat(spaceCount))
                    .append("*".repeat(2*(N-spaceCount)-1))
                    .append('\n');
            spaceCount--;
        }
        System.out.print(sb);
    }
```
- spacecount(공백) 값에 N을 주고 반복시마다 count를 감소시켜서, 0 이상일 동안 반복
- spaceCount만큼 공백을 출력하고, 2*(N-spaceCount)-1 만큼 별 출력
    - repeat 메서드는 문자열을 지정횟수만큼 반복한 문자열을 반환하는 메서드다.

---

## Review
- 2441번 문제를 쓸 때 썼던 repeat 메서드를 다시 써 봤다.

---
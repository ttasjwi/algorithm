# \[BOJ02446] 별 찍기 - 9

- 난이도 : Bronze3
- 별의 갯수를 감소시키다가 증가시키면서 출력하도록 하기(첫째 줄부터 2×N-1번째 줄까지)
- 문제 : <a href="https://www.acmicpc.net/problem/2446" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int fullStar = 2*N-1;
        int starCount = fullStar;

        while(starCount > 1) {
            sb.append(" ".repeat((fullStar-starCount)/2))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount -= 2;
        }

        while(starCount <= fullStar) {
            sb.append(" ".repeat((fullStar-starCount)/2))
                    .append("*".repeat(starCount))
                    .append('\n');
            starCount += 2;
        }

        System.out.print(sb);

    }
}
```
- fullStar : 최대 별의 갯수 - 2*N-1
- starCount : 각 줄마다 삽입될 별의 갯수
- 앞 공백의 갯수 : (fullStar - starCount)/2
---

## Review
- 전에 풀었던 2445, 2522와 구조적으로 비슷
- java 11 기준으로 1등 먹음 히히힣

---
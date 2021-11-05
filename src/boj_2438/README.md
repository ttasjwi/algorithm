# boj_2438

난이도 : Bronze3
BOJ(백준) 1단계 - 입출력과 사칙연산

첫째 줄에는 별 1개, 둘째 줄에는 별 2개, ... N번째 줄에는 별 N개를 찍는 문제
문제 : <a href="https://www.acmicpc.net/problem/2438" target="_blank"> [링크]</a>
---  

## Answer : 백준 답안 제출용
```
public class Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nmbOfBars = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        final char ch = '*';
        for (int i=0; i<nmbOfBars; i++) { // Bar들의 갯수만큼 Bar을 출력하세요
            for (int j=0; j<i+1; j++) {
                sb.append(ch); // 각 Bar의 길이는 i+1
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
```
- 소스파일 : <a href="https://github.com/ttasjwi/BOJ/blob/master/src/boj_2438/Answer.java" target="_blank">gitHub</a>
- nmbOfBars : bar의 갯수 = 라인 수 (BufferedReader로 입력받은 값을 파싱)
- 이중 for문 : 각 라인별로 별의 갯수를 조절하기 위함

---

## Review
- 이중 for문을 쓰니 가독성이 떨어짐. 알고리즘이라 어쩔 수 없다.
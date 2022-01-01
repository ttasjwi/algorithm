# \[BOJ02439] 별 찍기 - 2

- 난이도 : Bronze3
- 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제(오른쪽 정렬)
- 문제 : <a href="https://www.acmicpc.net/problem/2439" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=N; i++) {
            for (int j=N; j>i; j--) { // N-i번
                sb.append(' ');
            }
            for (int j=0; j<i; j++) { // i번
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
```
- 반복은 1부터 N까지 i를 증가시키면서.
  - 공백을 N-i번 찍고, 별을 i번 찍기를 반복했다.

---

## Review
- 앞에 공백을 입력하는 횟수를 어떻게 할지 생각하는게 이 문제의 교훈.
- 속도 줄이고 싶어서 N-i번 반복하는걸 저렇게 적어버렸는데 그냥 0부터 N-i까지 반복시키는게 코드 가독성 면에서도 좋고 속도 차이 별로 없다.

---
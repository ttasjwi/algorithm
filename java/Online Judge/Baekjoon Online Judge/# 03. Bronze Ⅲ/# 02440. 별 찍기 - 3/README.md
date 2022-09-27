# \[BOJ02440] 별 찍기 - 3

- 난이도 : Bronze3
- 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
- 문제 : <a href="https://www.acmicpc.net/problem/2440" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
```
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        while (N>0) {
            for (int i=0; i<N; i++) {
                sb.append('*');
            }
            sb.append('\n');
            N --;
        }

        System.out.print(sb);

    }
```
- 처음 입력받은 N을 계속 감소시키는 while문을 통해 처리
- 현재 N의 값의 상태만큼 별의 값을 감소시키고 줄을 바꿔가면서 별을 출력

---

## Review
- 변수를 부가적으로 여러개 생성하지 않아도 되는 상황이면 굳이 for문을 안 쓰고 while문을 쓰는게 더 빠른 것 같다.

---
# \[BOJ 02675] 문자열 반복

- 난이도 : Bronze 2
- 문자열의 문자들을 지정 횟수만큼 반복해서 늘여쓰기
- 문제 : <a href="https://www.acmicpc.net/problem/2675" target="_blank">링크</a>

---  

## 풀이
```java

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int r;
        String word;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine()," ");
            r = Integer.parseInt(st.nextToken());
            word = st.nextToken();

            for (char c : word.toCharArray()) {
                for (int k=0; k<r; k++) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        br.close();
        System.out.print(sb);
    }
```
- StringBuilder를 적극 활용했다.

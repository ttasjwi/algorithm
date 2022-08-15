# \[BOJ 12605\] 단어순서 뒤집기

- 난이도 : Bronze1
- 문장을 단어단위로 거꾸로 출력하기(반복문/ 스택 활용)
- 문제 : <a href="https://www.acmicpc.net/problem/12605" target="_blank"> [링크]</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

        StringBuilder sb = new StringBuilder();
        String[] words;
        for (int i=1; i<=n; i++) {
            words = br.readLine().split(" ");
            sb.append("Case #").append(i).append(':').append(' ');

            for (int j=words.length-1; j>=0; j--) {
                sb.append(words[j]).append(' ');
            }

            sb.append('\n');
        }
        br.close();

        System.out.print(sb);
    }
```
- 입력받은 줄을 split 한다. (공백단위로)
- 역순으로 sb에 append한다.
- 매 라인마다 개행한다.
- 참고 : 스택을 활용해도 된다. 다만, 미세하게 느리다.

---

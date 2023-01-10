# \[BOJ 01259\] 펠린드롬수

- 난이도 : Bronze 1
- 문자열 가운데 기준으로 대칭인지 여부를 판단
- 문제 : <a href="https://www.acmicpc.net/problem/1259" target="_blank"> [링크]</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        boolean noFlag;
        while (!(input = br.readLine()).equals("0")) {
            noFlag = false;
            for (int i=0; i<input.length()/2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    noFlag = true;
                    break;
                }
            }
            if (noFlag) {
                sb.append("no").append('\n');
            } else {
                sb.append("yes").append('\n');
            }
        }
        br.close();
        System.out.print(sb);
    }
```
- 문자열 길이 절반 전까지 인덱스를 증가시키며, 대칭된 위치의 문자 비교

---

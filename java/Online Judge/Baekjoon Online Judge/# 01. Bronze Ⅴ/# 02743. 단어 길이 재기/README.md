
# \[BOJ 02743\] 단어 길이 재기

- 난이도 : Bronze5
- 문자열을 입력받고 문자열에 포함된 문자 갯수 반환
- 문제: <a href="https://www.acmicpc.net/problem/2743" target="_blank"> [링크]</a>

---

## 풀이 1 : System.in.read() 이용
```java
    public static int readCharCount() throws IOException {
        int count = 0;
        int input;

        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return count;
            } else {
                count ++;
            }
        }
    }
```
- 개행 또는 구분자가 올 때까지 문자 갯수를 누적

---

## 풀이 2: 문자열 length() 이용
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();

        System.out.print(line.length());
    }
```
- 문자열을 라인으로 입력받아서, length 메서드 호출

---
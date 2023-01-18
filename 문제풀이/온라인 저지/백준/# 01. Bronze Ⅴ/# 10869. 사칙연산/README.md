
# \[BOJ_10869\] 사칙연산

- 난이도 : Bronze5
- 단순 사칙연산
- 문제: <a href="https://www.acmicpc.net/problem/10869" target="_blank"> [링크]</a>

---

## 풀이 방식
```java

    public static void main(String[] args) throws IOException {
        int a = readInt();
        int b = readInt();

        StringBuilder sb = new StringBuilder();
        sb.append(a+b).append('\n')
                .append(a-b).append('\n')
                .append(a*b).append('\n')
                .append(a/b).append('\n')
                .append(a%b);
        System.out.print(sb);
    }

```
- 단순 사칙연산 입출력

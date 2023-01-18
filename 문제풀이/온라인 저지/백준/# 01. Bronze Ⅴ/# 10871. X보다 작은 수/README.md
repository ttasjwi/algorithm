# \[BOJ 10871\] X보다 작은 수

- 난이도 : Bronze 5
- 숫자 비교하기
- 문제 : https://www.acmicpc.net/problem/10871

---

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int x = readInt();
        StringBuilder sb = new StringBuilder();
        int input;
        for (int i=0; i<n; i++) {
            input = readInt();
            if (input < x) {
                sb.append(input).append(' ');
            }
        }
        System.out.print(sb);
    }
```
- 숫자를 순차적으로 입력받고 x보다 작으면 StringBuilder에 append한다.

---

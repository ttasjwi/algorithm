
# \[BOJ 02884\] 알람 시계

- 난이도 : Bronze3
- 시간의 뺼셈, 덧셈
- 문제: <a href="https://www.acmicpc.net/problem/2884" target="_blank"> [링크]</a>

---

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int h = readInt();
        int m = readInt();
        StringBuilder sb = new StringBuilder();

        m -= 45;
        if (m < 0) {
            m += 60;
            h -= 1;

            if (h < 0) {
                h += 24;
            }
        }
        sb.append(h).append(' ').append(m);
        System.out.print(sb);
    }
```
- 일단 m에서 45를 차감한다.
- m이 0보다 작은지 확인
  - m이 0보다 작으면 시간을 1 차감한다.
    - 그리고 시간이 0보다 작으면 시간에 24를 더한다.
- 출력한다.

---

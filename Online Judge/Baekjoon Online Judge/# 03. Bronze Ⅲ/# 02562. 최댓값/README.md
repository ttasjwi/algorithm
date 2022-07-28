
# \[BOJ 02562\] 최댓값

- 난이도 : Bronze3
- 최댓값, 최댓값이 위치한 순서
- 문제: <a href="https://www.acmicpc.net/problem/2562" target="_blank"> [링크]</a>

---

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int maxValue = 0;
        int maxValueOrder = -1;

        for (int i = 0; i < 9; i++) {
            int value = readInt();
            if (value > maxValue) {
                maxValue = value;
                maxValueOrder = i + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append('\n').append(maxValueOrder);

        System.out.print(sb);
    }
```
- 반복하면서 최댓값과 최댓값이 속한 순서를 저장, 갱신

---

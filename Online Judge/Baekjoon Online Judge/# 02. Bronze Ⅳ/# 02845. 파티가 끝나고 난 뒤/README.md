# \[BOJ 02845\] 파티가 끝나고 난 뒤

- 난이도 : Bronze4
- 단순 사칙연산, 비교
- 문제 : <a href="https://www.acmicpc.net/problem/2845" target="_blank"> [링크]</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int L = readInt(); // 1m^2당 사람수
        int C = readInt(); // 면적
        int count = L * C; // 전체 사람 수

        StringBuilder sb = new StringBuilder();
        int diff;
        for (int i=0; i<5; i++) {
            diff = readInt() - count;
            sb.append(diff).append(' ');
        }
        System.out.print(sb);
    }
```
- 첫줄 입력받은 값을 곱한다. (상근이가 본 전체 사람 수)
- 각 언론사 발표 참석자수로부터 상근이가 본 사람수를 빼고, 이를 sb에 붙인다.

---

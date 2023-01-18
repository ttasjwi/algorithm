# \[BOJ 03003\] 킹, 퀸, 룩, 비숍, 나이트, 폰

- 난이도 : Bronze5
- 단순 사칙연산
- 문제 : <a href="https://www.acmicpc.net/problem/3003" target="_blank"> [링크]</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException  {
        int[] counts = new int[]{1,1,2,2,2,8};

        StringBuilder sb = new StringBuilder();
        int diff;
        for (int i=0; i<6; i++) {
            diff = counts[i] - readInt();
            sb.append(diff).append(' ');
        }
        System.out.print(sb);
    }
```
- 배열 6칸을 말의 갯수만큼 준비해둔다.
- 입력을 받을 때마다 보유한 말의 갯수만큼 제하고, 그 차를 Sb에 append 한다.
---

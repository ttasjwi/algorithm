
# \[BOJ 01264\] 모음의 개수

- 난이도 : Bronze4
- 각 라인을 읽고 모음의 갯수 구하기
- 문제: <a href="https://www.acmicpc.net/problem/1264" target="_blank"> [링크]</a>

---

## 풀이
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;

        int count;

        while(!(line = br.readLine()).equals("#")) {
            count = 0;

            for (char ch : line.toCharArray()) {
                switch (ch) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        count ++;
                        break;
                    default:
                        break;
                }
            }
            sb.append(count).append('\n');
        }
        br.close();

        System.out.print(sb);
    }

}
```
- 라인 단위로 읽기. 만약 라인 통채로 "#"이면 반복 중단
- 라인의 각 문자를 읽고 모음이면 count를 증가시킨 뒤 라인별 count를 StringBuilder에 누적
- 마지막에 StringBuilder 출력

---

## 시간 복잡도
- 라인별 문자열의 최대 길이를 M이라 하고, 라인의 갯수를 N이라 하면 시간복잡도는 O(MN)

---

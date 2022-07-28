
# \[BOJ_01032\] 명령 프롬프트

- 난이도 : Bronze1
- 문자열 처리
- 문제: <a href="https://www.acmicpc.net/problem/1032" target="_blank"> [링크]</a>

---

## 풀이
```java
  StringBuilder sb = new StringBuilder();

  char ch;
  for (int j = 0; j < words[0].length(); j++) {
      ch = words[0].charAt(j);

      for (int i = 1; i < n; i++) {
          if (words[i].charAt(j) != ch) {
              ch = '?';
              break;
          }
      }
      sb.append(ch);
  }
  System.out.print(sb);
}
```
- 각 자리별로 순차적으로 비교하여 하나라도 다르면 '?'를 StringBuilder에 append 한다.
- 다른게 없으면 정상적으로 문자를 append

---

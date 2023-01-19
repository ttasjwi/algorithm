# 문제
- 플랫폼 : 백준
- 번호 : 02338
- 제목 : 긴자리 계산
- 난이도 : Bronze 5
- 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A×B를 출력 (큰 수 A, B)
- 문제 : <a href="https://www.acmicpc.net/problem/2338" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# Python
```python
a = int(input())
b = int(input())
answers = [str(a+b), str(a-b), str(a*b)]
print('\n'.join(answers), end='')

```
- 파이썬은 정수의 범위를 고려할 필요가 없다.

---

# Java
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder()
                .append(a.add(b))
                .append('\n')
                .append(a.subtract(b))
                .append('\n')
                .append(a.multiply(b));
        System.out.print(sb);
    }
}

```
- 범위가 long을 벗어나므로 BigInteger를 써야함.

---

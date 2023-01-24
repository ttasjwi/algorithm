# 문제
- 플랫폼 : 백준
- 번호 : 10757
- 제목 : 큰 수 A+B
- 난이도 : Bronze 5
- 두 정수 A와 B를 입력받은 다음, A+B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10757" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
## Python

```python
answer = sum(map(int, input().split()))
print(answer, end='')
```
- Python은 정수 범위가 없음

## Java
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        BigInteger bi1 = new BigInteger(st.nextToken());
        BigInteger bi2 = new BigInteger(st.nextToken());

        BigInteger sum = bi1.add(bi2);
        System.out.print(sum);

    }

}
```
- 입력값이 int, long 범위를 벗어나므로 BigInteger를 사용함
- 물론, BigInteger를 사용하지 않고 자체적으로 큰 수의 합산 알고리즘을 구현할 수 있으나 이를 구현하는 행위는 코딩 테스트 준비 관점에서
학습의 범위를 벗어남

---

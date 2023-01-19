# 문제
- 플랫폼 : 백준
- 번호 : 01271
- 제목 : 엄청난 부자2
- 난이도 : Bronze 5
- 조교가 가진 돈 n과 돈을 받으러 온 생명체의 수 m이 주어지고, 생명체들에게 돈을 균등히 분배할 때 생명체 하나에게 돌아가는 돈과 남는 돈을
출력
- 문제 : <a href="https://www.acmicpc.net/problem/1271" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# Python
```python
n, m = map(int, input().split())
answers = [str(n // m), str(n % m)]
print('\n'.join(answers), end='')
```
- 파이썬은 범위를 걱정할 필요가 없음

---

# Java
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger answer1 = n.divide(m);
        BigInteger answer2 = n.mod(m);

        StringBuilder sb = new StringBuilder();
        sb.append(answer1).append('\n').append(answer2);
        System.out.print(sb);
    }

}
```
- Java는 입출력 스트레스도 어마어마하고, 값의 범위도 고려해야한다.

---

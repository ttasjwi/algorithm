# 문제
- 플랫폼 : 백준
- 번호 : 01008
- 제목 : A/B
- 난이도 : Bronze 5
- A+B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1008" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# Python
```python
a, b = map(int, input().split())
answer = a / b
print(answer, end='')
```


---

# Java
```java
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = System.in.read() - 48;
        System.in.read();
        double b = System.in.read() - 48;
        System.out.print(a/b);
    }

}

```

---

# Kotlin
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    print(st.nextToken().toInt() / st.nextToken().toDouble())
    br.close()
}
```

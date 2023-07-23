# 문제
- 플랫폼 : 백준
- 번호 : 01000
- 제목 : A+B
- 난이도 : Bronze 5
- A+B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1000" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# Python
```python
answer = sum(map(int, input().split()))
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
		int b = System.in.read() - 48;
		System.out.print(a+b);
	}
}
```
- 입출력 스트레스가 매우 심하다.
- 일단 한 글자 읽고 숫자로 변환.
- 공백 제거
- 또 한 글자 읽고 숫자로 변환
- 그리고 이걸 출력한다.

---

# Kotlin
```kotlin
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()){
    val st = StringTokenizer(readLine())
    print(st.nextToken().toInt() + st.nextToken().toInt())
}
```
- with 함수를 통해 수신객체로 System.`in`.bufferedReader 을 지정
- 입력 받아서 StringTokenizer를 통해 토큰화
- toInt를 통해 변환 후 합산
- 출력

---

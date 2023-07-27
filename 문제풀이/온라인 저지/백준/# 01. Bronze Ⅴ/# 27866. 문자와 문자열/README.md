# 문제
- 플랫폼 : 백준
- 번호 : 27866
- 제목 : 문자와 문자열
- 난이도 : Bronze 5
- S의 i번째 글자를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/27866" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# Kotlin
```kotlin
fun main() {
    val br = System.`in`.bufferedReader()
    val word = br.readLine()
    val i = br.readLine().toInt()
    print(word[i-1])
}
```
- 문제에서 말하는 i번째는 인덱스가 아니라 1,2, ... 이므로 이 순서에 주의할 것

---

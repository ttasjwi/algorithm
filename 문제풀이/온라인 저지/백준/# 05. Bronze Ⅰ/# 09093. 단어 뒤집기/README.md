# 문제
- 플랫폼 : 백준
- 번호 : 09093
- 제목 : 단어 뒤집기
- 난이도 : Bronze 1
- 각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9093" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 스택

---

# 풀이
```kotlin
fun main() {
    var t = i()
    val stack = Stack()

    fun s() {
        var c = r()
        var sep = ASCII_space
        do stack.push(c) while (!isSpace(r().also { c = it; if (isN(c)) {t--; sep = c} }))
        while(stack.isNotEmpty()) writeByte(stack.pop())
        writeByte(sep)
    }
    while(t > 0) s()
    flushBuffer()
}
```
- t가 0보다 큰 동안 다음을 반복한다.
- 문자열을 입력받고 공백 문자를 만나기 전까지 Stack에 삽입한다.
  - 공백문자가 개행문자면 '구분자'를 개행문자로 바꾸고 t를 감소시킨다.
- 스택의 요소를 하나씩 꺼내면서 출력스트림에 전달하고, 마지막에 구분자를 붙인다.
- 모두 flush 시킨다.

---

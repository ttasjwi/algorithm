# 문제
- 플랫폼 : 백준
- 번호 : 07567
- 제목 : 그릇
- 난이도 : Bronze 2
- 입력에 주어진 모양대로 그릇을 쌓을 때 최종의 전체 그릇 높이를 계산해서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/7567" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```kotlin
fun main() {
    var answer = 10

    var before = r()
    var cur: Byte
    while(true) {
        cur = r()
        if (isSpace(cur)) break
        answer += if (cur == before) 5 else 10
        before = cur
    }
    writeInt(answer)
    flushBuffer()
}
```
- 바이트를 읽으면서, 이전 바이트와 같으면 5를 더하고 틀리면 10을 더한다.
- 최종 합을 출력한다.
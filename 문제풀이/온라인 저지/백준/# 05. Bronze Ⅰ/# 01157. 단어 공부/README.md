# 문제
- 플랫폼 : 백준
- 번호 : 01157
- 제목 : 단어 공부
- 난이도 : Bronze 1
- 가장 많이 사용된 알파벳을 대문자로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1157" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 카운팅

---

# 풀이
```kotlin
fun main() {
    val c = IntArray(26)
    while(r().also {
            if (it >= 97) c[it - 97] ++
            else if (it >= 65) c[it - 65] ++
        } >= 65);

    var maxCnt = -1
    var answer = ' '
    for (i in c.indices) {
        if (c[i] > maxCnt) {
            maxCnt = c[i]
            answer = (i + 65).toChar()
        } else if (c[i] == maxCnt) {
            answer = '?'
        }
    }
    print(answer)
}
```
- 단어마다 입력을 받고 배열로 카운팅을 함.

---

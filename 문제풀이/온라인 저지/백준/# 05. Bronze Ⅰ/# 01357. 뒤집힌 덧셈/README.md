# 문제
- 플랫폼 : 백준
- 번호 : 01357
- 제목 : 뒤집힌 덧셈
- 난이도 : Bronze 1
- 정수 x,y가 주어졌을 때 각각을 뒤집은 수를 합한 값을 뒤집은 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1357" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 수학

---

# 풀이
```kotlin
fun main() {
    writeInt(rev(rev(i()) + rev(i())))
    flushBuffer()
}

private fun rev(x: Int): Int {
    var tmp = x
    var result = 0
    while (tmp > 0) {
        result = result * 10 + tmp%10
        tmp /= 10
    }
    return result
}
```
- rev 함수 : 숫자를 거꾸로 뒤집은 숫자 반환
- 숫자를 입력받아 뒤집은 뒤 합친뒤 뒤집는다.
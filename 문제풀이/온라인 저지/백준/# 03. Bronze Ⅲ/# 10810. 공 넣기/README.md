# 문제
- 플랫폼 : 백준
- 번호 : 10810
- 제목 : 공 넣기
- 난이도 : Bronze 3
- 1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10810" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() {
    val n = readInt() // 바구니 개수
    val m = readInt() // 공을 넣을 횟수

    val balls = IntArray(n+1)

    var i: Int
    var j: Int
    var k: Int
    repeat(m) {
        i = readInt()
        j = readInt()
        k = readInt()
        (i..j).forEach { balls[it] = k }
    }
    val sb = StringBuilder()
    (1..n).forEach{sb.append(balls[it]).append(' ')}
    print(sb)
}
```
- m 번 반복하는데, i/j/k를 입력받고 i부터 j까지 배열의 해당 인덱스에 k를 주입한다.
- 이를 계속 반복하고 최종적으로 1부터 n까지 모든 인덱스의 요소를 출력하면 된다

---

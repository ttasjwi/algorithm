# 문제
- 플랫폼 : 백준
- 번호 : 25305
- 제목 : 커트라인
- 난이도 : Bronze 2
- 상을 받는 커트라인을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25305" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```kotlin
fun main() {
    val check = IntArray(10001)
    var n = readInt()
    var k = readInt()
    while (n -- > 0) {
        check[readInt()] += 1
    }
    for (i in check.size -1 downTo 0) {
       if (check[i] >= 0) {
           k -= check[i]
           if (k <= 0) {
               print(i)
               return
           }
       }
    }
}
```
- 중복된 값이 들어오는 경우는 고려하지 않은 문제인 듯하다... (동점자 나오는 경우)
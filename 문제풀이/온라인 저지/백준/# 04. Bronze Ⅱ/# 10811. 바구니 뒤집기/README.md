# 문제
- 플랫폼 : 백준
- 번호 : 10811
- 제목 : 바구니 뒤집기
- 난이도 : Bronze 2
- 모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10811" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
fun main() {
    val n = readInt()
    val m = readInt()
    val baskets = IntArray(n+1)

    for (x in 1..n) {
        baskets[x] = x
    }

    var lt: Int
    var rt: Int
    var tmp: Int
    repeat(m) {
        lt = readInt()
        rt = readInt()

        while (lt < rt) {
            tmp = baskets[rt]
            baskets[rt] = baskets[lt]
            baskets[lt] = tmp

            lt += 1
            rt -= 1
        }
    }
    val sb = StringBuilder()
    for (x in 1..n) {
        sb.append(baskets[x]).append(' ')
    }
    print(sb)
}
```
- 바구니를 뒤집을 때 lt, rt를 정하고 lt, rt의 요소를 swap 후 lt, rt를 각각 전진/후진 시킨다.
  - lt가 rt보다 작을 때까지만 반복하면 된다.
- 출력

---

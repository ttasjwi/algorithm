# 문제
- 플랫폼 : 백준
- 번호 : 10813
- 제목 : 공 바꾸기
- 난이도 : Bronze 2
- 1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10813" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
fun main() {
    val n = readInt() // 바구니 갯수
    val m = readInt() // 공을 바꾸는 횟수
    val balls = IntArray(n+1)
    for (x in 1..n) {
        balls[x] = x
    }

    var i: Int
    var j: Int
    var tmp: Int
    repeat(m) {
        i = readInt()
        j = readInt()
        tmp = balls[j]
        balls[j] = balls[i]
        balls[i] = tmp
    }
    val sb = StringBuilder()
    for (x in 1..n) {
        sb.append(balls[x])
        sb.append(' ')
    }
    print(sb)
}
```
- 배열의 각 요소를 인덱스와 같은 값으로 초기화
- 입력 받는 족족 배열의 저장값을 swap
- 출력

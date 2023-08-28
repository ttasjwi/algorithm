# 문제
- 플랫폼 : 백준
- 번호 : 09184
- 제목 : 신나는 함수 실행
- 난이도 : Silver 2
- 입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9184" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
```kotlin
val w = Array(21) {Array(21) {IntArray(21)}}

fun main() {
  var a: Int
  var b: Int
  var c: Int
  val sb = StringBuilder()
  w[0][0][0] = 1
  while(true) {
    a = i()
    b = i()
    c = i()
    if (a == -1 && b == -1 && c == -1) {
      break
    }
    sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
      .append(w(a,b,c)).append('\n')
  }
  print(sb)
}

private fun w(a: Int, b:Int, c:Int): Int{
  return when {
    a <= 0 || b <= 0 || c<=0 -> w[0][0][0]
    a > 20 || b > 20 || c > 20 -> w(20, 20, 20)
    w[a][b][c] > 0 -> w[a][b][c]
    a<b && b<c -> (w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1, c)).also { w[a][b][c] = it }
    else -> (w(a-1,b,c) +w(a-1, b-1, c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)).also { w[a][b][c] = it }
  }
}
```
- a,b,c가 모두 -1이면 반복 종료
- 21칸짜리 3차원 배열 정의 후 중간 연산 결과를 저장

---

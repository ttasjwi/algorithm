# 문제
- 플랫폼 : 백준
- 번호 : 01058
- 제목 : 친구
- 난이도 : Silver 2
- 가장 유명한 사람의 2-친구의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1058" target="_blank">링크</a>

---

# 필요 지식
- 플로이드-워셜 알고리즘

---

# 풀이
```kotlin
val N: Byte = 78

fun main() {
  val n = i()
  val inf = 50
  val check = Array(n) { IntArray(n) }
  val cnt = IntArray(n)
  var maxCnt = 0
  for (s in 0 until n) {
    for (e in 0 until n) {
      check[s][e] = r().let {
        if (s == e || it == N) inf
        else {
          cnt[s] ++
          if (maxCnt < cnt[s]) maxCnt = cnt[s]
          1
        } }
    }
    r()
  }
  var alt: Int
  for (m in 0 until n) {
    for (s in 0 until n) {
      if (check[s][m] == inf) continue
      for (e in 0 until n) {
        if (s == e || check[m][e] == inf) continue
        alt = check[s][m] + check[m][e]
        if (check[s][e] > alt) {
          check[s][e] = alt
          if (check[s][e] == 2) {
            cnt[s] ++
            if (maxCnt < cnt[s]) maxCnt = cnt[s]
          }
        }
      }
    }
  }
  writeInt(maxCnt)
  flushBuffer()
}
```
- 직접 친구인 경우는 친구거리가 1이므로 2친구 갯수 카운터에 기록한다.
- 플로이드 워셜 알고리즘을 통해 친구 거리를 기록한다.
- 친구거리가 2인 경우는 거리가 더 작아질 수 없으므로 2친구 갯수 카운터에 기록한다.
- 카운터 값중 제일 큰 값을 출력한다.

---

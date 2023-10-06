# 문제
- 플랫폼 : 백준
- 번호 : 18429
- 제목 : 근손실
- 난이도 : Silver 3
- N일 동안 N개의 운동 키트를 사용하는 모든 경우 중에서, 운동 기간동안 항상 중량이 500 이상이 되도록 하는 경우의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/18429" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val k = i()
    val arr = IntArray(n) { i() }
    val check = BooleanArray(n)
    var answer = 0
    val min = 500
    var alt: Int
    fun dfs(depth: Int, cur: Int) {
        if (depth == n) {
            answer++
            return
        }
        for (i in 0 until n) {
            alt = cur + arr[i] - k
            if (!check[i] && alt >= min) {
                check[i] = true
                dfs(depth + 1, alt)
                check[i] = false
            }
        }
    }
    dfs(0, 500)
    writeInt(answer)
    flushBuffer()
}
```
- dfs 함수
  - depth : 깊이
  - cur : 현재 중량
- depth가 n이 되면 answer 증가
- 아닐 경우
  - 1,2,3,4,...n을 순회하면서 해당 키트를 사용했을 때 500 이상을 유지하는 지 확인
  - 유지 가능하면 방문처리하고 다음 깊이로 들어가 탐색 후 방문처리 해제

---

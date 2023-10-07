# 문제
- 플랫폼 : 백준
- 번호 : 15654
- 제목 : N과 M(5)
- 난이도 : Silver 3
- 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15654" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹

---

# 풀이
```kotlin
fun main() {
  val n = i()
  val m = i()
  val arr = IntArray(n) { i() }
  val check = BooleanArray(n)
  Arrays.sort(arr)
  val nums = IntArray(m)
  fun backTracking(depth: Int) {
    if (depth == m) {
      for (x in nums) writeInt(x)
      writeByte(ASCII_n)
      return
    }
    for (i in 0 until n) {
      if (!check[i]) {
        check[i] = true
        nums[depth] = arr[i]
        backTracking(depth + 1)
        check[i] = false
      }
    }
  }
  backTracking(0)
  flushBuffer()
}
```
- 숫자 목록 : arr
  - 정렬해야한다.
- 방문 배열 : check
- 결과 목록 : nums
- 백트래킹을 통해 0번, 1번, ... m-1번 위치에서의 숫자를 가지치기하여 결정한다.
  - 방문 배열을 사용하는데 위 반복 방식을 사용하면 숫자가 작은 순으로 우선적으로 방문하게 된다.

---

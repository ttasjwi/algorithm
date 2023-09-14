# 문제
- 플랫폼 : 백준
- 번호 : 02805
- 제목 : 나무 자르기
- 난이도 : Silver 2
- 나무를 집에 가져가기 위해, 절단기로 설정할 수 있는 높이의 최댓값
- 문제 : <a href="https://www.acmicpc.net/problem/2805" target="_blank">링크</a>

---

# 필요 지식
- 이분 탐색
- 매개변수 탐색

---

## 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    val arr = IntArray(n)
    var lt = 0
    var rt = 0
    for (i in 0 until n) {
        arr[i] = i()
        if (rt < arr[i]) rt = arr[i]
    }
    var answer = 0
    var mid: Int
    var sum: Long
    var success: Boolean
    var tmp: Int
    while (lt <= rt) {
        mid = (lt + rt) shr 1
        sum = 0L
        success = false
        for (e in arr) {
            tmp = e - mid
            sum += if (tmp > 0) tmp else 0
            if (sum >= m) {
                success = true
                break
            }
        }
        if (success) {
            answer = mid
            lt = mid + 1
        } else {
            rt = mid - 1
        }
    }
    print(answer)
}
```
- '나무의 최소 높이 제한'을 최대로 잡아야 하는 문제이다.
- 생존시킬 나무 높이를 lt부터 rt까지 매개변수 탐색한다
  - 초기 lt : 0
  - 초기 rt : 나무의 최대높이
- lt부터 rt까지 매개변수 탐색하면서, 조건을 만족하는지 확인하고 만족하면 answer를 갱신시킨다.
- 최대한 answer를 증가시키는 방향으로 매개변수탐색 하면서 answer를 최적화시킨다.

---

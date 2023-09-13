# 문제
- 플랫폼 : 백준
- 번호 : 01654
- 제목 : 랜선 자르기
- 난이도 : Silver 2
- 첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1654" target="_blank">링크</a>

---

# 필요 지식
- 이분 탐색
- 매개변수 탐색

---

## 풀이
```kotlin
fun main() {
    val k = i()
    val n = i()
    val arr = IntArray(k)
    var lt = 1L
    var rt = 0L
    for (i in 0 until k) {
        arr[i] = i()
        if (rt < arr[i]) rt = arr[i].toLong()
    }
    var answer = 0L
    var mid: Long
    var cnt: Long
    var success: Boolean
    while (lt <= rt) {
        mid = (lt + rt) shr 1
        success = false
        cnt = 0
        for (ln in arr) {
            cnt += (ln / mid)
            if (cnt >= n) {
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
- 입력 받을 때 길이의 최댓값을 찾아 rt로 한다.
- lt는 1로 잡는다.
- lt, rt로 매개변수 탐색을 수행한다.
  - 각각의 길이를 mid로 나눴을 때의 몫들의 합이 n 이상일 때가 성공 조건이다.
  - 성공조건을 만족하면 answer를 갱신시킨다.
  - 성공조건을 만족시키지 못 하면 rt를 mid -1 로 줄여서 success 할 수 있게 시도해본다.
  - 더 큰 mid값에서 성공할 수 있는지 시도하기 위해 lt를 mid +1로 증가시킨다.

---

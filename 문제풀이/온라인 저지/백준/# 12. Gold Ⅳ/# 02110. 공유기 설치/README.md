# 문제
- 플랫폼 : 백준
- 번호 : 02110
- 제목 : 공유기 설치
- 난이도 : Gold 4
- '가장 인접한 두 공유기 사이의 거리'를 가능한 크게 하여 공유기를 설치하려고 할 때 가장 인접한 두 공유기 사이의 최대 거리를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2110" target="_blank">링크</a>

---

# 필요 지식
- 이분 탐색
- 매개변수 탐색

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val c = i()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = i()
    }
    Arrays.sort(arr)
    var lt = 1
    var rt = arr[n-1] - arr[0]
    var mid: Int
    var cnt: Int
    var answer = 1
    var success : Boolean
    var before: Int
    while (lt <= rt) {
        mid = (lt + rt) shr 1
        cnt = 0
        success = false
        before = arr[0] - mid
        for (e in arr) {
            if (e - before >= mid) {
                cnt ++
                before = e
            }
            if (cnt >= c) {
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
- 입력을 받고, 입력받은 배열을 정렬한다.
- 우리가 구하는 것은 '공유기간 최소 인접거리'의 최댓값이다.
- lt부터 rt까지 매개변수 탐색한다.
  - 초기 lt : 1
  - 초기 rt : `arr[n-1] - arr[0]` (끝과 맨처음의 인접거리)
- 공유기를 0번 인덱스부터 순서대로 설치하면서 설치한 공유기 갯수를 센다. 이 갯수가 c 이상이 되면 성공이고, c에 못 미치면 실패다.
  - 성공하면 answer를 갱신한뒤 lt를 mid보다 1 크게 잡아 더 큰 최소 인접거리를 탐색한다.(최적화) 
  - 실패하면 rt를 mid 보다 작게 잡는다.
- 최종적으로 answer를 출력하면 된다

---

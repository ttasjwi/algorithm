# 문제
- 플랫폼 : 백준
- 번호 : 01920
- 제목 : 수 찾기
- 난이도 : Silver 4
- N개의 정수 `A[1], A[2], …, A[N]`이 주어져 있을 때, 이 안에 추가로 입력되는 정수들이 존재하는지 알아내기
- 문제 : <a href="https://www.acmicpc.net/problem/1920" target="_blank">링크</a>

---

# 필요 알고리즘
- 해시
- 이분탐색

---

# 풀이1 : 해시 사용
```kotlin
fun main() {
    var n = i()
    val s = HashSet<Int>()
    while (n-- > 0) s.add(i())
    var m = i()
    val sb = StringBuilder()
    while (m -- > 0) {
        sb.append(if (i() in s) 1 else 0).append('\n')
    }
    print(sb)
}
```
- 해시 테이블을 통해 저장하면, 이후에 접근할 때는 O(1)로 접근할 수 있어서 빠르게 해당 숫자가 존재하는 지 확인할 수 있다.

---

# 풀이2
```kotlin
fun main() {
    val n = i()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = i()
    }
    Arrays.sort(arr)

    var m = i()
    val sb = StringBuilder()

    fun bin(t: Int) {
        var lt = 0
        var rt = n-1
        var mid: Int

        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (arr[mid] == t) {
                sb.append(1).append('\n')
                return
            } else if (arr[mid] > t) {
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
        sb.append(0).append('\n')
    }

    while (m -- > 0) {
        bin(i())
    }
    print(sb)
}
```
- 이 문제의 출제의도는 이분탐색이였던 것 같다.
- 정렬 후 이분탐색을 하면서 찾고자하는 대상의 존재 여부를 파악한다.

---

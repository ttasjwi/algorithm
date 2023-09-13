# 문제
- 플랫폼 : 백준
- 번호 : 10816
- 제목 : 숫자 카드 2
- 난이도 : Silver 4
- 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10816" target="_blank">링크</a>

---

# 필요 지식
- 카운팅 정렬
- 이분 탐색

---

# 풀이

## 풀이1: 카운팅 정렬
```kotlin
fun main() {
    val counter = IntArray(20_000_001)
    var n = i()
    while (n-- > 0) {
        counter[i() + 10_000_000]++
    }
    var m = i()
    val sb = StringBuilder()
    while (m-- > 0) {
        sb.append(counter[i() + 10_000_000]).append(' ')
    }
    print(sb)
}
```
- 카운터로 카운팅
- 이후 들어온 라인의 각 요소를 카운터에서 찾아 그 숫자를 순서대로 출력

## 풀이2 : 이분탐색
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
    var t: Int
    var lb = 0
    var ub = 0
    fun lb(t: Int) {
        var lt = 0
        var rt = n - 1
        var mid: Int
        lb = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (arr[mid] == t) {
                lb = mid
                rt = mid - 1
            } else if (arr[mid] > t) {
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
    }

    fun ub(t: Int) {
        var lt = 0
        var rt = n - 1
        var mid: Int
        ub = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (arr[mid] == t) {
                ub = mid
                lt = mid + 1
            } else if (arr[mid] > t) {
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
    }
    while (m-- > 0) {
        t = i()
        lb(t)
        if (lb == -1) {
            sb.append(0).append(' ')
        } else {
            ub(t)
            sb.append(ub - lb + 1).append(' ')
        }
    }
    print(sb)
}
```
- 이분탐색을 위해 정렬한다
- 목표되는 수가 발생하는 하한을 찾는 이분탐색, 상한을 찾는 이분탐색을 각각 수행한다.
- 하한을 찾았을 때 -1로 찾아지면 상한을 찾을 필요 없이 0을 출력한다.
- 하한, 상한이 존재하면 상한 - 하한 + 1을 출력한다
- 이 방식은 카운팅 정렬보다 느리다

---

# 문제
- 플랫폼 : 백준
- 번호 : 02565
- 제목 : 전깃줄
- 난이도 : Gold 5
- 첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2565" target="_blank">링크</a>

---

# 필요 지식
- 카운팅 정렬
- 다이나믹 프로그래밍
- 이분 탐색
- LIS

# 풀이
## 풀이1: 그냥 정렬 + 이분탐색 LIS
```kotlin
fun main() {
    val n = i()
    val a = Array(n) { Line(i(), i()) }
    val lis = IntArray(n)
    a.sort()

    lis[0] = a[0].to
    var rt = 0
    var l: Int
    var r: Int
    var m: Int
    var idx: Int

    loop@for (i in 1..a.lastIndex) {
        when  {
            lis[rt] < a[i].to -> lis[++rt] = a[i].to
            lis[rt] == a[i].to -> continue
            else -> {
                l = 0
                r = rt
                idx = r
                while (l <= r) {
                    m = (l + r)/2
                    when {
                        lis[m] == a[i].to -> continue@loop
                        lis[m] < a[i].to -> { l = m + 1 }
                        else -> {
                            idx = m
                            r = m - 1
                        }
                    }
                }
                lis[idx] = a[i].to
            }
        }
    }
    print(a.size - (rt+1))
}

data class Line(val from:Int, val to: Int) :Comparable<Line> {

    override fun compareTo(other: Line): Int {
        return from - other.from
    }
}
```
- 배열에 Line 객체를 생성해서 삽입후 Line을 from 순으로 정렬한다.
- line을 순서대로 삽입하면서 to에 대해 LIS 알고리즘을 통해, 최장 증가부분수열의 길이를 구한다.
- 전체 라인 갯수에서 최장 증가부분수열의 길이를 빼면 최소의 제거할 전깃줄 갯수가 구해진다

## 풀이2: 카운팅 정렬 + 이분탐색 LIS
```kotlin
fun main() {
    val n = i()
    val a = IntArray(501)
    val lis = IntArray(n)

    for (i in 1..n) {
        a[i()] = i()
    }

    var rt = 0
    var l: Int
    var r: Int
    var m: Int
    var idx: Int

    loop@for (i in 1..500) {
        if (a[i] == 0) continue
        if (a[i] > 0 && lis[0] == 0) {
            lis[0] = a[i]
            continue
        }
        when  {
            lis[rt] < a[i] -> lis[++rt] = a[i]
            lis[rt] == a[i] -> continue
            else -> {
                l = 0
                r = rt
                idx = r
                while (l <= r) {
                    m = (l + r)/2
                    when {
                        lis[m] == a[i] -> continue@loop
                        lis[m] < a[i] -> { l = m + 1 }
                        else -> {
                            idx = m
                            r = m - 1
                        }
                    }
                }
                lis[idx] = a[i]
            }
        }
    }
    print(n - (rt+1))
}
```
- 굳이 객체를 생성하지 않고, 문제를 풀 수 있는 방법이 하나 더 있는데 카운팅 정렬이다.
- 1~500 배열을 삽입해서, 인덱스 값을 from, 저장값을 value 값을 to로 삼아서 문제를 해결할 수 있다.

## 풀이3: 다이나믹 프로그래밍 LIS
```kotlin
fun main() {
    val n = i()
    val line = IntArray(501)
    val a = IntArray(n)
    val dp = IntArray(n)

    for (i in 1..n) {
        line[i()] = i()
    }
    var tmp = 0
    for (i in 1..500) {
        if (line[i] > 0) a[tmp++] = line[i]
        if (tmp == n) break
    }

    tmp = 0
    for (i in a.indices) {
        dp[i] = 1
        for (j in 0..i - 1) {
            if (a[j] < a[i]) {
                dp[i] = maxOf(dp[j] + 1, dp[i])
            }
        }
        tmp = maxOf(tmp, dp[i])
    }
    print(n - tmp)
}
```
- DP를 이용한 LIS 구현이다.

---

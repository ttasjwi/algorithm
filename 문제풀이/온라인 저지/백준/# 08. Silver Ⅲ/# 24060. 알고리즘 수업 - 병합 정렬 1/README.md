# 문제
- 플랫폼 : 백준
- 번호 : 24060
- 제목 : 알고리즘 수업 - 병합 정렬 1
- 난이도 : Silver 3
- 배열 A에 K 번째 저장 되는 수를 출력한다. 저장 횟수가 K 보다 작으면 -1을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24060" target="_blank">링크</a>

---

# 필요 지식
- 재귀
- 병합정렬

---

# 풀이
```kotlin
var k = 0
lateinit var a: IntArray
lateinit var tmp: IntArray

fun main() {
    a = IntArray(i())
    tmp = IntArray(a.size)
    k = i()
    for (i in a.indices) a[i] = i()
    mergeSort(0, a.size - 1)

    // k번 삽입이 일어나지 않았을 경우 여기까지 옴
    print(-1)
}

private fun mergeSort(p: Int, r: Int) {
    val q: Int
    if (p < r) {
        q = (p + r) / 2

        // 분할 후 재귀적으로 각각 병합정렬
        mergeSort(p, q)
        mergeSort(q + 1, r)

        // 병합
        merge(p, q, r)
    }
}

private fun merge(p: Int, q: Int, r: Int) {
    var i = p
    var j = q + 1
    var t = 0
    // tmp에 양쪽 배열의 작은 것을 순서대로 삽입
    while (i<= q && j <= r) tmp[t++] = if (a[i] <= a[j]) a[i++] else a[j++]
    // 한쪽이라도 먼저 끝났으면 나머지를 연이어서 계속 삽입
    while (i <=q) tmp[t++] = a[i++]
    while (j<=r) tmp[t++] = a[j++]

    // tmp의 요소를 p번 인덱스부터 순차적으로 copy
    i = p
    t = 0
    while (i<=r) {
        a[i++] = tmp[t++]
        if (--k == 0) {
            // k번째 copy가 일어나면 출력
            print(a[i-1])
            System.exit(0)
        }
    }
}
```
- 배열에 실제로 삽입이 일어나는 순간마다, k를 감소시켜서, 0이 되는 시점에 출력한다.
- 다만, 끝까지 k번 삽입이 일어나지 않았다면 -1을 출력하게 된다.
- 병합 정렬에 대해 잘 알지 못 했는데, 문제를 풀면서 경험할 수 있어서 좋았다. 

---

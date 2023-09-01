# 문제
- 플랫폼 : 백준
- 번호 : 11053
- 제목 : 가장 긴 증가하는 부분 수열
- 난이도 : Silver 2
- 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11053" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍
- 이분 탐색

---

# 풀이
## 풀이1: DP - O(N^2)
```kotlin
fun main() {
  val n = i()
  val a = IntArray(n)
  val d = IntArray(n)
  for (i in a.indices) {
    a[i] = i()
  }
  var max = 0
  for (i in a.indices) {
    d[i] = 1
    for (j in 0..i - 1) {
      if (a[i] > a[j]) {
        d[i] = Math.max(d[i], d[j] + 1)
      }
    }
    if (max < d[i]) {
      max = d[i]
    }
  }
  print(max)
}
```
- `a[i]` : i번째 숫자
- `d[i]` : `a[i]` 를 마지막 수로 삼을 때, 최장길이 부분수열의 길이
- 반복
  - d[i]를 1로 초기화한다.
  - i번 인덱스 기준, 0부터 i-1 인덱스 까지 순회하면서 숫자가 a[i]보다 작으면 그 지점의 d[i]에 1을 더한값 그리고 d[i] 값중 더 큰 값을 비교하여 큰값으로 d[i]를 갱신한다.
- 마지막으로는 d[i] 값들 중 최댓값을 출력한다.
- 이 방식은 O(N^2)의 시간복잡도를 가진다.
- 이 방식은 최장길이 증가 부분수열을 구하지 못 한다

---

## 풀이2 : 이분탐색 - O(nlogn)
```kotlin
fun main() {
    val n = i()
    val a = IntArray(n)
    val lis = IntArray(n)
    for (i in a.indices) a[i] = i()

    lis[0] = a[0]
    var rt = 0

    var l: Int
    var r: Int
    var m: Int
    var idx: Int

    loop@for (i in 1..n-1) {
        if (lis[rt] < a[i]) {
            lis[++rt] = a[i]
        } else if (lis[rt] == a[i]) {
            continue
        } else {
            l = 0
            r = rt
            // 0부터 rt 사이에서, 삽입할 인덱스를 찾아야한다
            idx = r
            while (l <= r) {
                m = (l + r)/2
                if (lis[m] == a[i]) continue@loop
                else if (lis[m] < a[i]) {
                    l = m + 1
                } else {
                    idx = m
                    r = m - 1
                }
            }
            lis[idx] = a[i]
        }
    }
    print(++rt)
}
```
- 이 방식은 lis, lds의 길이를 구하는 것에 특화된 알고리즘이다. 정확한 lis를 구하지 못 한다.
- `a[i]` : 숫자 저장 배열
- `lis[i]` : lis를 저장하는 배열
- `rt` : lis의 마지막 인덱스. 즉 문제에서 구하는 답은 `rt + 1`이 된다.
- 우선 `lis[0]` 은 `a[0]` 로 초기화하고, rt도 0으로 초기화한다.
- a 배열의 요소를 1번 인덱스부터 순회하면서 다음을 수행한다.
  - `a[i]` 값이 `lis[rt]` 즉, 현재 lis의 최댓값보다 크면 rt + 1 인덱스에 a[i] 를 저장하고 rt를 1 증가시킨다.
  - `a[i]` 값이 `lis[rt]` 값과 같으면, 스킵한다. (현재 lis의 최댓값과 같으므로)
  - `a[i]` 값이 `lis[rt]` 보다 작으면, 0부터 rt까지 인덱스를 이분탐색하면서, 삽입할 위치를 찾고, 해당 인덱스에 `a[i]`를 삽입한다.
- 이렇게 반복하고 최종적으로는 `rt + 1` 를 출력하면 된다.

---

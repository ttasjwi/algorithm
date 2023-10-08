# 문제
- 플랫폼 : 백준
- 번호 : 04158
- 제목 : CD
- 난이도 : Silver 5
- 상근이와 선영이가 동시에 가지고 있는 CD의 갯수를 순서대로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4158" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 투포인터
- 이분탐색

---

# 풀이
## 풀이1: 투포인터
```kotlin
fun main() {
    var n: Int
    var m: Int
    var items: IntArray
    var p: Int
    var cur: Int
    var cnt: Int
    while (true) {
        n = i()
        m = i()
        if (n == 0 && m == 0) break
        items = IntArray(n)
        cnt = 0
        for (i in 0 until n) {
            items[i] = i()
        }
        p = 0
        for (i in 0 until m) {
            cur = i()
            while (p < n && items[p] < cur) {
                p++
            }
            if (p == n) continue
            if (items[p] == cur) {
                cnt++
                p++
            }
        }
        writeInt(cnt)
    }
    flushBuffer()
}
```
- 처음 n개 입력은 배열에 저장한다.
- 포인터를 0에 둔다.
- 나머지 m개 입력에 대하여 포인터의 요소와 현재 요소를 비교하면서, 포인터 위치를 증가시켜 나간다.
  - 현재 요소와 같으면 cnt, p 증가
  - 현재 요소가 작으면 다음 반복
  - 현재 요소가 크면 현재 요소가 작거나 같아질 때까지 p 증가
- cnt를 증가
- 이 모든 것은 테스트 케이스가 여러개 있으므로 이에 주의해서 반복한다.

## 풀이2: 해시
```kotlin
fun main() {
    var n: Int
    var m: Int
    var set: HashSet<Int>
    var cur: Int
    var cnt: Int
    while (true) {
        n = i()
        m = i()
        if (n == 0 && m == 0) break
        set = HashSet()
        cnt = 0
        for (i in 0 until n) {
            set += i()
        }
        for (i in 0 until m) {
            cur = i()
            if (set.contains(cur)) {
                cnt++
            }
        }
        writeInt(cnt)
    }
    flushBuffer()
}
```
- 해시 테이블을 사용하는 방식이다.
- 요소 접근이 O(1)로 가능하긴 하나 공간 비용을 매우 많이 잡아먹는다.

## 풀이3: 이분탐색
```kotlin
fun main() {
    var n: Int
    var m: Int
    var items: IntArray
    var cur: Int
    var cnt: Int
    var lt: Int
    var rt: Int
    var mid: Int
    while (true) {
        n = i()
        m = i()
        if (n == 0 && m == 0) break
        items = IntArray(n)
        cnt = 0
        for (i in 0 until n) {
            items[i] = i()
        }
        for (i in 0 until m) {
            cur = i()
            lt = 0
            rt = n-1
            while (lt <= rt) {
                mid = (lt + rt) shr 1
                if (items[mid] == cur) {
                    cnt ++
                    break
                } else if (items[mid] < cur) {
                    lt = mid + 1
                } else {
                    rt = mid - 1
                }
            }
        }
        writeInt(cnt)
    }
    flushBuffer()
}
```
- 현재 요소의 존재 여부를 앞의 n개 배열에서 찾아야한다.
- 그런데 이미 정렬되어 있으므로 이분탐색으로 찾아도 좋다.
# 문제
- 플랫폼 : 백준
- 번호 : 09663
- 제목 : N-Queen
- 난이도 : Gold 4
- 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9663" target="_blank">링크</a>

---

# 필요 지식
- 백 트래킹

---

# 풀이

## 풀이1: 백트래킹
```kotlin
import kotlin.math.abs

var n = 0
var answer = 0
lateinit var columns: IntArray // i번쨰 행에서 퀸이 놓인 column 번호

fun main() {
    n = i()
    columns = IntArray(n)
    back(0)
    print(answer)
}

private fun back(r: Int) {
    if (r == n) {
        answer ++
        return
    }
    loop@for (c in 0..n-1) {
        for (x in 0..r-1) {
            if (columns[x] == c) {
                continue@loop
            } else if (r-x == abs(c - columns[x])) {
                continue@loop
            }
        }
        columns[r] = c
        back(r+1)
    }
}
```
- columns 배열 선언후 `column[i]`에 i번째 행 몇번 열에 퀸을 뒀는 지 기록한다
- 각 행을 순회하면서, 몇 번 열에 퀸을 둘 지 결정해야한다.
  - 그 행 이전의 행들을 순회하면서 확인한다.
    - 어디 열에 퀸을 두었는가?
    - 같은 열에 두었다면 실패
    - 행, 열 차가 같다면 대각선에 위치한 것이므로 실패
  - 위에서 걸러지지 않았을 경우 다음 단계의 탐색을 한다.
- 끝까지 도달했을 경우, count 증가한다
- 이렇게 구한 count를 출력한다.

## 풀이2
```kotlin
fun main() {
    print(when(i()) {
        1 -> 1
        2 -> 0
        3 -> 0
        4 -> 2
        5 -> 10
        6 -> 4
        7 -> 40
        8 -> 92
        9 -> 352
        10 -> 724
        11 -> 2680
        12 -> 14200
        13 -> 73712
        14 -> 365596
        else -> 2279184
    })
}
```
- 1에서 구한걸 when 문으로 전부 하드코딩해서 출력한다.
- 당연히 이게 제일 빠르다.

---

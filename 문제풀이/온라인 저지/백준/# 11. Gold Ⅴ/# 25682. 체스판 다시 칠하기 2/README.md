# 문제
- 플랫폼 : 백준
- 번호 : 25682
- 제목 : 체스판 다시 칠하기 2
- 난이도 : Gold 5
- 지민이가 잘라낸 K×K 보드를 체스판으로 만들기 위해 다시 칠해야 하는 정사각형 개수의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25682" target="_blank">링크</a>

---

# 필요 알고리즘
- 누적합

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    val k = i()
    val k2 = k * k
    val half = k2/2
    val board = Array(n + 1) { IntArray(m + 1) }
    var flag: Boolean
    var sum: Int
    var answer = k2
    for (i in 1..n) {
        flag = i % 2 == 1
        for (j in 1..m) {
            board[i][j] =
                board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + if ((r() == 66) == flag) 0 else 1
            flag = !flag

            if (i >= k && j >= k) {
                sum = board[i][j] - board[i - k][j] - board[i][j - k] + board[i - k][j - k]
                if (sum > half) sum = k2 - sum
                if (answer > sum) answer = sum
            }
        }
        r()
    }
    println(answer)
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun r(): Int {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++].toInt()
}
```
- 1행 1열의 색을 검은색으로 가정했을 때, bWBWBWBW 가 반복되어야 한다.
- 행이 시작될 때마다 시작색깔이 바뀐다
- `board[i][j]`에는 1행 1열이 검은색이라 가정할 때 그 지점까지 새로 칠해야하는 칸의 갯수의 누적합을 저장한다
- 새로 칠해야하는 것을 어떻게 판별하는가?
  - 홀수행의 첫번째 칸은 검은색, 짝수행의 첫번째 칸은 흰색이다. 이를 표현하기 위해 행단위 반복이 시작될 때 `i%2 == 1`을 flag에 기록한다.
  - 각 칸의 입력을 받고 그 값이 B이면 true, W 이면 false로 판단한뒤 flag와 같은지 여부를 판단한다.
  - board[i][j] 에는 누적합을 구하는데, 위의 값이 true이면 0을 더하고, false이면 1을 더한다.(그 위치의 올바른 색이랑 다르면 칠해줘야함)
  - flag를 반대로 뒤집는다(Not 연산)
- k행 k열부터 시작해서 k*k 칸의 구간합(새로 칠해야하는 칸의 갯수)를 계산한 뒤, 이 값이 k*k/2 보다 크면 k*k 에서 뺀다.(1행 1열을 흰색으로 시작하는 경우도 고려하기 위함. 둘 중 더 작은 값을 answer로 갱신시키기 위함이다)
- 위의 구간합과 answer를 비교해서 더 작은 쪽을 answer로 갱신시킨다.
- answer 를 출력한다

---

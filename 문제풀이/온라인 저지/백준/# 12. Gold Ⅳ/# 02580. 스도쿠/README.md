# 문제
- 플랫폼 : 백준
- 번호 : 02580
- 제목 : 스도쿠
- 난이도 : Gold 4
- 모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/2080" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹

---

# 풀이
```kotlin
private val board = Array(9) { IntArray(9) }
private val rowCheck = Array(9){BooleanArray(10)}
private val colCheck = Array(9){BooleanArray(10)}
private val sqrCheck = Array(9){BooleanArray(10)}
private val list = ArrayList<IntArray>()
fun main() {
    for (r in 0..8) {
        for (c in 0..8) {
            board[r][c] = i()
            if (board[r][c] != 0) {
                rowCheck[r][board[r][c]] = true
                colCheck[c][board[r][c]] = true
                sqrCheck[r/3*3+c/3][board[r][c]] = true
            } else {
                list.add(intArrayOf(r,c))
            }
        }
    }
    back(0)
}

private fun back(depth: Int) {
    if (depth == list.size) {
        val sb = StringBuilder()
        for (r in 0..8) {
            for (c in 0..8) {
                sb.append(board[r][c]).append(' ')
            }
            sb.append('\n')
        }
        print(sb)
        System.exit(0)
    }
    val r = list[depth][0]
    val c = list[depth][1]
    for (i in 1..9) {
        if (rowCheck[r][i] || colCheck[c][i] || sqrCheck[r/3*3+c/3][i]) {
            continue
        } else {
            rowCheck[r][i] = true
            colCheck[c][i] = true
            sqrCheck[r/3*3+c/3][i] = true
            board[r][c] = i
            back(depth+1)
            rowCheck[r][i] = false
            colCheck[c][i] = false
            sqrCheck[r/3*3+c/3][i] = false
        }
    }
}
```
- 입력받는대로 숫자판에 기록하고, 행 단위 체크, 열단위 체크, 정사각형 단위로 1..9의 존재여부를 체크한다.
- 0이 입력된 (r,c)는 arrayList에 기록해둔다.
- 이후 리스트를 순회하면서 1..9 를 하나하나 대입하면서 백트래킹한다. 행,열,정사각형 체크에서 존재하는 값은 체크할 필요 없으니 가지치기 한다.
- 끝까지 성공적으로 진행한 케이스를 찾으면 바로 출력하면 된다.

---

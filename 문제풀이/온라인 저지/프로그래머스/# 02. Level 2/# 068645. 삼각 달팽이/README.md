# 문제
- 플랫폼 : 프로그래머스
- 번호 : 068645
- 제목 : 삼각 달팽이
- 난이도 : Level 2
- 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68645" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
class Solution {
    fun solution(n: Int): IntArray {
        val answer = IntArray((n * (n+1))shr 1)
        var row = 0
        var column = 1
        fun idx(row:Int, column:Int) = ((row * (row - 1)) shr 1) + column - 1
        var number = 1
        var cnt = n
        while (cnt > 0) {
            repeat(cnt) {
                row ++
                answer[idx(row, column)] = number++
            }
            if (--cnt == 0) break
            repeat(cnt) {
                column ++
                answer[idx(row, column)] = number++
            }
            if (--cnt == 0) break
            repeat(cnt) {
                row --
                column --
                answer[idx(row, column)] = number++
            }
            cnt --
        }
        return answer
    }
}
```
- 달팽이는 아래 방향으로 끝까지 가고, 그 다음은 오른쪽 방향으로 가고, 그 다음은 윗쪽 방향으로 끝까지 타고 올라간다.
- 이를 좀 더 정확히 따져보면 처음에는 n번 아래방향으로 가고, 그 다음은 n-1번 오른쪽 방향으로 가고, 그 다음은 n-2번 윗쪽방향으로 끝까지 간다.
- 이를 반복하다가 더 이상 이동할 수 없을 때, 횟수가 0이 될 때 멈춘다.
- 문제를 풀 때는 행/열이 전달됐을 때 인덱스를 구하는 함수를 만들었고 좀 더 편리하게 풀 수 있었다.

---

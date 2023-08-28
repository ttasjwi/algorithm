# 문제
- 플랫폼 : 백준
- 번호 : 14889
- 제목 : 스타트와 링크
- 난이도 : Silver 2
- 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14889" target="_blank">링크</a>

---

# 필요 지식
- 백 트래킹


---

# 풀이
## 풀이1
```kotlin
fun main() {
    val n = i()
    val stats = Array(n+1){IntArray(n+1)}
    val check = BooleanArray(n+1)
    var min = Integer.MAX_VALUE
    for (i in 1..n) {
        for (j in 1..n) {
            stats[i][j] = i() // 점수를 저장
        }
    }

    fun back(depth: Int, from: Int) {
        if (depth == n / 2) { // 절반 선택했을 때
            var start = 0
            var link = 0
            for (i in 1..n-1) { // 모든 조합을 순회
                for (j in i+1..n) {
                    if (check[i] && check[j]) { // 둘다 선택되어 있는 부분은 start
                        start += stats[i][j] + stats[j][i]
                    } else if (!check[i] && !check[j]) { // 둘다 선택되어 있지 않은 부분은 link 
                        link += stats[i][j] + stats[j][i]
                    }
                }
            }
            val diff = Math.abs(start - link) // 차의 절댓값을 계산
            if (diff == 0) {
                print(0) // 0인경우 무조건 최솟값이므로 바로 출력 후 종료
                System.exit(0)
            }
            if (min > diff) {
                min = diff
            }
            return
        }
        for (i in from..n) {
            if (!check[i]) { // 체크되어 있지 않았을 떄
                check[i] = true
                back(depth + 1, i + 1) // 체크한 경우를 순회
                check[i] = false // 다시 원상 복귀
            }
        }
    }

    back(0, 1)
    print(min)
}
```
- 1부터 n까지, start 팀에 참여할 지 여부를 결정하는데 이 과정에서 가지치기를 한다.
  - 이미 팀에 포함되어 있는 경우 더 이상 탐색하지 않는다.
  - 선택했다면 큰 수만 추가로 가지치기 하면 된다.
- 최종적으로 n/2 만큼 선택했을 때 체크된 것끼리 조합하여 start점수를 합산하고, 체크되지 않은 것끼리 조합하여 link 점수를 합산한다.
- 둘의 차를 구하여 min을 갱신

## 풀이2
```kotlin
fun main() {
    val n = i()
    val sumRow = IntArray(n)
    val sumColumn = IntArray(n)
    var result = Integer.MAX_VALUE
    var sumTotal = 0
    var num: Int

    for (i in 0 until n) {
        for (j in 0 until n) {
            num = i()
            sumTotal += num
            sumRow[i] += num
            sumColumn[j] += num
        }
    }

    val mid = n/2
    var diff: Int
    fun back(idx: Int, cnt: Int, sumTotal: Int) {
        // idx : 현재 인덱스
        // cnt : 몇 번째 선택?
        if (cnt == mid) {
            diff = Math.abs(sumTotal) // 이 시점의 sumDiff 절댓값은 팀A, 팀B의 점수 차와 같다
            if (diff == 0) {
                print(0)
                System.exit(0)
            }
            if (result > diff) {
                result = diff
            }
            return
        }
        if (idx == n) {
            // idx 값이 n이 되도록 충분히 조합을 못 채웠을 때
            return
        }
        // 현재 요소를 조합에 포함시킬 때
        back(idx + 1, cnt +1, sumTotal - sumRow[idx] - sumColumn[idx])
        // 현재 요소를 조합에 포함시키지 않을 때
        back(idx + 1, cnt, sumTotal)
    }

    back(0, 0, sumTotal)
    print(result)
}
```
- board에 점수 저장을 하지 않는다.
- 대신, 각 행의 점수합, 각 열의 점수합, 전체 점수합을 기록해둔다.
- 0번 인덱스부터 순서대로 순회하여, 해당 인덱스를 선택한 경우와 선택하지 않은 경우 두 가지로 가지치기 한다.
  - 이 때, 해당 번호를 선택하는 경우는 sumTotal에서 해당 행, 해당 열의 합을 차감한다.
  - 이 방식을 반복하면, 조합에 택해진 요소들은 두번 차감되기 때문에 그들 자체만 놓고 보면 음수가 된다.
  - 반대로 조합에 택해지지 않은 요소들은 차감되지 않는다.
  - 최종 결과는 (-start팀의 합 + link팀의 합), 즉 두 팀의 점수 합의 차가 된다.
- 최종적으로 min과 두 팀 점수 합의 차를 비교하여 작은 쪽으로 min을 갱신한다.
- 이 방식은 1번 방식과 비교했을 때 조합을 별도로 계산하지 않고 최소한의 반복을 할 수 있어서 더 빠르다.

---

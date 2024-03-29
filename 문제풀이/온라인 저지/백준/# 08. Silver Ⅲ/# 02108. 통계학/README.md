# 문제
- 플랫폼 : 백준
- 번호 : 02108
- 제목 : 통계학
- 난이도 : Silver 3
- 주어진 숫자들의 산술평균, 중앙값, 최빈값, 범위 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2108" target="_blank">링크</a>

---

# 필요 알고리즘
- 수학
- 구현
- 정렬

---

# 풀이
```kotlin
fun main() {
        val n = i()
        val counter = IntArray(8001)
        var v: Int
        var avg = 0
        var min = 4001
        var max = -4001
        for (i in 1..n) {
            v = i()
            counter[v + 4000] ++
            avg += v
            if (max < v) max = v
            if (min > v) min = v
        }
        avg = (avg/n.toDouble()).roundToInt()


        var cnt = 0
        var mode = -4001
        var modeCnt = 0
        var duplicate = false
        var mid = 4001
        for (i in min+4000..max+4000) {
            if (counter[i] > 0) {
                cnt += counter[i]
                if (mid == 4001 && cnt > n/2) {
                    mid = i - 4000
                }
                if (counter[i] > modeCnt) {
                    mode = i - 4000
                    modeCnt = counter[i]
                    duplicate = false
                } else if (counter[i] == modeCnt && !duplicate) {
                    mode = i - 4000
                    duplicate = true
                }
            }
        }
        val sb = StringBuilder()
        sb.append(avg).append('\n')
            .append(mid).append('\n')
            .append(mode).append('\n')
            .append(max-min)
        print(sb)
    }
```
- 입력 유효범위인 -4000부터 4000까지 등장하는 족족 배열에 카운팅한다.
  - 합 누적 -> 평균을 구할 수 있다.
  - 최대 최소 갱신 -> 범위를 구할 수 있다.
- 다시 최소범위부터 최대범위까지 배열을 순회하며 중앙값, 최빈값을 탐색한다.
  - 최빈값의 경우, 동일한 값이 두번째 나타낼 경우 해당값을 반환하도록 행야하므로 mode_duplicated 변수를 사용하여 재등장한 변수를 처리하도록
  하였다.
- 이렇게 모인 결과물들을 출력한다.

---

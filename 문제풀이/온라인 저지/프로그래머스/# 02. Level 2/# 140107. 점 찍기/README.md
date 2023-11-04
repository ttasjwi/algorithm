# 문제
- 플랫폼 : 프로그래머스
- 번호 : 140107
- 제목 : 점찍기
- 난이도 : Level 2
- 정수 k와 원점과의 거리를 나타내는 정수 d가 주어졌을 때, 점이 총 몇 개 찍히는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/140107" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 이분탐색

---

# 풀이
```kotlin
import kotlin.math.sqrt

class Solution {
    fun solution(k: Int, d: Int): Long {
        val md2 = d.toLong() * d.toLong()
        fun d2(x: Int, y: Int): Long {
            val lx = x.toLong()
            val ly = y.toLong()
            return lx * lx + ly * ly
        }
        fun count(startEx: Int, endIn: Int) = (endIn - startEx)/k

        var answer: Long = 0
        val maxStart = sqrt(md2/2.0).toInt()
        answer += count(0, maxStart) + 1
        var d2: Long
        for (start in 0..maxStart step k) {
            var lt = start
            var rt = d
            var end = -1
            loop@while (lt <= rt) {
                val mid = (lt + rt) shr 1
                d2 = d2(mid, start)
                if (d2 == md2) {
                    end = mid
                    break@loop
                } else if (d2 < md2) {
                    lt = mid + 1
                    end = mid
                } else {
                    rt = mid - 1
                }
            }
            answer += count(start, end) shl 1
        }
        return answer
    }

}
```
- 1사분면에 위치한 사분원에 대해 y=x 를 기점으로 점이 발생하는 위치는 대칭이다.
- 문제에서 구하는 답은 (y=x 상에 놓인 점의 개수) + (y=x 아래의 점의 갯수 * 2) 이다.
- `count(startEx, endIn)` : start 초과 endIn 이하 범위 내에서 k를 증가시켜가면서 셌을 때의 점의 갯수
- `maxStart` : y=x와의 교점은 sqrt(k*k / 2.0) 인데 이 값의 소숫점 아래를 버린 정숫값
- y= x 상에 놓인 점의 갯수는 0부터 maxStart까지 k를 증가시켜가며 센 점의 갯수이다. 이 값은 `count(0, maxStart) + 1` 로 계산한다.
- y= x 아래에 놓인 점의 갯수는
  - start : 0 <= start <= maxStart 범위 내에서 k씩 증가시킨 위치의 점들(시작점)
  - start 이상 d 내에서 이분탐색을 하여, 원 안에 있을 수 있는 최대 범위값 end를 찾는다.
  - start 초과 end 미만의 점의 갯수 * 2 를 한 뒤 answer에 합산한다.
- 최종적으로 answer를 반환하면 된다.

---

# 문제
- 플랫폼 : 프로그래머스
- 번호 : 178870
- 제목 : 연속된 부분 수열의 합
- 난이도 : Level 2
- 배열에서 연속된 부분수열의 합이 조건과 같으면서, 길이가 최소이고, 시작점이 그 중에서 가장 짧을 때 수열의 시작/끝 인덱스 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/178870" target="_blank">링크</a>

---

# 필요 지식
- 누적합
- 이분탐색
- 투포인터

---

# 풀이
## 풀이1: 이분탐색
```kotlin
class Solution1 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val sum = IntArray(sequence.size)
        sum[0] = sequence[0]
        for (i in 1..sequence.lastIndex) {
            sum[i] = sum[i-1] + sequence[i]
        }
        var minGap = -1
        val answer = IntArray(2)
        for (start in sum.indices) {
            var lt = start
            var rt = sum.lastIndex
            var end = -1
            while (lt <= rt) {
                val mid = (lt + rt) shr 1
                val currentSum = if (start == 0) sum[mid] else sum[mid] - sum[start - 1]
                if (currentSum == k) {
                    end = mid
                    break
                } else if (currentSum > k) {
                    rt = mid - 1
                } else {
                    lt = mid + 1
                }
            }
            if (end !== -1) {
                val gap = end - start
                if (minGap == -1 || gap < minGap || (gap == minGap && start < answer[0])) {
                    answer[0] = start
                    answer[1] = end
                    minGap = gap
                }
            }
        }
        return answer
    }
}
```
- 0,1,2,...마지막 인덱스까지 자기 자신을 시작점으로 잡고 끝점을 이분탐색으로 찾는다.
- 시작점~끝점의 합은 누적합을 이용해 계산하면 빠르게 계산할 수 있다.
- 이 풀이는 시간복잡도가 O(nlogn)이 된다.

## 풀이2: 투포인터
```kotlin
class Solution2 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var lt = 0
        var rt = 0
        val answer = IntArray(2)
        var minGap = -1
        var gap: Int
        var sum = sequence[0]
        while (lt <= rt && rt < sequence.size) {
            if (sum == k) {
                gap = rt - lt
                if (minGap == -1 || gap < minGap || (gap == minGap && lt < answer[0])) {
                    answer[0] = lt
                    answer[1] = rt
                    minGap = gap
                }
                sum -= sequence[lt++]
                if (rt != sequence.lastIndex) sum += sequence[++rt]
            } else if (sum > k) {
                sum -= sequence[lt++]
            } else {
                if (rt != sequence.lastIndex) sum += sequence[++rt]
                else break
            }
        }
        return answer
    }
}
```
- 시작점, 끝점을 전진시켜가는 방법이다.
- 시간 복잡도는 O(n)이 된다.

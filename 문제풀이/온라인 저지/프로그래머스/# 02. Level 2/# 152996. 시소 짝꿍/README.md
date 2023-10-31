# 문제
- 플랫폼 : 프로그래머스
- 번호 : 152996
- 제목 : 시소 짝꿍
- 난이도 : Level 2
- 사람들의 몸무게 목록 weights 가 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/152996" target="_blank">링크</a>

---

# 필요 지식
- 메모이제이션
- 해시

---

# 풀이
## 풀이1 : 실패
```kotlin
class Solution {
    val rates = arrayOf(intArrayOf(4,3), intArrayOf(3,2), intArrayOf(2,1))
    
    fun solution(weights: IntArray): Long {
        var answer = 0L
        var max: Int
        var min: Int
        for (lt in weights.indices) {
            for (rt in lt+1..weights.lastIndex) {
                if (weights[lt] == weights[rt]) answer ++
                else {
                    if (weights[lt] > weights[rt]) {
                        max = weights[lt]
                        min = weights[rt] 
                    } else {
                        max = weights[rt]
                        min = weights[lt]
                    }
                    for (rate in rates) {
                        if (rate[0] * min == rate[1] * max) {
                            answer ++
                            break
                        }
                        else if (rate[0] * min > rate[1] * max) break
                    }
                }
            }
        }
        return answer
    }
    
    
}
```
- O(N2) 로 탐색하다보니 시간 초과가 난다.
- O(N)으로 풀 수 있는 방법을 고려해야한다.

## 풀이2: 메모이제이션
```kotlin
class Solution {

    val rates = doubleArrayOf(4.0/3.0, 3.0/2.0, 2.0, 3.0/4.0, 2.0/3.0, 0.5, 1.0)

    fun solution(weights: IntArray): Long {
        val counter = HashMap<Double, Int>()

        var answer = 0L
        var v = 0.0
        for (weight in weights) {
            for (rate in rates) {
                v = weight * rate
                if (counter.containsKey(v)) {
                    answer += counter[v]!!
                }
            }
            if (counter.containsKey(v)) {
                counter[v] = counter[v]!! + 1
            } else {
                counter[v] = 1
            }
        }
        return answer
    }
}
```
- 카운터 : 그 숫자의 등장 횟수
- 배열을 순회하면서, 무게 값에 대해 1.33배, 1.5배, 2배, 0.75배, 0.66배, 0.5배, 1배한 숫자(시소 친구)가 카운터에 있으면 answer에 그 숫자의 등장횟수만큼 증가시킨다.
- 자기 자신을 카운터 값에 누적한다.

---

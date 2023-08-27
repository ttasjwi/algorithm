# 문제
- 플랫폼 : 백준
- 번호 : 14888
- 제목 : 연산자 끼워넣기
- 난이도 : Silver 1
- N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/14888" target="_blank">링크</a>

---

# 필요 알고리즘
- 백 트래킹

---

# 풀이
```kotlin
var n = 0
lateinit var nums: IntArray
val oc = IntArray(4)
var min = Integer.MAX_VALUE
var max = Integer.MIN_VALUE

fun main() {
    n = i()
    nums = IntArray(n)
    for (i in nums.indices) nums[i] = i()
    for (i in oc.indices) oc[i] = i()
    back(0, nums[0])
    println(max)
    print(min)
}

private fun back(depth: Int, v: Int) {
    if (depth == n-1) {
        if (v > max) max = v
        if (v < min) min = v
        return
    }
    for (i in oc.indices) {
        if (oc[i] > 0) {
            oc[i] --
            when(i) {
                0 -> back(depth + 1, v + nums[depth +1])
                1 -> back(depth + 1, v - nums[depth +1])
                2 -> back(depth + 1, v * nums[depth +1])
                else -> back(depth + 1, v / nums[depth +1])
            }
            oc[i] ++
        }
    }
}
```
- 숫자들, 연산자 갯수들을 저장
- 매 인덱스마다 연산자를 선택하여 재귀적으로 연산 반복(잔여량이 허락하는 내에서)

---

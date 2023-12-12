# 문제
- 플랫폼 : 백준
- 번호 : 01168
- 제목 : 트로피 진역
- 난이도 : Bronze 2
- 왼쪽에서 봤을 때 보이는 개수, 둘째 줄에 오른쪽에서 봤을 때 보이는 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1168" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val nums = IntArray(n)
    for (i in 0 until n) {
        nums[i] = i()
    }
    var left = 0
    var right = 0
    var before = -1

    for (i in 0 until n) {
        if (before < nums[i]) {
            left ++
            before = nums[i]
        }
    }
    before = -1
    for (i in n-1 downTo 0) {
        if (before < nums[i]) {
            right ++
            before = nums[i]
        }
    }
    writeInt(left)
    writeByte(ASCII_n)
    writeInt(right)
    flushBuffer()
}
```
- 배열에 순서들을 모두 담고
- 왼쪽에서부터 순서대로 비교하면서 증가할 경우 left 값 증가
- 오른쪽부터 순서대로 비교하면서 증가할 경우 right 값 증가

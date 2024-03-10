# 문제
- 플랫폼 : 백준
- 번호 : 02303
- 제목 : 숫자 게임
- 난이도 : Silver 5
- 게임에서 이긴 사람의 번호를 첫 번째 줄에 출력(이긴 사람이 두 명 이상일 경우에는 번호가 가장 큰 사람의 번호를 출력)
- 문제 : <a href="https://www.acmicpc.net/problem/2303" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var nums: IntArray
    var maxPersonNumber = 0
    var maxSumEnd = 0
    var sumEnd: Int
    for (x in 1..n) {
        nums = IntArray(5)
        for (i in 0 until 5) {
            nums[i] = i()
        }
        for (i in 0 until 5) {
            for (j  in i+1 until 5) {
                for (k in j+1 until 5) {
                    sumEnd = (nums[i] + nums[j] + nums[k])%10
                    if (sumEnd >= maxSumEnd) {
                        maxSumEnd = sumEnd
                        maxPersonNumber = x
                    }
                }
            }
        }
    }
    writeInt(maxPersonNumber)
    flushBuffer()
}
```
- 한 줄씩 읽기
- 3중 반복문을 돌려서, 3개의 숫자 합을 구하고 끝자리 합이 가장 큰 끝자리 합보다 크거나 같은 지 확인
- 크거나 같으면 가장 큰 끝자리 합을 갱신하고, 사람 번호를 갱신
- 사람 번호를 출력

---

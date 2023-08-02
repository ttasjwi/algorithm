# 문제
- 플랫폼 : 백준
- 번호 : 05073
- 제목 : 삼각형과 세 변
- 난이도 : Bronze 3
- 각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5073" target="_blank">링크</a>

---

# 필요 지식
- 기하

---

# 풀이
```kotlin
import java.util.*

fun main() {
    val nums = IntArray(3)

    val sb = StringBuilder()
    while (true) {
        nums[0] = readInt()
        nums[1] = readInt()
        nums[2] = readInt()

        if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
            break
        }
        Arrays.sort(nums)
        sb.append(
            when {
                nums[0] == nums[2] -> "Equilateral\n"
                nums[2] >= nums[0] + nums[1] -> "Invalid\n"
                nums[0] == nums[1] || nums[1] == nums[2] -> "Isosceles\n"
                else -> "Scalene\n"
            }
        )
    }
    print(sb)
}
```
- 입력을 받고, 모두 0이면 탈출
- 숫자값들을 정렬하고 when 문으로 분기처리

---

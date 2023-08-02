# 문제
- 플랫폼 : 백준
- 번호 : 14215
- 제목 : 세 막대
- 난이도 : Bronze 3
- 첫째 줄에 만들 수 있는 가장 큰 삼각형의 둘레를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14215" target="_blank">링크</a>

---

# 필요 지식
- 정렬
- 기하

---

# 풀이
```kotlin
fun main() {
    val nums = IntArray(3)
    nums[0] = readInt()
    nums[1] = readInt()
    nums[2] = readInt()
    Arrays.sort(nums)

    print(nums[0] + nums[1] + if (nums[2] < nums[0] + nums[1]) nums[2] else nums[0] + nums[1] - 1)
}
```
- 숫자들을 정렬
- 제일 큰 값이 나머지 두 변의 길이 합보다 커야함
- 제일 큰 변의 길이가 나머지 두 변의 길이 합보다 작으면 그대로 전부 더함
  - 아닐 경우 제일 큰 변의 길이를 `나머지 두 변의 길이 합 - 1` 까지 줄여야한다.

---

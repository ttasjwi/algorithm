# 문제
- 플랫폼 : 백준
- 번호 : 02750
- 제목 : 수 정렬하기
- 난이도 : Bronze 2
- 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2750" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이

## 풀이1 - 카운팅 정렬 - O(n)
```kotlin
fun main() {
    val check = BooleanArray(2001)
    var n = readInt()
    while (n-- > 0) {
        check[readInt() + 1000] = true
    }

    val sb = StringBuilder()
    for (i in check.indices) {
        if (check[i]) {
            sb.append(i-1000).append('\n')
        }
    }
    print(sb)
}
```
- boolean 배열을 받아서, 값이 들어오면 해당 인덱스의 요소를 true로 변경
- 배열 처음부터 순회하면서, ture인 부분만 출력

## 풀이2 - 선택 정렬 - O(n2)
```kotlin
fun main() {
    val nums = IntArray(readInt())
    for (i in nums.indices) {
        nums[i] = readInt()
    }
    var min: Int
    var minIdx: Int
    for (i in 0 until nums.size) {
        min = nums[i]
        minIdx = i
        for (j in i + 1 until nums.size) {
            if (min > nums[j]) {
                min = nums[j]
                minIdx = j
            }
        }
        nums[minIdx] = nums[i]
        nums[i] = min
    }
    val sb = StringBuilder()
    for (i in nums.indices) {
        sb.append(nums[i]).append('\n')
    }
    print(sb)
}
```
- 매 인덱스 시점마다 이후 오는 숫자들 중 최솟값을 찾아 해당 위치에 배치하는 방식이다.
- 시간 복잡도 O(n2)이고 그리 좋지 못 한 방식이다

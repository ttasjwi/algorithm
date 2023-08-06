# 문제
- 플랫폼 : 백준
- 번호 : 01427
- 제목 : 소트인사이드
- 난이도 : Silver 5
- 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1427" target="_blank">링크</a>

---

# 필요 지식
- 카운팅 정렬

---

# 풀이
```kotlin
fun main() {
    val counter = IntArray(10)
    countNums(counter)
    val sb = StringBuilder()
    for (i in counter.indices.reversed()) {
        while (counter[i] --> 0) {
            sb.append(i)
        }
    }
    print(sb)
}

private fun countNums(counter: IntArray) {
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return
            else -> counter[input - 48] ++
        }
    }
}
```
- 숫자를 입력받고 카운팅
- 역순으로 출력

---

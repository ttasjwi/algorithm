# 문제
- 플랫폼 : 백준
- 번호 : 02751
- 제목 : 수 정렬하기 2
- 난이도 : Silver 5
- 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2751" target="_blank">링크</a>

---

# 필요 지식
- 카운팅 정렬

---

# 풀이
```kotlin
fun main() {
    var n = readInt()
    val check = BooleanArray(2_000_001)
    while (n -- > 0) {
        check[readInt() + 1_000_000] = true
    }
    val sb = StringBuilder()
    for (i in check.indices) {
        if (check[i]) {
            sb.append(i-1_000_000).append('\n')
        }
    }
    print(sb)
}
```
- Boolean 형식의 배열에 카운팅

---
